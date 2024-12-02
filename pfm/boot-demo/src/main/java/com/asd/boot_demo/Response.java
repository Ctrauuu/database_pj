package com.asd.boot_demo;

public class Response <T> {
    private T data;
    private boolean success;
    private String errormessage;

    public static <K> Response<K> newSuccess(K data){
        Response<K> response = new Response<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static Response<Void> newFail(String errormessage){
        Response<Void> response = new Response<>();
        response.setErrormessage(errormessage);
        response.setSuccess(false);
        return response;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }
}
