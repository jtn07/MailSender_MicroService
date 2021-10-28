package com.notyetdecided.mailsender_microservice.Configurations;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sendgrid.SendGrid;
import org.springframework.stereotype.Component;

@Configuration
public class SendGridConfig {


        @Value("${spring.sendgrid.api-key}")
        public String key;

        @Value("${fromMail}")
        public String fromMail;



        @Bean
        public String getkey(){
                return key;
        }

        @Bean
        public String getMail(){
                return fromMail;
        }

        @Bean
        public SendGrid getSendgrid()
        {
            return new SendGrid(key);
        }






}
