package com.stories.stack.ContentShuffler.model;
import lombok.Data;

import java.util.Date;

@Data
public class CharacterDTO {
    private String id;
    private String name;
    private String icon;
    private Date creationDate;
    private String description;
    private ArtistDTO artist;
}