package com.zerot.mongo.form_handler.repository;

import com.mongodb.client.MongoDatabase;
import com.zerot.mongo.form_handler.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
