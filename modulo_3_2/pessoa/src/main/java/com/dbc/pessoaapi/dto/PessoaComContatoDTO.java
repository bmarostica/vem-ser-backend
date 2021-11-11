package com.dbc.pessoaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaComContatoDTO extends PessoaDTO{

    private List<ContatoDTO> contatos;
}
