package com.xiaoming.springbootlearning.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Xiaoming.
 * Created on 2019/02/03 15:13.
 * Description :
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String type;
    private Value value;

    public Quote(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}

/*
 * Test:
 *     public static void main(String args[]) {
 *         RestTemplate restTemplate = new RestTemplate();
 *         Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
 *         log.info(quote.toString());
 *     }
 */
