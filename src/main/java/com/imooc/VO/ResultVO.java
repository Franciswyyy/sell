package com.imooc.VO;


import lombok.Data;

/**
 *   http请求返回最外层的对象
 *
 *   为什么不返回整个实体？
 *   原则是上前端需要什么字段，后端就返回什么，这样的话就保护了某个实体字段的隐私
 */

@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
