package ssm.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import ssm.model.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    User selectUser(long id);

    List<User> queryUserList();

    Page<User> queryUserPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
