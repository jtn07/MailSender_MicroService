package com.notyetdecided.mailsender_microservice.Utils;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import org.springframework.stereotype.Component;

@Component
public interface usingJavaMailSender {
    boolean sendMail(AccountDTO accountDTO,String [] strings);

}
