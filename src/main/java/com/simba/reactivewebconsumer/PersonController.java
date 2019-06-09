package com.simba.reactivewebconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-06-08
 */
@RestController
@RequestMapping(value = "/persons")
@Slf4j
public class PersonController {
    private final PersonWebClient personClient;

    public PersonController(PersonWebClient personClient) {
        this.personClient = personClient;
    }


    @GetMapping(value = "/hello")
    public ResponseEntity<String> sayHello() {
        log.trace("--- sayHello ---");
        personClient.getPerson();
        return ResponseEntity.ok("hello");
    }
}
