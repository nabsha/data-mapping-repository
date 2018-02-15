package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.MappingRule;
import org.nabsha.mapper.model.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nabsha_monash on 18/11/17.
 */
public class MappingRuleRepositoryImpl implements MappingRuleCustomRepository {

    @Autowired
    MappingRuleRepository mappingRuleRepository;

    @Autowired
    ModelAttributeRepository modelAttributeRepository;

    @Override
    public MappingRule merge(MappingRule mappingRule) {
        return mappingRuleRepository.save(findOrDefault(mappingRule));
    }

    public MappingRule findOrDefault(MappingRule mappingRule) {
        MappingRule found = mappingRuleRepository.findByName(mappingRule.getName());
        if (found != null) {
            mappingRule.setId(found.getId());
        }

        mappingRule.setTargetAttribute(modelAttributeRepository.findOrDefault(mappingRule.getTargetAttribute()));
        modelAttributeRepository.merge(mappingRule.getTargetAttribute());

        List<ModelAttribute> srcAttributes = mappingRule.getSrcAttributes();
        for(int i = 0; i < srcAttributes.size(); i++) {
            ModelAttribute srcAttr = modelAttributeRepository.findOrDefault(srcAttributes.get(i));
            modelAttributeRepository.merge(srcAttr);
            srcAttributes.set(i, srcAttr);

        }
        return mappingRule;
    }
}
