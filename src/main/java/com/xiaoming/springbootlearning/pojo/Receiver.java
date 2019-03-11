package com.xiaoming.springbootlearning.pojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @author Xiaoming.
 * Created on 2019/02/09 21:56.
 * Description :
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void reveiveMessage(String message) {
        LOGGER.info("Receive <" + message + ">");
        latch.countDown();
    }
}
