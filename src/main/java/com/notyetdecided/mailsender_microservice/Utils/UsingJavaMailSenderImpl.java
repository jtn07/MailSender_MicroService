package com.notyetdecided.mailsender_microservice.Utils;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;

import com.notyetdecided.mailsender_microservice.Exceptions.EmailAddressNotFoundException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class UsingJavaMailSenderImpl implements usingJavaMailSender {


    @Autowired
    private JavaMailSender javaMailSender;

    private AccountDTO accountDTO;

    @Override
    public boolean sendMail(AccountDTO accountDTO,String [] strings) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message);
        try {
         //  mimeMessageHelper.setBcc("jatinsai.js@gmail.com");
            mimeMessageHelper.setTo(accountDTO.getEmailAddress());
            mimeMessageHelper.setText(strings[1]);
            mimeMessageHelper.setSubject(strings[0]);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
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
