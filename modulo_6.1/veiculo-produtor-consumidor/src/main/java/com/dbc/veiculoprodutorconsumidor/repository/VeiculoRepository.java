package com.dbc.veiculoprodutorconsumidor.repository;

import com.dbc.veiculoprodutorconsumidor.entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends MongoRepository<VeiculoEntity, String> {

    @Aggregation(pipeline = {"{$group: { _id: '', mediaVelocidade: {$avg: $velocidade }}}"})
    Double mediaVelocidadeTodos();

    @Aggregation(pipeline = {"{$group: { _id: '', mediaRotacao: {$avg: $rotacao }}}"})
    Double mediaRotacaoTodos();

    @Query(value = "{status: ?0}", count = true)
    long count(boolean status);
}
