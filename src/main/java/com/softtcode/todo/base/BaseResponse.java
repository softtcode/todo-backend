package com.softtcode.todo.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseResponse<T> {
    private Boolean success;
    private List<String> messages = new ArrayList<>();
    private T data;

    public static <T> BaseResponse<T> ok(T data){
       BaseResponse<T> baseResponse = new BaseResponse<T>();
        baseResponse.setSuccess(true);
        baseResponse.setData(data);
        return baseResponse;
    }
    public static <T> BaseResponse<T> ok(){
        BaseResponse<T> baseResponse = new BaseResponse<T>();
        baseResponse.setSuccess(true);
        return baseResponse;
    }
}
