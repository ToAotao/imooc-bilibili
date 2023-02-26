package com.imooc.bilibili.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse<T> {
    public JsonResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public JsonResponse(T data) {
        this.data = data;
        msg = "success";
        code = "0";
    }
    private String code;
    private String msg;
    private T data;
    public static JsonResponse<String> success(){
        return new JsonResponse<>(null);
    }
    public static JsonResponse<String> success(String data){
        return new JsonResponse<>(data);
    }
    public static JsonResponse<String> fail(){
        return new JsonResponse<>("1","failed");
    }
    public static JsonResponse<String> fail(String code, String msg){
        return new JsonResponse<String>(code, msg);
    }
}
