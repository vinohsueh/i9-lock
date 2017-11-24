package org.i9.lock.platform.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


public class BindingResultException extends RuntimeException {
    
    private static final long serialVersionUID = -8974911471569919770L;
    
    public HashMap<String, String> errors = new HashMap<String, String>();
    
    public String toErrors() {
        StringBuffer errorStringBuffer = new StringBuffer();
        for(Map.Entry<String, String> entry : errors.entrySet()) {
            errorStringBuffer.append(entry.getValue());
        }
        return errorStringBuffer.toString();
    }
    
    public void addError(String error, String errorMessage) {
        this.errors.put(error, errorMessage);
    }
    
    public BindingResultException(List<FieldError> fieldErrors) {
        for (FieldError fieldError : fieldErrors) {
            System.out.println("dto : " + fieldError.getObjectName() + ", fieldName : " + fieldError.getField()
                    + ", value : " + fieldError.getRejectedValue() + ", err : " + fieldError.getDefaultMessage());
            String error = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            this.addError(error, errorMessage);
        }
    }

    public BindingResultException(BindingResult bindingResult) {
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            System.out.println("dto : " + fieldError.getObjectName() + ", fieldName : " + fieldError.getField()
                    + ", value : " + fieldError.getRejectedValue() + ", err : " + fieldError.getDefaultMessage());
            String error = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            this.addError(error, errorMessage);
        }
    }

    public BindingResultException() {
    }
}
