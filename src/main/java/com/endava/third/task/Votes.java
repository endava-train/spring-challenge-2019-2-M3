package com.endava.third.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Votes {
    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        log.info("The time is now {}");
    }
}