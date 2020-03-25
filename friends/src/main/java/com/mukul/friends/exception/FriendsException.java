package com.mukul.friends.exception;

public class FriendsException extends Exception{

    private static final long serialVersionUID = 1L;

    public FriendsException() {
        super();
    }  
    public FriendsException(String msg) {
        super(msg);
    }    
    public FriendsException(String msg, Throwable th) {
        super(msg, th);
    }    
    public FriendsException(Throwable th) {
        super(th);
    }    
}