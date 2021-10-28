package com.notyetdecided.mailsender_microservice.Services;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.DTOs.EmailDetails;


public interface MailSenderService {
    boolean sendMail(AccountDTO accountDTO, EmailDetails emailDetails);

}
