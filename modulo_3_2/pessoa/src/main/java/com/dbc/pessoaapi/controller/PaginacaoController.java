package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paginacao")
public class PaginacaoController {
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/contatos-pela-descricao")
    public Page<ContatoEntity> contatosPelaDescricao(@RequestParam Integer pagina,
                                                     @RequestParam Integer quantidadePorPaginas){
        Pageable pageable = PageRequest.of(pagina, quantidadePorPaginas, Sort.by("descricao"));
        Page<ContatoEntity> paginaBanco = contatoRepository.findAll(pageable);

        return paginaBanco;
    }

    @GetMapping("/endereco-ordenado-por-cep")
    public Page<EnderecoEntity> enderecoOrdenadoPorCep(@RequestParam Integer paginas,
                                               @RequestParam Integer quantidadePorPaginas){
        Pageable pageable = PageRequest.of(paginas, quantidadePorPaginas, Sort.by("cep"));
        Page<EnderecoEntity> paginaBanco = enderecoRepository.findAll(pageable);
        return paginaBanco;

    }

    @GetMapping("/endereco-filtrado-pelo-pais")
    public Page<EnderecoEntity> enderecoPorPais(@RequestParam (required = false) String nome,
                                             @RequestParam Integer paginas,
                                             @RequestParam Integer quantidadePorPaginas){
        Pageable pageable = PageRequest.of(paginas, quantidadePorPaginas);
        Page<EnderecoEntity> paginaBanco = enderecoRepository.enderecoPorPais("%"+ nome + "%", pageable);
        return paginaBanco;

    }
}
