package com.alex.app03_convidados.model;

public class Feedback {

    private boolean mSuccess = true;
    private String mMessage = "";


    public Feedback(String message){
        this.mMessage = message;
    }

    public Feedback(String message, boolean success){
        this.mSuccess = success;
        this.mMessage = message;
    }

    public boolean isSuccess(){
        return this.mSuccess;
    }

    public String getMessage(){
        return this.mMessage;
    }

}
