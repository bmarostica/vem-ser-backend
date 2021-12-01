package com.dbc.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity(name = "CONTATO")
public class ContatoEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQUENCE")
    @SequenceGenerator(name = "CONTATO_SEQUENCE", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "ID_CONTATO")
    private Integer idContato;

    @Enumerated
    @Column(name = "TIPO")
    private TipoContato tipoContato;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO")
    private String descricao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    private PessoaEntity pessoaEntity;

}
