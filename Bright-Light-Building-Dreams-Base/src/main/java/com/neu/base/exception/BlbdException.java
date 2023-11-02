package com.neu.base.exception;

public class BlbdException extends RuntimeException{
    private String errMessage;

    public BlbdException(){
        super();
    }

    public BlbdException(String errMessage){
        super(errMessage);
        this.errMessage = errMessage;
    }

    public String getErrMessage(){
        return errMessage;
    }

    public static  void cast(CommonError commonError){
        throw new BlbdException(commonError.getErrMessage());
    }

    public static void cast(String errMessage){
        throw new BlbdException(errMessage);
    }
}
