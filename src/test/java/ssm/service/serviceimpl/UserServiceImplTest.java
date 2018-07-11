package ssm.service.serviceimpl;

import com.github.pagehelper.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.model.User;
import ssm.service.IUserService;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserServiceImplTest {
    @Resource
    IUserService iUserService;

    @Test
    public void selectUser() {
    }

    @Test
    public void queryUserList() {
    }

    @Test
    public void queryUserPage() {
        Map param = new HashMap();
        param.put("limit", 2);
        param.put("offset", 1);
        Map result = iUserService.queryUserPage(param);
        System.out.println(result);
    }
}