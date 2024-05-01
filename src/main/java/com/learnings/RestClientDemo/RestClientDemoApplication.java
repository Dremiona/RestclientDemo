package com.learnings.RestClientDemo;

import com.learnings.RestClientDemo.clients.JsonPlaceholderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RestClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestClientDemoApplication.class, args);
    }

    @Bean
    JsonPlaceholderService jsonPlaceholderService() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();
        return factory.createClient(JsonPlaceholderService.class);
    }

}
