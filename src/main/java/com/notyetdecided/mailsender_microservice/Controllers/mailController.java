package com.notyetdecided.mailsender_microservice.Controllers;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.Services.emailServiceDecider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class mailController {

    @Autowired
    private emailServiceDecider emailServiceDecider;
    @RequestMapping("/account")
    public boolean sendMail(@ModelAttribute("AccountDTO") AccountDTO accountDTO, Model model){
        System.out.println(accountDTO.getEmailAddress());
       return emailServiceDecider.decideEmailService(accountDTO);
    }
    @GetMapping("/sample")
    public AccountDTO getAccountDto(){
        return new AccountDTO(1234,"Jatin","Dhone","jatinsai.js@gmail.com",999999);
    }


}
