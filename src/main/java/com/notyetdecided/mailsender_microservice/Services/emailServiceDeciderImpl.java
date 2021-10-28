package com.notyetdecided.mailsender_microservice.Services;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.DTOs.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class emailServiceDeciderImpl implements emailServiceDecider {

    @Autowired
    private JavaMailSenderImpl usingJavaMailSender;

    @Autowired
    private SendGridServiceImpl sendGridServiceImpl;
    @Override
    public boolean decideEmailService(AccountDTO accountDTO) throws IOException {
        if(usingJavaMailSender.sendMail(accountDTO,getEmailDetails(accountDTO)))
        return true;
        else if(sendGridServiceImpl.sendMail(accountDTO,getEmailDetails(accountDTO))){
            return true;
        }
        return false;
    }
    @Override
    public EmailDetails getEmailDetails(AccountDTO accountDTO) {
         String subject="ICICI Bank Account update on "+java.time.LocalDate.now();
         String body= "Your Account Balance for account ending with xxxx"+accountDTO.getAccountEndingDigits() +" is "+accountDTO.getAccountBalance()
                 +".";
         return new EmailDetails(subject,body);
    }
}
