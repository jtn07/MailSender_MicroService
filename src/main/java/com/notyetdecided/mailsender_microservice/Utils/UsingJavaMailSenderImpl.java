package com.notyetdecided.mailsender_microservice.Utils;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;

import com.notyetdecided.mailsender_microservice.DTOs.EmailDetails;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class UsingJavaMailSenderImpl implements usingJavaMailSender {


    @Autowired
    private JavaMailSender javaMailSender;

    private AccountDTO accountDTO;

    @Override
    public boolean sendMail(AccountDTO accountDTO, EmailDetails emailDetails) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message);

        try {
            mimeMessageHelper.setTo(accountDTO.getEmailAddress());
            mimeMessageHelper.setText(emailDetails.getBody()+"\n sent from Java Mail Sender");
            mimeMessageHelper.setSubject(emailDetails.getSubject());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        try {
           javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
            return false;
        }

       return true;
    }
}
