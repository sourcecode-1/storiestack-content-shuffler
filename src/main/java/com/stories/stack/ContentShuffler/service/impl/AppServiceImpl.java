package com.stories.stack.ContentShuffler.service.impl;

import com.stories.stack.ContentShuffler.entity.Story;
import com.stories.stack.ContentShuffler.model.StoryDTO;
import com.stories.stack.ContentShuffler.repository.StoryRepository;
import com.stories.stack.ContentShuffler.service.AppService;
import com.stories.stack.ContentShuffler.util.AppUtil;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static com.stories.stack.ContentShuffler.util.AppConstant.DATA_CONNECT_EXP_MSG;

@Service
@Slf4j
public class AppServiceImpl implements AppService {

    @Autowired
    private StoryRepository storyRepository;

    @Value("$content.retriever.limit}")
    private Integer contentRetrieverLimit;

    private final AtomicReference<List<Story>> stories = new AtomicReference<>(Collections.emptyList());
    private final AtomicReference<List<StoryDTO>> storyDTOs = new AtomicReference<>(Collections.emptyList());

    @PostConstruct
    public void loadStories() {
        fetchStories();
        log.info("Stories loaded successfully at {}", LocalDateTime.now());
    }

    @Scheduled(fixedRateString = "${content.refresh.rate}")
    public void refreshStories() {
        fetchStories();
        log.info("Stories refreshed successfully at {}", LocalDateTime.now());
    }

    private void fetchStories() {
        try {
            List<Story> fetchedStories = storyRepository.findAll();
            stories.set(fetchedStories);
            storyDTOs.set(fetchedStories.stream().map(AppUtil::mapToStoryDTO).collect(Collectors.toList()));
        } catch (Exception e) {
            log.error(DATA_CONNECT_EXP_MSG, e);
            stories.set(Collections.emptyList());
            storyDTOs.set(Collections.emptyList());
        }
    }

    @Override
    public List<StoryDTO> getShuffledStories() {
        List<StoryDTO> currentStoryDTOs = new ArrayList<>(storyDTOs.get());
        Collections.shuffle(currentStoryDTOs);
        return currentStoryDTOs.stream().limit(contentRetrieverLimit).toList();
    }
}
