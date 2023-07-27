package com.wyr.genootschap.repository;

import com.wyr.genootschap.models.user;
import com.wyr.genootschap.models.Wyr;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface WyrRepository extends MongoRepository<Wyr, String> {


    public List<Wyr> findAllByTimeCreatedAfter(Date timeCreated);
    public List<Wyr> findAllByUser(user user);
    public Wyr findByTitle(String title);



}
