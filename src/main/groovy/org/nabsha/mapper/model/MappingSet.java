package org.nabsha.mapper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@NodeEntity
public class MappingSet {
    @JsonIgnore
    private Long id;

    private String name;

    private List<MappingRule> mappingRules;

    private MappingSet() {

    }

    public MappingSet(String name, List<MappingRule> mappingRules) {
        this.name = name;
        this.mappingRules = mappingRules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MappingRule> getMappingRules() {
        return mappingRules;
    }

    public void setMappingRules(List<MappingRule> mappingRules) {
        this.mappingRules = mappingRules;
    }

    @Override
    public String toString() {
        return "MappingSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mappingRules=" + mappingRules +
                '}';
    }
}