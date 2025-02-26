package com.atl23.orderapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionMessage {

    private int status;
    private String message;
    private LocalDateTime localDateTime;
}
