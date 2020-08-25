package qi.wen.com.web.service;

import qi.wen.com.web.DTO.UserLoginDTO;
import qi.wen.com.web.model.User;

public interface IUserService {
    User findUser(User user);

    User queryUser(UserLoginDTO userLoginDTO);
}
