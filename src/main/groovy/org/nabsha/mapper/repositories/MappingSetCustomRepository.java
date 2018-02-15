package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.MappingSet;

/**
 * Created by nabsha_monash on 26/11/17.
 */
public interface MappingSetCustomRepository {
    MappingSet merge(MappingSet mappingSet);
}
