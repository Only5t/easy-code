package qi.wen.com.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qi.wen.com.web.DTO.UserLoginDTO;
import qi.wen.com.web.DTO.ResultDTO;
import qi.wen.com.web.model.Audience;
import qi.wen.com.web.model.User;
import qi.wen.com.web.service.ILoginService;
import qi.wen.com.web.service.IUserService;
import qi.wen.com.web.utils.JwtTokenUtil;

import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService implements ILoginService {
    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
    @Autowired
    IUserService iUserService;
    @Autowired
    Audience audience;
    @Override
    public ResultDTO<User> login(HttpServletResponse response,UserLoginDTO userLoginDTO) {
        ResultDTO resultDTO = new ResultDTO();
        User user = iUserService.queryUser(userLoginDTO);
        if (user != null){
            resultDTO.setCode("1");
            resultDTO.setMessage("success");
            // 创建token
            String token = JwtTokenUtil.createJWT(user,audience);
            log.info("### 登录成功, token={} ###", token);
            // 将token放在响应头
            response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY,JwtTokenUtil.TOKEN_PREFIX + token);
            // 将token响应给客户端
            UserLoginDTO userDTO = new UserLoginDTO();
            userDTO.setPassword(user.getPassword());
            userDTO.setUserName(user.getUserName());
            resultDTO.setToken(JwtTokenUtil.TOKEN_PREFIX + token);
            resultDTO.setData(userDTO);
        }else {
            resultDTO.setCode("-1");
            resultDTO.setMessage("登陆失败，用户名或密码错误");
        }
        return resultDTO;
    }
}
