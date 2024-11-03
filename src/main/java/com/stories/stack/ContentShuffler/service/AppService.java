package com.stories.stack.ContentShuffler.service;

import com.stories.stack.ContentShuffler.entity.Story;
import com.stories.stack.ContentShuffler.model.StoryDTO;

import java.util.List;

public interface AppService {
    List<StoryDTO> getShuffledStories();
}
