package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainingIgnoreCase(String nome);
    PessoaEntity findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicio, LocalDate fim);


    //Com Query JPQL
    @Query("select p " +
            " from PESSOA p " +
            " where p.dataNascimento between :inicio and :fim"
    )
    List<PessoaEntity> findByDataNascimentoComQueryJPQL(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);


    @Query("select p " +
            "from PESSOA p " +
            "join p.enderecos e"
    )
    List<PessoaEntity> findByPessoaComEnderecosComQueryJPQL();

    //Com Query Nativa
    @Query(value = "select * " +
            "from PESSOA p " +
            "left join PESSOA_X_PESSOA_ENDERECO e on (p.id_pessoa = e.id_pessoa) " +
            "where e.id_pessoa is null"
    , nativeQuery = true)
    List<PessoaEntity> findByPessoaQueNaoPossueEnderecoComQueryNativa();

}
