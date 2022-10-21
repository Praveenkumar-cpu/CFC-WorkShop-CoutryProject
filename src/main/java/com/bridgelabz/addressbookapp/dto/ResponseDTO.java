package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.naming.ldap.PagedResultsControl;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component

public class ResponseDTO {

    //The responseEntity Ensure that response DTO is Converted to JSON Response on REST CALLS

    private String message;
    private Object data;
}
