package org.nabsha.mapper.controller;

import org.nabsha.mapper.model.DomainModel;
import org.nabsha.mapper.model.MappingRule;
import org.nabsha.mapper.model.MappingSet;
import org.nabsha.mapper.model.ModelAttribute;
import org.nabsha.mapper.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;

/**
 * Created by nabsha_monash on 19/11/17.
 */

@Controller
@RequestMapping("/api/")
public class RestAPIController {

    @Autowired
    MappingService mappingService;

    @RequestMapping(value = "/mappings", method = RequestMethod.GET)
    public ResponseEntity<?> findAllMappingSets() {
        List<MappingSet> mappingSets = mappingService.findAllMappingSets();
        HttpStatus httpStatus = HttpStatus.OK;
        if (mappingSets == null)
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<List<MappingSet>>(mappingSets, httpStatus);
    }

    @RequestMapping(value = "/mappings/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody MappingSet mappingSet) throws IOException {

        MappingSet mappingSet1 = mappingService.findMappingSetByName(mappingSet.getName());
        HttpStatus httpStatus = HttpStatus.OK;
        if (mappingSet1 == null) {
            mappingSet1 = mappingService.create(mappingSet);
            httpStatus = HttpStatus.CREATED;
        }

        return new ResponseEntity<MappingSet>(mappingSet1, httpStatus);
    }

    @RequestMapping(value = "/mappings/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findByName(@PathVariable("id") String id) {
        MappingSet byName = mappingService.findMappingSetByName(id);
        HttpStatus httpStatus = HttpStatus.OK;
        if (byName == null)
            httpStatus = HttpStatus.NOT_FOUND;

        return new ResponseEntity<MappingSet>(byName, httpStatus);
    }



    // Domain
    @RequestMapping(value = "/mappings/domains/", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody DomainModel domain) throws IOException {

        DomainModel domainModel = mappingService.findDomainByName(domain.getName());
        HttpStatus httpStatus = HttpStatus.OK;
        if (domainModel == null) {
            domainModel = mappingService.create(domain);
            httpStatus = HttpStatus.CREATED;
        }

        return new ResponseEntity<DomainModel>(domainModel, httpStatus);
    }

    // ModelAttribute
    @RequestMapping(value = "/mappings/domains/{id}/attributes", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody ModelAttribute modelAttribute) throws IOException {

        ModelAttribute attribute = mappingService.findModelAttributeByName(modelAttribute.getName());
        HttpStatus httpStatus = HttpStatus.OK;
        if (attribute == null) {
            attribute = mappingService.create(modelAttribute);
            httpStatus = HttpStatus.CREATED;
        }

        return new ResponseEntity<ModelAttribute>(attribute, httpStatus);
    }

    // Mapping Rule
    @RequestMapping(value = "/mappings/{id}/rules", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody MappingRule mappingRule) throws IOException {

        MappingRule found = mappingService.findMappingRuleByName(mappingRule.getName());
        HttpStatus httpStatus = HttpStatus.OK;
        if (found == null) {
            found = mappingService.create(mappingRule);
            httpStatus = HttpStatus.CREATED;
        }

        return new ResponseEntity<MappingRule>(found, httpStatus);
    }

}
