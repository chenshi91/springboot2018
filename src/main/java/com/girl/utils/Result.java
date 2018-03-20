package com.girl.utils;

public class Result {
    private Integer code;
    private String  message;
    private Object  object;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Result(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public Result() {
    }

    public static Result success(Object object){
        return new Result(200,"success",object);
    }
    public static Result error(String message){
        return new Result(500, message, null);
    }
    public static Result myError(Integer code,String message){
        return new Result(code, message, null);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }

    public static void  main(String[] args){
        Result hello = Result.success("hello");
        System.out.println(hello);
        System.out.println("hello word");
    }
}
