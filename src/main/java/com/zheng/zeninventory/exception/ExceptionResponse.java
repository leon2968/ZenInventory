package com.zheng.zeninventory.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/*
 * Custome exception reponse used in GlobalExceotionHandler class
 */
public class ExceptionResponse {
   
    private int statusCode;
    private String message;
    //private long timestamp;

}