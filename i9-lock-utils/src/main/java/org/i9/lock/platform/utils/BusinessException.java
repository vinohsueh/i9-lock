package org.i9.lock.platform.utils;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -4972690800582094962L;

    private int errorCode;

    private String errorMessage;
    
    private Exception exception;
    
    private String exceptionMessage;
    
    public BusinessException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public BusinessException(int errorCode, String errorMessage,String exceptionMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.exceptionMessage = exceptionMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public BusinessException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }
    
    public BusinessException(Exception exception) {
        super();
        this.exception = exception;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    
    
}
