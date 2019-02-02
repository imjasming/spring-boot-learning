package com.xiaoming.springbootlearning.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Xiaoming.
 * Created on 2019/02/02 22:28.
 * Description :
 */
@Component
public class ScheduledTasks {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    /**
     * <p>需在Application添加@EnableScheduling（ensures that a background task executor is created.）</p>
     * <p>fixedRate, which specifies the interval between method invocations measured from the start
     * time of each invocation. There are other options, like fixedDelay, which specifies the interval
     * between invocations measured from the completion of the task.</p>
     */
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime(){
        LOGGER.info("The time is now {}", DATE_FORMAT.format(new Date()));
    }
}
