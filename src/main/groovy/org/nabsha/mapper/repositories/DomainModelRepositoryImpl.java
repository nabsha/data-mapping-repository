package org.nabsha.mapper.repositories;

import org.nabsha.mapper.model.DomainModel;
import org.springframework.beans.factory.annotation.Autowired;

class DomainModelRepositoryImpl implements DomainCustomRepository {

    @Autowired
    DomainModelRepository domainModelRepository;

    @Override
    public DomainModel merge(DomainModel domain) {
        DomainModel person1 = domainModelRepository.findByName(domain.getName());
        if (person1 == null) {
            person1 = domain;
        }
        return domainModelRepository.save(person1);
    }

    public DomainModel findOrDefault(DomainModel domain) {
        DomainModel domainName = domainModelRepository.findByName(domain.getName());
        if (domainName != null) {
            domain.setId(domainName.getId());
        }
        return domain;
    }

}