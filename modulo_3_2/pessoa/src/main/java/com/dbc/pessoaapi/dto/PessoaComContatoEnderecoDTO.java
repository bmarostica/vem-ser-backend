package com.dbc.pessoaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaComContatoEnderecoDTO extends PessoaDTO{
    private List<ContatoDTO> contatos;
    private List<EnderecoDTO> enderecos;
}
