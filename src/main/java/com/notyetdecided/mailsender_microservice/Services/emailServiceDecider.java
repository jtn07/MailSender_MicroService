package com.notyetdecided.mailsender_microservice.Services;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import org.springframework.stereotype.Service;

@Service
public interface emailServiceDecider {
    public boolean decideEmailService(AccountDTO accountDTO);
    public String [] getEmailDetails(AccountDTO accountDTO);
}
