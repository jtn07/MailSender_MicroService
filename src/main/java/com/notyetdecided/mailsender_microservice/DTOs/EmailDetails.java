package com.notyetdecided.mailsender_microservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailDetails {

    private String Subject;
    private String Body;



}
