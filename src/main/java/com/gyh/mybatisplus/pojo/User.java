package com.gyh.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.gyh.mybatisplus.enmus.EnumsSex;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//设置实体类所对应的表名
//@TableName("t_user")
public class User {
    //@TableId(value = "uid",type = IdType.AUTO)
    //将这个属性所对应的字段指定为主键
    // @TableId注解的value属性用于指定主键的字段
    //@TableId注解的value属性用于指定主键的生成策略s
    //type表示不使用雪花算法，使用自动递增，前提需要将数据库里自动递增打开
    private Long id;
   // @TableField("user_name")
    //指定属性对应的字段名
    private String name;
    private Integer age;
    private String email;

//    private EnumsSex enumsSex;

   // @TableLogic
    //逻辑删除
//    private Integer isDeleted;
}

