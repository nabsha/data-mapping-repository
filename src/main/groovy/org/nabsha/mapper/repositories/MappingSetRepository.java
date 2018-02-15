package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.MappingSet;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

/**
 * Created by nabsha_monash on 19/11/17.
 */
public interface MappingSetRepository extends GraphRepository<MappingSet>, MappingSetCustomRepository {
    MappingSet findByName(String name);
    List<MappingSet> findAllByName(String name);
}

