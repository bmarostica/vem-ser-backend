package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTATO")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQUENCE")
    @SequenceGenerator(name = "CONTATO_SEQUENCE", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;

    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "TIPO")
    private Integer tipoContato;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO")
    private String descricao;
}
