package com.notyetdecided.mailsender_microservice.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private  int accountEndingDigits;
    private String accountHolderName;
    private String accountBranch;
    private String emailAddress;
    private long accountBalance;
}
/*
{
    "accountEndingDigits": 1234,
    "accountHolderName": "Jatin",
    "accountBranch": "Dhone",
    "emailAddress": "jatinsai.js@gmail.com",
    "accountBalance": 999999
}
 */