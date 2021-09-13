package com.example.multipledatabasestest.repositories.redis;

import com.example.multipledatabasestest.entities.redis.UserCached;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCachedRepository extends CrudRepository<UserCached, String> {
}
