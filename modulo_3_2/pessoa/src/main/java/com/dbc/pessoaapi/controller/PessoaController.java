package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.PessoaService;
import feign.Param;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
@Slf4j
public class PessoaController {

    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;


    @ApiOperation(value = "Cria uma pessoa nova")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada"),
            @ApiResponse(code = 400, message = "Erro, informação inserida inválida"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        log.info("Criando pessoa...");
        PessoaDTO people = pessoaService.create(pessoaCreateDTO);
        log.info("Pessoa criada com sucesso!");
        return people;
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de pessoas retornada com sucesso"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @ApiOperation(value = "Retorna uma lista de pessoas")
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa atualizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro, informação inserida inválida"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @ApiOperation(value = "Atualiza uma pessoa pelo ID informado")
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @RequestBody @Valid PessoaDTO pessoaAtualizar) throws Exception {
        log.info("Alterando pessoa...");
        PessoaDTO people = pessoaService.update(id, pessoaAtualizar);
        log.info("Pessoa alterada com sucesso!");
        return people;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa Deletada com sucesso"),
            @ApiResponse(code = 400, message = "Erro, ID informado inválido"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @ApiOperation(value = "Deleta uma pessoa pelo ID informado")
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando pessoa...");
        pessoaService.delete(id);
        log.info("Pessoa deletada com sucesso!");
    }


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa localizada com sucesso"),
            @ApiResponse(code = 400, message = "Erro, ID informado inválido"),
            @ApiResponse(code = 500, message = "Exceção gerada.")
    })
    @ApiOperation("Busca pessoa pelo ID informado")
    @GetMapping("/{id}")
    public PessoaDTO buscarPorId(@PathVariable("id") Integer id) throws RegraDeNegocioException {
        log.info("Buscando pessoa...");
        PessoaDTO pessoaDTO = pessoaService.getById(id);
        log.info("Busca realizada com sucesso! ");

        return pessoaDTO;
    }

    @GetMapping("/find-by-nome-containing-ignore-case")
    public List<PessoaEntity> findByNomeContainingIgnoreCase(@RequestParam("nome") String nome){
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/find-by-cpf")
    public PessoaEntity findByCpf(@RequestParam("cpf") String cpf){
        return pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/find-by-data-de-nascimento")
    public List<PessoaEntity> findByDataNascimentoBetween(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                                                          @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim){
        return pessoaRepository.findByDataNascimentoBetween(inicio, fim);
    }


    @GetMapping("/list-com-contato")
    public List<PessoaComContatoDTO> listComContato(@RequestParam (required = false) Integer id) throws RegraDeNegocioException {
        return pessoaService.listComContato(id);
    }

    @GetMapping("/list-com-endereco")
    public List<PessoaComEnderecoDTO> listComEndereco(@RequestParam (required = false) Integer id) throws RegraDeNegocioException{
        return pessoaService.listComEndereco(id);
    }

    @GetMapping("/localizar-nascimento-com-data-entre-jpql")
    public List<PessoaEntity> findByDataNascimentoComQueryJPQL(@RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
                                                        @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim){
        return pessoaRepository.findByDataNascimentoComQueryJPQL(inicio, fim);
    }

    @GetMapping("/localizar-pessoa-com-enderecos-jpql")
    public List<PessoaEntity> findByPessoaComEnderecosComQueryJPQL(){
        return pessoaRepository.findByPessoaComEnderecosComQueryJPQL();
    }

    @GetMapping("/localizar-pessoa-sem-endereco-com-query-nativa")
    public List<PessoaEntity> findByPessoaQueNaoPossueEnderecoComQueryNativa(){
        return pessoaRepository.findByPessoaQueNaoPossueEnderecoComQueryNativa();
    }

    @GetMapping("/pessoa-completo")
    public List<PessoaComContatoEnderecoDTO> listComContatoEEndereco(){
        return pessoaService.listComContatoEEndereco();
    }
}
