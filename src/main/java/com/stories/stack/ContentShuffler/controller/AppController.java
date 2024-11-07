package com.stories.stack.ContentShuffler.controller;

import com.stories.stack.ContentShuffler.model.StoryDTO;
import com.stories.stack.ContentShuffler.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.stories.stack.ContentShuffler.util.AppConstant.HOME_MSG;

@RestController
public class AppController {

    @Autowired
    AppService appService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(HOME_MSG);
    }

    @GetMapping("/getShuffledStories")
    public ResponseEntity<List<StoryDTO>> getShuffledStories() {
        List<StoryDTO> shuffledStories = appService.getShuffledStories();
        return ResponseEntity.ok(shuffledStories);
    }
}

