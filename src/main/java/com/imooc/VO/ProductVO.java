package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;
    //这样写为了后端能清楚分辨，而注释为是了的返回给前端是name，前后端是有规范的

    @JsonProperty("type")
    private String categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
