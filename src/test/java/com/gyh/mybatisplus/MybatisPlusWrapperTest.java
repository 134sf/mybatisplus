package com.gyh.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gyh.mybatisplus.mapper.UserMapper;
import com.gyh.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        //查询用户名包含a，年龄在20-30之间，邮箱信息不为null
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                //ge大于等于  le小于等于
                .between("age",20,30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);

    }
    @Test
    public void test02(){
        //将用户名中包含a并且(年龄大于20或邮箱为null)的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name","a")
                .and(i -> i.gt("age",20).or().isNull("email"));
        updateWrapper.set("name","小黑");
        updateWrapper.set("email","123@gmail.com");
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);

    }
    @Test
    public void test03() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isBlank(username)){
            //StringUtils.isBlank()判断某个字符串是否不为空字符串、不为null、不为空白符
            queryWrapper.like("name",username);
        }
        if (ageBegin != null){
            queryWrapper.ge("age",ageBegin);
        }
        if (ageEnd != null){
            queryWrapper.ge("age",ageEnd);
        }
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    //简化方法3
    public void test04() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isBlank(username), "username", "a")
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
    @Test
    //简化方法4,自动匹配字段
    public void test05() {
        String username = "";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isBlank(username), User::getName, "a")
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    //LambdaUpdateWrapper
    public void test06(){
        //将用户名中包含a并且(年龄大于20或邮箱为null)的用户信息修改
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName,"a")
                .and(i -> i.gt(User::getAge,20).or().isNull(User::getEmail));
        updateWrapper.set(User::getName,"小黑");
        updateWrapper.set(User::getEmail,"123@gmail.com");
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);

    }

}
