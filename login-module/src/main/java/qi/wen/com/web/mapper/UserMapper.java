package qi.wen.com.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import qi.wen.com.web.model.User;

@Mapper
public interface UserMapper {
    User findUser(User user);

}
