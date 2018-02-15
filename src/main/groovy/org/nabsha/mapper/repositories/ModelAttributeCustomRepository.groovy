package org.nabsha.mapper.repositories

import org.nabsha.mapper.model.ModelAttribute

/**
 * Created by nabsha_monash on 20/11/17.
 */
interface ModelAttributeCustomRepository {
    ModelAttribute merge(ModelAttribute attribute);
    ModelAttribute findOrDefault(ModelAttribute attribute);
}