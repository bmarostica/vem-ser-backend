package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
@Slf4j
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final EnderecoRepository enderecoRepository;

    @ApiOperation(value = "Cria um novo endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço criado"),
            @ApiResponse(code = 400, message = "Erro, informação inserida inválida"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @PostMapping
    public EnderecoDTO create(@RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("Criando endereço...");
        EnderecoDTO adress = enderecoService.create(enderecoCreateDTO);
        log.info("Endereço criado com sucesso");
        return adress;
    }


    @ApiOperation(value = "Lista os endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de endereços retornado com sucesso"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @GetMapping
    public List<EnderecoDTO> list(){
        return enderecoService.list();
    }



    @ApiOperation(value = "Lista os endereços pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de endereço retornado com sucesso"),
            @ApiResponse(code = 400, message = "Erro, ID informado inválido"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @GetMapping("/{idEndereco}")
    public EnderecoDTO listByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException{
        log.info("Alterando endereço...");
        EnderecoDTO adress = enderecoService.getByIdEndereco(idEndereco);
        log.info("Endereço alterado com sucesso");
        return adress;
    }


//    @ApiOperation(value = "Lista os endereços pelo ID de pessoa informado")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Lista de endereço retornado com sucesso"),
//            @ApiResponse(code = 400, message = "Erro, ID informado inválido"),
//            @ApiResponse(code = 500, message = "Exceção gerada.")
//    })
//    @GetMapping("/{idPessoa}/pessoa")
//    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
//        return enderecoService.listByIdPessoa(idPessoa);
//    }


    @ApiOperation(value = "Atualiza o endereço pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro, informação inserida inválida"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @PutMapping("/{idEndereco}")
    public EnderecoDTO update(@PathVariable("idEndereco") Integer idEndereco,
                                 @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        return enderecoService.update(idEndereco, enderecoCreateDTO);
    }

    @ApiOperation(value = "Deleta o endereço pelo ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Endereço deletado com sucesso"),
            @ApiResponse(code = 400, message = "Erro, ID informado inválido"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
        log.info("Deletando endereço...");
        enderecoService.delete(idEndereco);
        log.info("Endereço deletado com sucesso!");
    }


    @GetMapping("/localiza-o-pais")
    public List<EnderecoEntity> findyByPais(@RequestParam String nome){
        return enderecoRepository.findyByPais(nome);
    }

    @GetMapping("/localiza-endereco-pelo-id-da-pessoa-query-jpql")
    public List<EnderecoEntity> findByIdPessoa(@RequestParam Integer id){
        return enderecoRepository.findByIdPessoa(id);
    }

    @GetMapping("/localiza-por-cidade-ou-pais")
    public List<EnderecoEntity> findByCidadeOuPais(@RequestParam (required = false) String pais,
                                                   @RequestParam (required = false) String cidade){
        return enderecoRepository.findByCidadeOuPais(pais, cidade);
    }

    @GetMapping("/localiza-sem-complemento")
    List<EnderecoEntity> findBySemComplemento(){
        return enderecoRepository.findBySemComplemento();
    }
}
