package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.DomainModel;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by nabsha_monash on 18/11/17.
 */
public interface DomainModelRepository extends GraphRepository<DomainModel>, DomainCustomRepository {
    DomainModel findByName(String name);

}

