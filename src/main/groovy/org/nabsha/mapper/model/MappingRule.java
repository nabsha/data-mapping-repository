package org.nabsha.mapper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

/**
 * Created by nabsha_monash on 18/11/17.
 */
@NodeEntity
public class MappingRule {
    @JsonIgnore
    private Long id;

    private String name;

    private String rule;

    private List<ModelAttribute> srcAttributes;

    private ModelAttribute targetAttribute;

    private MappingRule() {}

    public MappingRule(String name, List<ModelAttribute> srcAttributes, ModelAttribute targetAttribute, String rule) {
        if (srcAttributes == null || srcAttributes.isEmpty())
            throw new IllegalArgumentException("no src specified");

        if (targetAttribute == null)
            throw new IllegalArgumentException("no target specified");

        this.srcAttributes = srcAttributes;
        this.targetAttribute  = targetAttribute;
        this.rule = rule;
        this.name = name;
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

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public List<ModelAttribute> getSrcAttributes() {
        return srcAttributes;
    }

    public void setSrcAttributes(List<ModelAttribute> srcAttributes) {
        this.srcAttributes = srcAttributes;
    }

    public ModelAttribute getTargetAttribute() {
        return targetAttribute;
    }

    public void setTargetAttribute(ModelAttribute targetAttribute) {
        this.targetAttribute = targetAttribute;
    }

}
