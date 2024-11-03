package com.stories.stack.ContentShuffler.util;

import com.stories.stack.ContentShuffler.entity.Story;
import com.stories.stack.ContentShuffler.model.ArtistDTO;
import com.stories.stack.ContentShuffler.model.CharacterDTO;
import com.stories.stack.ContentShuffler.model.StoryDTO;

public class AppUtil {

    public static StoryDTO mapToStoryDTO(Story story) {
        StoryDTO dto = new StoryDTO();
        dto.setId(story.getId());
        dto.setTitle(story.getTitle());
        dto.setImages(story.getImages());
        dto.setLikeCount(story.getLikeCount());
        dto.setDescription(story.getDescription());
        dto.setCreationDate(story.getCreationDate());

        if (story.getCharacter() != null) {
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.setId(story.getCharacter().getId());
            characterDTO.setName(story.getCharacter().getName());
            characterDTO.setIcon(story.getCharacter().getIcon());
            characterDTO.setCreationDate(story.getCharacter().getCreationDate());
            characterDTO.setDescription(story.getCharacter().getDescription());

            if (story.getCharacter().getArtist() != null) {
                ArtistDTO artistDTO = new ArtistDTO();
                artistDTO.setId(story.getCharacter().getArtist().getId());
                artistDTO.setName(story.getCharacter().getArtist().getName());
                artistDTO.setEmail(story.getCharacter().getArtist().getEmail());
                artistDTO.setDescription(story.getCharacter().getArtist().getDescription());

                characterDTO.setArtist(artistDTO);
            }
            dto.setCharacter(characterDTO);
        }
        return dto;
    }


}
