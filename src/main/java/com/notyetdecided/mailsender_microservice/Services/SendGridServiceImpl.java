package com.notyetdecided.mailsender_microservice.Services;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.DTOs.EmailDetails;
import com.notyetdecided.mailsender_microservice.Services.SendGridService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendGridServiceImpl implements SendGridService {


    @Autowired
    private SendGrid sendGrid;

    @Value("${mail.key}")
    private String key;
    @Value("${app.fromMail}")
    private String fromMail ;
    @Override
    public boolean sendMail(AccountDTO accountDTO, EmailDetails emailDetails) throws IOException {

        Email from =new Email(fromMail);
        String subject = emailDetails.getSubject();
        Email to = new Email(accountDTO.getEmailAddress());
        String con= emailDetails.getBody();
        Content content = new Content("text/plain", con+"\n sent from SendGrid");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sendGrid = new SendGrid(key);
        Request request = new Request();
        Response response= null;
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
             response = sendGrid.api(request);

        } catch (IOException ex) {
            throw ex;
        }
        if(response.getStatusCode() != 200)
            return false;
        return true;
    }


}
