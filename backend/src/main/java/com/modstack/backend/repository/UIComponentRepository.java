package com.modstack.backend.repository;

import com.modstack.backend.model.UIComponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UIComponentRepository extends MongoRepository<UIComponent, String> {

}
