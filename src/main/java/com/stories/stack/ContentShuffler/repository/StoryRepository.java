package com.stories.stack.ContentShuffler.repository;

import com.stories.stack.ContentShuffler.entity.Story;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends MongoRepository<Story, ObjectId> {}