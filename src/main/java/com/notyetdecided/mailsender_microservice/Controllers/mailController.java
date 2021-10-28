package com.notyetdecided.mailsender_microservice.Controllers;

import com.notyetdecided.mailsender_microservice.DTOs.AccountDTO;
import com.notyetdecided.mailsender_microservice.Services.emailServiceDecider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/mail")
public class mailController {

    @Autowired
    private emailServiceDecider emailServiceDecider;

    @GetMapping("/account/{AccountDTO}")
    public String sendMail(@ModelAttribute("AccountDTO") AccountDTO accountDTO) throws IOException {
       boolean decider= emailServiceDecider.decideEmailService(accountDTO);
       if(decider) {
           return "Mail sent Successfully";
       }
        return "Mail service failed";
    }
}
