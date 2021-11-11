package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    //Com Query JPQL
    @Query("select e " +
            "from ENDERECO_PESSOA e " +
            "where e.pais like %:nome%"
    )
    List<EnderecoEntity> findyByPais(String nome);

    @Query("select e " +
            "from ENDERECO_PESSOA e " +
            "join e.pessoas p where p.idPessoa = :id")
    List<EnderecoEntity> findByIdPessoa(Integer id);

    //Com Query Nativa
    @Query(value = "select * " +
            "from ENDERECO_PESSOA e " +
            "where pais like %:nome% or cidade like %:nome%"
            , nativeQuery = true
    )
    List<EnderecoEntity> findByCidadeOuPais(String nome);

    @Query(value = "select * " +
            "from ENDERECO_PESSOA e " +
            "where complemento is not null"
            ,nativeQuery = true)
    List<EnderecoEntity> findBySemComplemento();
}
