package com.thesis.repository;

import com.thesis.entity.Location;
import com.thesis.entity.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by lap08 on 8/11/2017.
 */
public interface NewsRepository extends MongoRepository<News, String> {
    void delete(News deleted);
    List<News> findAll();
    @Query(value = "{'created_at': {$gt: ?0}}")
    List<News> findCurrentNewsInTime(long time);
}