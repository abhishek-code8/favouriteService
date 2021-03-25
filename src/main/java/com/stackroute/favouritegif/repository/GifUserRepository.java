package com.stackroute.favouritegif.repository;


import com.stackroute.favouritegif.model.GifUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GifUserRepository extends MongoRepository<GifUser, String> {

}
