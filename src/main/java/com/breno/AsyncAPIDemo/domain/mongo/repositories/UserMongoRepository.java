package com.breno.AsyncAPIDemo.domain.mongo.repositories;

import com.breno.AsyncAPIDemo.domain.mongo.entities.UserMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongoEntity, String> {
}
