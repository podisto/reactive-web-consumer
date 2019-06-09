package com.simba.reactivewebconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="mailto:ElHadjiOmar.DIONE@orange-sonatel.com">podisto</a>
 * @since 2019-06-08
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
