package com.gyh.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gyh.mybatisplus.mapper.UserMapper;
import com.gyh.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusPluginsTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);

        IPage<User> userIPage = userMapper.selectPage(page,null);
        System.out.println(page);

    }

    @Test
    //自己写的sql使用分页
    public void testPage01() {
        Page<User> page = new Page<>(1, 3);

        userMapper.selectPageVo(page, 20);
    }
}
