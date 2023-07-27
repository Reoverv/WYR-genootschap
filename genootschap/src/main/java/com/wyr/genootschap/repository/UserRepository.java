package com.wyr.genootschap.repository;

import com.wyr.genootschap.models.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<user, String> {


    public user getUserByDiscordId(String id);








}
