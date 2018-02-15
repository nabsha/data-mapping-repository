package org.nabsha.mapper.service;

import org.nabsha.mapper.model.DomainModel;
import org.nabsha.mapper.model.MappingRule;
import org.nabsha.mapper.model.MappingSet;
import org.nabsha.mapper.model.ModelAttribute;

import java.io.IOException;
import java.util.List;

/**
 * Created by nabsha_monash on 19/11/17.
 */


public interface MappingService {
    MappingSet create(MappingSet mappings) throws IOException;
    MappingSet findMappingSetByName(String name);
    List<MappingSet> findAllMappingSetByName(String name);

    DomainModel create(DomainModel domain) throws IOException;
    DomainModel findDomainByName(String name);

    ModelAttribute create(ModelAttribute attribute) throws IOException;
    ModelAttribute findModelAttributeByName(String name);

    MappingRule create(MappingRule mappingRule) throws IOException;
    MappingRule findMappingRuleByName(String name);

    Iterable<MappingSet> findAll();

    List<MappingSet> findAllMappingSets();
}

