package com.dbc.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ENDERECO_PESSOA")
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
}
