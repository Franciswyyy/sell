package com.imooc.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

//驼峰写法和数据库下划线写法一直，如果不一致可以在这里指定
// @Table(name = "s_product") 也是一一对应的
//@Table(name = "product_category")
@Entity
@DynamicUpdate    //比如数据库自己设置的时间，如果更新的话，那么时间会自动更新
@Data
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryType=" + categoryType +
                '}';
    }
}
