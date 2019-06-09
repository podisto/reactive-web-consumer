package com.simba.reactivewebconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-06-08
 */
@Component
@Slf4j
public class PersonWebClient {
    private static final String URL = "http://localhost:8095";
    private static WebClient webClient = WebClient.create(URL);

    public void getPerson() {
        log.trace("--- get person with id --- ");
        Instant start = Instant.now();

        Stream.of(1, 2, 3, 4, 5).map(i -> webClient.get().uri("/persons/{id}", i).retrieve().bodyToMono(Person.class).subscribe(person -> {
            log.trace("Person id: {} - name: {} ", person.getId(), person.getName());
        }));
        logTime(start);
    }

    private void logTime(Instant start) {
        log.trace("--- elapsed time: {} in ms ", Duration.between(start, Instant.now()).toMillis());
    }
}
