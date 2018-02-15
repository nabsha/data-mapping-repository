package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.MappingRule;

/**
 * Created by nabsha_monash on 18/11/17.
 */
public interface MappingRuleCustomRepository {
    MappingRule merge(MappingRule mappingRule);
    MappingRule findOrDefault(MappingRule mappingRule);

}
