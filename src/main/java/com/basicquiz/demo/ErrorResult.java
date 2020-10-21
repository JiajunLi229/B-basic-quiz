package com.basicquiz.demo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {
    private  String timestamp;
    private  long status;
    private String error;
    private String message;
}
