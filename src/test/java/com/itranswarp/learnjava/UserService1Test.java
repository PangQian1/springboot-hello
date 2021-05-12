package com.itranswarp.learnjava;

import mock.User1;
import mock.UserDao;
import mock.UserService1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserService1Test {
    @MockBean
    private UserDao userDao;

    @InjectMocks
    private UserService1 userService1;

    @Before
    public void init() throws Exception {
        // 初始化测试用例类中由Mockito的注解标注的所有模拟对象
        System.out.println("测试开始-----------------");
        MockitoAnnotations.initMocks(this);
    }
    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    @Test
    public void getUserById() throws Exception {
        // 定义当调用mock userDao的getUserById()方法，并且参数为3时，就返回id为200、name为I'm mock3的user对象
        Mockito.when(userDao.getUserById(3)).thenReturn(new User1(200, "I'm mock 3"));

        // 返回的会是名字为I'm mock 3的user对象
        User1 user = userService1.getUserById(3);

        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId(), new Integer(200));
        Assert.assertEquals(user.getName(), "I'm mock 3");
    }

//    public static void main(String[] args) throws Exception {
//        new com.itranswarp.learnjava.UserService1Test().getUserById();
//    }

//
//    @Test
//    public void getName() {
//        String name = service.getName();
//        assertEquals(name,"lyTongXues");
//    }

}

