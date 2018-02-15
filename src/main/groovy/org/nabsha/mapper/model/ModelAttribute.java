package org.nabsha.mapper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nabsha_monash on 18/11/17.
 */

@NodeEntity
public class ModelAttribute {

    @JsonIgnore
    private Long id;

    private String name;

//    @Relationship(type = "FIELD_OF", direction = Relationship.OUTGOING)
    private DomainModel domain;

    private ModelAttribute() {}

    public ModelAttribute(String name, DomainModel domain) {
        this.name = name;
        this.domain = domain;
    }

    public DomainModel getDomain() {
        return domain;
    }

    public void setDomain(DomainModel domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
