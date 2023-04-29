package com.gyh.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

        private Long id;
        private String name;
        private Integer price;
        @Version
        //表示乐观锁版本号字段
        private Integer version;
    }

