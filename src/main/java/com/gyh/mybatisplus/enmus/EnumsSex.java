package com.gyh.mybatisplus.enmus;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum EnumsSex {
    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue //将注解所标识的属性的值存储到数据库中
    // 还需要i扫描通用枚举的包
    private Integer sex;
    private String sexName;

    EnumsSex() {
    }

    EnumsSex(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
