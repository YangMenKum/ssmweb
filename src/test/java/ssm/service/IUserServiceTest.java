package ssm.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.model.User;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class IUserServiceTest {
    @Autowired
    @Qualifier("userService")           // 当IUserUservicec有多个实现类的时候可以用
    private IUserService  iUserService;//  @Qualifier("userService")来指定用哪个

    @Test
    public void selectUser() {
        User user = iUserService.selectUser(1);
        System.out.println(user.getUsername());
        Assert.assertNotNull(user);
    }
}