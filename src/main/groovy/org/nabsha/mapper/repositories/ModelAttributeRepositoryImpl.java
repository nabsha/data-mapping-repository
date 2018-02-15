package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.DomainModel;
import org.nabsha.mapper.model.MappingRule;
import org.nabsha.mapper.model.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nabsha_monash on 20/11/17.
 */
public class ModelAttributeRepositoryImpl implements ModelAttributeCustomRepository {

    @Autowired
    ModelAttributeRepository modelAttributeRepository;

    @Autowired
    DomainModelRepository domainModelRepository;

    @Override
    public ModelAttribute merge(ModelAttribute attribute) {
        return modelAttributeRepository.save(findOrDefault(attribute));
    }

    public ModelAttribute findOrDefault(ModelAttribute attribute) {
        ModelAttribute byName = modelAttributeRepository.findByName(attribute.getName());
        if (byName != null) {
            attribute.setId(byName.getId());
        }
        DomainModel domain = domainModelRepository.findOrDefault(attribute.getDomain());

        attribute.setDomain(domain);
        return attribute;
    }
}
