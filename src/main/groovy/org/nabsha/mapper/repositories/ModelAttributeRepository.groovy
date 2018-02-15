package org.nabsha.mapper.repositories

import org.nabsha.mapper.model.ModelAttribute
import org.springframework.data.neo4j.repository.GraphRepository

/**
 * Created by nabsha_monash on 18/11/17.
 */
interface ModelAttributeRepository extends GraphRepository<ModelAttribute>, ModelAttributeCustomRepository {
    ModelAttribute findByName(String name);
}