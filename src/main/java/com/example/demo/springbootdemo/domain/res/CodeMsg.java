package com.example.demo.springbootdemo.domain.res;

import com.example.demo.springbootdemo.domain.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CodeMsg<T> {

    private Boolean success;
    private Integer errorCode;
    private String errorMsg;
    private T data;

    /**
     * 构造
     * @param success
     * @param reseltCodeEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CodeMsg build(Boolean success, ResultCodeEnum reseltCodeEnum, T data) {
        return new CodeMsg(success, reseltCodeEnum.getCode(), reseltCodeEnum.getDesc(), data);
    }

    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CodeMsg success(T data){
        return build(true,ResultCodeEnum.SUCCESS,data);
    }

    /**
     * 失败
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CodeMsg fail(T data){
        return build(false,ResultCodeEnum.FAIL,data);
    }


    /**
     * 不确定
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CodeMsg unknow(T data){
        return build(false,ResultCodeEnum.UNKNOW,data);
    }

}
