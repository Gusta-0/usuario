# =======================
# Etapa 1: Build
# =======================
FROM gradle:7.5-jdk17-alpine AS build
WORKDIR /app

# Copia arquivos necessários para cache de dependências
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# Baixa dependências (sem rodar testes)
RUN ./gradlew dependencies --no-daemon || return 0

# Copia o restante do código-fonte
COPY . .

# Build final (gera o jar)
RUN ./gradlew clean build -x test --no-daemon

# =======================
# Etapa 2: Runtime (imagem leve)
# =======================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia apenas o jar final
COPY --from=build /app/build/libs/*-SNAPSHOT.jar usuario.jar

# Expor porta
EXPOSE 8080

# Rodar como usuário não-root
USER 1000:1000

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "usuario.jar"]
