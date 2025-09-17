package com.gustavo.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      Long id;
    @Column(name = "rua")
      String rua;
    @Column(name = "numero")
      Long numero;
    @Column(name = "complemento", length = 100)
      String complemento;
    @Column(name = "cidade", length = 150)
      String cidade;
    @Column(name = "estado", length = 2)
      String estado;
    @Column(name = "cep", length = 9)
      String cep;
    @Column(name = "usuario_id")
      Long usuario_id;

}
