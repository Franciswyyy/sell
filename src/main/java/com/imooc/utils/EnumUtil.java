package com.imooc.utils;

import com.imooc.enums.CodeEnum;

public class EnumUtil {

    //返回名就是一个枚举
    public static <T extends CodeEnum> T getCode(Integer code, Class<T> enumClass){
        for(T each : enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
