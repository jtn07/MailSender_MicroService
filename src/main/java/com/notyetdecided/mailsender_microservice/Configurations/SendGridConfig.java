package com.notyetdecided.mailsender_microservice.Configurations;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;

@Configuration


public class SendGridConfig {


        @Value("${spring.sendgrid.api-key}")
        private String key;


        @Bean
        public SendGrid getSendgrid()
        {
            return new SendGrid(key);
        }

}
