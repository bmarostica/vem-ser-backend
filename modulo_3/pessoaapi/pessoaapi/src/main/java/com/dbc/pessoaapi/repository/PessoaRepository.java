package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private static List<PessoaEntity> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();


//    public PessoaRepository() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
//        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910", "lala@gmail.com"));
//        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911", "lele@gmail.com"));
//        listaPessoas.add(new PessoaEntity(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912", "lulu@gmail.com"));
//    }

    public PessoaEntity create(PessoaEntity pessoaEntity) {
        pessoaEntity.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoaEntity);
        return pessoaEntity;
    }

    public List<PessoaEntity> list() {
        return listaPessoas;
    }

    public PessoaEntity update(Integer id,
                               PessoaEntity pessoaAtualizar) throws Exception {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaRecuperada.setEmail(pessoaAtualizar.getEmail());
        return pessoaRecuperada;
    }

    public void delete(Integer id) throws Exception {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        listaPessoas.remove(pessoaRecuperada);
    }

    public List<PessoaEntity> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }

    public PessoaEntity buscarPorId(Integer idPessoa) throws RegraDeNegocioException {
        PessoaEntity pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));

        return pessoaRecuperada;
    }
}
