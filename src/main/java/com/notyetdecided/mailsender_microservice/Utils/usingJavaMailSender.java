package com.notyetdecided.mailsender_microservice.Utils;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.DTOs.EmailDetails;


public interface usingJavaMailSender {
    boolean sendMail(AccountDTO accountDTO, EmailDetails emailDetails);

}
