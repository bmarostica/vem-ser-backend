package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ContatoCreateDTO {
    @ApiModelProperty(value = "Id pessoa")
    @NotNull
    private Integer idPessoa;

    @ApiModelProperty(value = "0 para RESIDENCIAL e 1 para COMERCIAL")
    @NotNull
    private TipoContato tipoContato;

    @ApiModelProperty(value = "Número do telefone")
    @NotNull
    @NotEmpty
    @Size(max = 13, message = "Não pode possuir mais que 13 caracteres")
    private String numero;

    @ApiModelProperty(value = "Descrição para o telefone")
    @NotNull
    @NotEmpty
    private String descricao;
}
