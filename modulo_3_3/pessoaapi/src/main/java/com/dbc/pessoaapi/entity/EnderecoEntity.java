package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {

    @Id
    @Column(name = "ID_ENDERECO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQUENCE")
    @SequenceGenerator(name = "ENDERECO_SEQUENCE", sequenceName = "seq_endereco_contato", allocationSize = 1)
    private Integer idEndereco;

    @Column(name = "TIPO")
    private Integer tipo;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "PAIS")
    private String pais;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos", fetch = FetchType.LAZY)
    private Set<PessoaEntity> pessoas;

}
