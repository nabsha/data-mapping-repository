package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.MappingRule;
import org.nabsha.mapper.model.MappingSet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by nabsha_monash on 26/11/17.
 */
public class MappingSetRepositoryImpl implements MappingSetCustomRepository {

    @Autowired
    MappingSetRepository mappingSetRepository;

    @Autowired
    MappingRuleRepository mappingRuleRepository;
    @Override
    public MappingSet merge(MappingSet mappingSet) {
        MappingSet byName = mappingSetRepository.findByName(mappingSet.getName());
        if (byName != null) {
            return byName;
        }

        for (MappingRule mappingRule: mappingSet.getMappingRules()) {
            mappingRuleRepository.merge(mappingRule);
        }
        return mappingSetRepository.save(mappingSet);
    }
}
