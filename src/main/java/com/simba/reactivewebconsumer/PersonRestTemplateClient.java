package com.simba.reactivewebconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;
import java.time.Instant;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-06-08
 */
@Component
@Slf4j
public class PersonRestTemplateClient {
    private final RestTemplate restTemplate;

    public PersonRestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getPerson() {
        log.trace("--- get person with id --- ");
        Instant start = Instant.now();
        String url = "http://localhost:8095";
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(url));
        for (int i = 1; i <= 5; i++) {
            restTemplate.getForObject("/persons/{id}", Person.class, i);
        }
        logTime(start);
    }

    private void logTime(Instant start) {
        log.trace("--- elapsed time: {} in ms ", Duration.between(start, Instant.now()).toMillis());
    }
}
