package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    //Com Query JPQL
    @Query("select c " +
            "from CONTATO c " +
            "where c.tipoContato = :tipo"
    )
    List<ContatoEntity> findByContatoComTipoDeContatoComQueryJPQL(TipoContato tipo);

    //Com Query Nativa
    @Query(value = "select * " +
            "from CONTATO c " +
            "join PESSOA p on (c.id_pessoa = p.id_pessoa)" +
            "where c.id_pessoa = :id"
            , nativeQuery = true
    )
    List<ContatoEntity> findByContatoComIdPessoaComQueryNativa(@Param("id") Integer id);


}
