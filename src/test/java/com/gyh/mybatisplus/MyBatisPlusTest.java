package com.gyh.mybatisplus;

import com.gyh.mybatisplus.mapper.UserMapper;
import com.gyh.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //通过条件构造器查询一个list集合，若灭有条件，则可以设置null为参数
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("134181@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}
