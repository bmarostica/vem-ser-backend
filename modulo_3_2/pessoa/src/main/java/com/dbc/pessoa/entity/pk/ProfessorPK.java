package com.dbc.pessoaapi.entity.pk;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorPK implements Serializable {

    @Column(name = "ID_PROFESSOR")
    private Integer idProfessor;

    @Column(name = "ID_UNIVERSIDADE")
    private Integer idUniversidade;

}
