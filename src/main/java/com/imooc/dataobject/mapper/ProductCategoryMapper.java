package com.imooc.dataobject.mapper;



import com.imooc.dataobject.ProductCategory;
import org.apache.ibatis.annotations.*;


import java.util.List;
import java.util.Map;

@Mapper
public interface ProductCategoryMapper {

    @Insert({"insert into product_category(category_name, category_type) values (#{category_name, jdbcType=VARCHAR}," +
            " #{category_type, jdbcType=INTEGER})"})
    int insertByMap(Map<String, Object> map);


    //写的多的还是对象
    @Insert({"insert into product_category(category_name, category_type) values (#{categoryName, jdbcType=VARCHAR}," +
            " #{categoryType, jdbcType=INTEGER})"})
    int insertByObject(ProductCategory productCategory);

    // select要把获得的结果写出来, 想要的字段名，还要映射成变量
    @Select("select * from product_category where category_type = #{categoryType}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    // 当存在多条数据时
    @Select("select * from product_category where category_name = #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    // 官方规定传多个参数 要添加param
    @Update("update product_category set category_name = #{categoryName} where category_type = #{categoryType} ")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType") Integer categoryType);


    ProductCategory selectByCategoryType(Integer categoryType);
}
