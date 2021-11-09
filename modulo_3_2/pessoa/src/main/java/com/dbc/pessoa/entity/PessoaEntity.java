package com.dbc.pessoaapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PESSOA")
public class PessoaEntity {

    @Id
    @Column(name = "ID_PESSOA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQUENCE")
    @SequenceGenerator(name = "PESSOA_SEQUENCE", sequenceName = "seq_PESSOA2", allocationSize = 1)
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

}