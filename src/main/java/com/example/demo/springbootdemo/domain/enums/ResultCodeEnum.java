package com.example.demo.springbootdemo.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCodeEnum implements BaseEnum{
    SUCCESS(0,"成功"),
    FAIL(1,"失败"),
    UNKNOW(2,"不确定");

    private Integer code;
    private String desc;

    public static ResultCodeEnum codeof(Integer value){

        if (null == value) {
            return null;
        }
        for(ResultCodeEnum ResultCodeEnum:ResultCodeEnum.values()){
            if(ResultCodeEnum.getCode()==value){
                return ResultCodeEnum;
            }
        }
        return null;
    }
}
