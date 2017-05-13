package com.thesis.repository;

import com.thesis.entity.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by lap08 on 5/13/2017.
 */

public interface LocationRepository extends MongoRepository<Location, String> {
    void delete(Location deleted);

    List<Location> findAll();

}