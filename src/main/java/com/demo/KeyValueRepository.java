package com.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface KeyValueRepository extends MongoRepository<KeyValue, String> {
}
