package com.dbc.pessoaapi.entity;

import com.dbc.pessoaapi.entity.pk.ProfessorPK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PROFESSOR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorEntity {

    @EmbeddedId
    private ProfessorPK professorPK;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SALARIO")
    private Double salario;
}
