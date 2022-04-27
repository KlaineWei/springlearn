package com.example.springtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author weizihan
 */
@Component
@Slf4j
public class LogTask {

    @Scheduled(cron = "0/10 * * ? * ?")
    private void sendLog(){
        log.info("发送消息");
    }
}
