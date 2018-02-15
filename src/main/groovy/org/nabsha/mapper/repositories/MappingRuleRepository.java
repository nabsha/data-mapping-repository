package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.MappingRule;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.RepositoryDefinition;

public interface MappingRuleRepository extends GraphRepository<MappingRule>, MappingRuleCustomRepository {
    MappingRule findByName(String name);

}