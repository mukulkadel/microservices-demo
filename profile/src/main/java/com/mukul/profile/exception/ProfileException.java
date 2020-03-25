package com.mukul.profile.exception;

public class ProfileException extends Exception{

    private static final long serialVersionUID = 1L;

    public ProfileException() {
        super();
    }  
    public ProfileException(String msg) {
        super(msg);
    }    
    public ProfileException(String msg, Throwable th) {
        super(msg, th);
    }    
    public ProfileException(Throwable th) {
        super(th);
    }    
}