package com.stories.stack.ContentShuffler.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StoryDTO {
    private String id;
    private String title;
    private List<String> images;
    private Integer likeCount;
    private String description;
    private Date creationDate;
    private CharacterDTO character;
}