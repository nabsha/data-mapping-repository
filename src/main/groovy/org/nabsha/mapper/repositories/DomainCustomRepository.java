package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.DomainModel;

/**
 * Created by nabsha_monash on 18/11/17.
 */

public interface DomainCustomRepository {
    DomainModel merge(DomainModel domain);
    DomainModel findOrDefault(DomainModel domain);
}
