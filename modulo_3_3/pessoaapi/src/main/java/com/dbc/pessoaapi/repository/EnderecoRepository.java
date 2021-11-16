package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            "where pais like %:pais% or cidade like %:cidade%"
            , nativeQuery = true
    )
    List<EnderecoEntity> findByCidadeOuPais(String cidade, String pais);

    @Query(value = "select * " +
            "from ENDERECO_PESSOA e " +
            "where complemento is not null"
            , nativeQuery = true)
    List<EnderecoEntity> findBySemComplemento();


    /////////////////////////////////////////////////////

    @Query("select e " +
            "from ENDERECO_PESSOA e " +
            "where upper(e.pais) like upper(:nome)")
    Page<EnderecoEntity> enderecoPorPais(String nome, Pageable pagina);
}
