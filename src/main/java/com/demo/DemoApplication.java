
package com.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.repository.init.AbstractRepositoryPopulatorFactoryBean;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public AbstractRepositoryPopulatorFactoryBean repositoryPopulator(ObjectMapper objectMapper, KeyValueRepository keyValueRepository) {
        Jackson2RepositoryPopulatorFactoryBean factory = new CustomJackson2RepositoryPopulatorFactoryBean();
        keyValueRepository.deleteAll();
        factory.setMapper(objectMapper);
        factory.setResources(new Resource[]{new ClassPathResource("badclassname.json"), new ClassPathResource("good.json"), new ClassPathResource("malformatted.json")});
        return factory;
    }

}