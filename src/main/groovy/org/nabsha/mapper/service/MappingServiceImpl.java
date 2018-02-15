package org.nabsha.mapper.service;

import org.nabsha.mapper.model.DomainModel;
import org.nabsha.mapper.model.MappingRule;
import org.nabsha.mapper.model.MappingSet;
import org.nabsha.mapper.model.ModelAttribute;
import org.nabsha.mapper.repositories.DomainModelRepository;
import org.nabsha.mapper.repositories.MappingRuleRepository;
import org.nabsha.mapper.repositories.MappingSetRepository;
import org.nabsha.mapper.repositories.ModelAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("mappingService")
public class MappingServiceImpl implements MappingService {

    @Autowired
    MappingSetRepository mappingSetRepository;

    @Autowired
    MappingRuleRepository mappingRuleRepository;

    @Autowired
    DomainModelRepository domainModelRepository;

    @Autowired
    ModelAttributeRepository modelAttributeRepository;

    @Override
    public MappingSet create(MappingSet mappingSet) throws IOException {
        return mappingSetRepository.merge(mappingSet);
    }

    public DomainModel create(DomainModel domain) {
        return domainModelRepository.merge(domain);
    }

    @Override
    public DomainModel findDomainByName(String name) {
        return domainModelRepository.findByName(name);
    }

    @Override
    public ModelAttribute create(ModelAttribute attribute) throws IOException {
        return modelAttributeRepository.merge(attribute);
    }

    @Override
    public ModelAttribute findModelAttributeByName(String name) {
        return modelAttributeRepository.findByName(name);
    }

    @Override
    public MappingRule create(MappingRule mappingRule) throws IOException {
        return mappingRuleRepository.merge(mappingRule);
    }

    @Override
    public MappingRule findMappingRuleByName(String name) {
        return mappingRuleRepository.findByName(name);
    }

    @Override
    public Iterable<MappingSet> findAll() {
        return mappingSetRepository.findAll();
    }

    @Override
    public MappingSet findMappingSetByName(String name) {
        return mappingSetRepository.findByName(name);
    }

    @Override
    public List<MappingSet> findAllMappingSets() {
        List<MappingSet> mappingSets = new ArrayList<>();
        Iterable<MappingSet> all = mappingSetRepository.findAll();
        all.forEach(mappingSets::add);
        return mappingSets;
    }

    @Override
    public List<MappingSet> findAllMappingSetByName(String name) {
        return mappingSetRepository.findAllByName(name);
    }


}