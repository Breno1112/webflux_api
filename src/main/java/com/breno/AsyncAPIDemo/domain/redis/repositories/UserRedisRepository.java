package com.breno.AsyncAPIDemo.domain.redis.repositories;

import com.breno.AsyncAPIDemo.domain.redis.entities.UserRedisEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedisRepository extends CrudRepository<UserRedisEntity, String> {
}
