package com.stories.stack.ContentShuffler.controller;

import com.stories.stack.ContentShuffler.entity.Story;
import com.stories.stack.ContentShuffler.model.StoryDTO;
import com.stories.stack.ContentShuffler.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("/getShuffledStories")
    public List<StoryDTO> getShuffledStories() {
        return appService.getShuffledStories();
    }

}

