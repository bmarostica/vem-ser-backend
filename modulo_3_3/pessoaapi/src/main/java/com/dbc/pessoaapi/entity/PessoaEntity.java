package com.dbc.pessoaapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity(name = "PESSOA")
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

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaEntity", fetch = FetchType.LAZY)
    private Set<ContatoEntity> contatos;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name =  "Pessoa_x_pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name = "id_endereco")
    )
    private Set<EnderecoEntity> enderecos;

}