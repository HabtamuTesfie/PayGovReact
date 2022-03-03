package com.mycompany.myapp.activemq;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class BeanConfiguration {
    @Bean
    public MessageStorage customerStorage() {
      return new MessageStorage();
    }
}
