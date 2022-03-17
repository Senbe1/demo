package com.example.demo.springbootdemo.domain.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexEnum implements BaseEnum {

    MALE(1, "男"),
    FAMALE(2, "女");

    private Integer code;
    private String desc;

    public static SexEnum codeOf(Integer value) {
        if (null == value) {
            return null;
        }
        for(SexEnum sexEnum:SexEnum.values()){
            if(sexEnum.getCode()==value){
                return sexEnum;
            }
        }
        return null;
    }
}
