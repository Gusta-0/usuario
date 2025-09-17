package com.gustavo.usuario.infrastructure.security;

import com.gustavo.usuario.infrastructure.exception.ResourceNotFoundException;
import com.gustavo.usuario.infrastructure.exception.UnauthorizedException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtRequestFilter extends OncePerRequestFilter {

    final JwtUtil jwtUtil;
    final UserDetailsService userDetailsService;

    public JwtRequestFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {

        try {
            final String authorizationHeader = request.getHeader("Authorization");


            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                final String token = authorizationHeader.substring(7);
                final String username = jwtUtil.extractUsername(token);

                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    if (jwtUtil.validateToken(token, username)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }

            chain.doFilter(request, response);

        } catch (ExpiredJwtException | MalformedJwtException e){
            throw new UnauthorizedException("Token inválido ou expirado", e.getCause());
        } catch (ServletException | IOException e) {
            throw new ResourceNotFoundException("Error ao gerar token", e);
        }
    }
}
