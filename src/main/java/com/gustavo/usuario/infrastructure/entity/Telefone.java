package com.gustavo.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "telefone")
@Builder
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      Long id;
    @Column(name = "numero", length = 10)
      String numero;
    @Column(name = "ddd", length = 3)
      String ddd;
    @Column(name = "usuario_id")
      Long usuario_id;
}
