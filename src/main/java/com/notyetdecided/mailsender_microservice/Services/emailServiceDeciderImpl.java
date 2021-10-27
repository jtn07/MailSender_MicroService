package com.notyetdecided.mailsender_microservice.Services;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.DTOs.EmailDetails;
import com.notyetdecided.mailsender_microservice.Utils.SendGridService;
import com.notyetdecided.mailsender_microservice.Utils.SendGridServiceImpl;
import com.notyetdecided.mailsender_microservice.Utils.usingJavaMailSender;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalTime;
@Service
public class emailServiceDeciderImpl implements emailServiceDecider {


    @Autowired
    private SendGridServiceImpl sendGridService;

    @Autowired
   private usingJavaMailSender usingJavaSender;

    @Override
    public boolean decideEmailService(AccountDTO accountDTO) throws IOException {
        if(usingJavaSender.sendMail(accountDTO,getEmailDetails(accountDTO)))
        return true;
        else if(sendGridService.sendMail(accountDTO,getEmailDetails(accountDTO))){
            return true;
        }
        return false;
    }
    @Override
    public EmailDetails getEmailDetails(AccountDTO accountDTO) {
         String subject="ICICI Bank Account update on "+java.time.LocalDate.now();
         String body= "Your Account xxxx"+accountDTO.getAccountEndingDigits() +" is "+accountDTO.getAccountBalance()
                 +" at "+ LocalTime.now()+".";
         return new EmailDetails(subject,body);
    }
}
