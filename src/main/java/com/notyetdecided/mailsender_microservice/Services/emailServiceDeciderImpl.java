package com.notyetdecided.mailsender_microservice.Services;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.Utils.usingJavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
@Service
public class emailServiceDeciderImpl implements emailServiceDecider {
    @Autowired
    private usingJavaMailSender sender;
    @Override
    public boolean decideEmailService(AccountDTO accountDTO) {
        if(sender.sendMail(accountDTO,getEmailDetails(accountDTO))){
            return true;
        }
        return false;
    }
    @Override
    public String[] getEmailDetails(AccountDTO accountDTO) {
         String subject="ICICI Bank Account update on "+java.time.LocalDate.now();
         String body= "Your Account xxxx"+accountDTO.getAccountEndingDigits() +" is "+accountDTO.getAccountBalance()
                 +" at "+ LocalTime.now()+".";
         String [] messgeDetails=new String[2];
         messgeDetails[0]=subject;
         messgeDetails[1]=body;
         return messgeDetails;
    }
}
