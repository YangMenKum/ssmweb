package ssm.service.serviceimpl;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;
import ssm.dao.IUserDao;
import ssm.model.User;
import ssm.service.IUserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Service 注解 默认生成一个名字是类名（开头小写）的Bean
 * 括号里的userService是自己给Bean起的名字（自己起了就不用默认了）
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    @Override
    public Map queryUserPage(Map param) {
        int pageSize = 0;
        int pageNum = 0;
        pageSize = param.get("limit") == null ? 0 : (int) param.get("limit");
        pageNum = param.get("offset") == null ? 1 : (int) param.get("offset");
        Page<User> page = userDao.queryUserPage(pageNum, pageSize);
        Map map = new HashMap();
        map.put("rows",page.getResult());
        map.put("total",page.getTotal());
        return map;
    }

    ;
}