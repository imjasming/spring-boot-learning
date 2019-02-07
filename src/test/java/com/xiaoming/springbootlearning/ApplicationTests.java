package com.xiaoming.springbootlearning;

import com.xiaoming.springbootlearning.domain.Quote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {


    @Test
    public void contextLoads() {
    }

    @Test
    public void consumingRestfulWebService(){
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        Logger log = LoggerFactory.getLogger(ApplicationTests.class);
        log.info(quote.toString());
    }

}

