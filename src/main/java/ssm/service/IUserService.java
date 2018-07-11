package ssm.service;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import ssm.model.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public  User selectUser(long userId);
    public List<User> queryUserList();
    public Map queryUserPage(Map param);
}
