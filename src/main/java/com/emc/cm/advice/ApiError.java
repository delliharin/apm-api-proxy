package com.emc.cm.advice;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ApiError {
    private Integer errorCode;
    private String details;
    private Date date;
}

