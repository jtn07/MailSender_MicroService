package com.notyetdecided.mailsender_microservice.Services;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.DTOs.EmailDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface emailServiceDecider {
    public boolean decideEmailService(AccountDTO accountDTO) throws IOException;
    public EmailDetails getEmailDetails(AccountDTO accountDTO);
}
