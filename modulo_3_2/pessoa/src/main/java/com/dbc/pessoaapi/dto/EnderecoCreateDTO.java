package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {
    //private Integer idPessoa;

    @ApiModelProperty(value = "0 para RESIDENCIAL e 1 para COMERCIAL")
    @NotNull
    @Max(1)
    @Min(0)
    private Integer tipo;

    @ApiModelProperty(value = "Logradouro")
    @NotEmpty
    @Size(max = 200)
    private String logradouro;

    @ApiModelProperty(value = "Número da residência")
    @NotNull
    private Integer numero;

    @Size(max = 100)
    private String complemento;

    @ApiModelProperty(value = "CEP")
    @NotEmpty
    @Size(max = 8)
    private String cep;

    @ApiModelProperty(value = "Cidade")
    @NotEmpty
    @NotNull
    @Size(max = 200)
    private String cidade;

    @ApiModelProperty(value = "Estado")
    @NotNull
    @Size(max = 100)
    private String estado;

    @ApiModelProperty(value = "País")
    @NotNull
    @Size(max = 100)
    private String pais;
}
