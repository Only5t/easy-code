package qi.wen.com.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import qi.wen.com.web.DTO.UserLoginDTO;
import qi.wen.com.web.model.User;
import qi.wen.com.web.service.IUserService;

@Service
public class UserService implements IUserService {
    /*@Autowired
    UserMapper userMapper;*/
    @Autowired
    JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger("cdpLog");
    @Override
    public User findUser(User user) {
        //userMapper.findUser(user)
        return null;
    }
    @Override
    public User queryUser(UserLoginDTO userLoginDTO) {
        if (StringUtils.isEmpty(userLoginDTO.getUserName()) || StringUtils.isEmpty(userLoginDTO.getPassword())){
            return null;
        }
        User user;
        String sql = "select * from sys_user t where t.user_Name = '"+userLoginDTO.getUserName()+"'" +
                " and t.password = '"+userLoginDTO.getPassword()+"'";
        try {
            RowMapper<User> rm = BeanPropertyRowMapper.newInstance(User.class);
            user = jdbcTemplate.queryForObject(sql, rm);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
            user = null;
        }
        return user;
    }
}
