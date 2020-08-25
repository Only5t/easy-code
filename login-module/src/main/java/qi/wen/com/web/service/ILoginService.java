package qi.wen.com.web.service;

import qi.wen.com.web.DTO.UserLoginDTO;
import qi.wen.com.web.DTO.ResultDTO;
import qi.wen.com.web.model.User;

import javax.servlet.http.HttpServletResponse;

public interface ILoginService {
    ResultDTO<User> login(HttpServletResponse response,UserLoginDTO userLoginDTO);
}
