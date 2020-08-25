package qi.wen.com.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qi.wen.com.web.DTO.UserLoginDTO;
import qi.wen.com.web.DTO.ResultDTO;
import qi.wen.com.web.model.User;
import qi.wen.com.web.service.ILoginService;

import javax.servlet.http.HttpServletResponse;


@RestController
public class LoginController {
    @Autowired
    ILoginService iLoginService;
    @ApiOperation(value = "登陆接口")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    private ResultDTO<User> login(HttpServletResponse response, @RequestBody UserLoginDTO userLoginDTO){
        return iLoginService.login(response,userLoginDTO);
    }

    @GetMapping("/users")
    @ApiOperation(value = "用户查询接口")
    public ResultDTO<User> userList() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMessage("success");
        return resultDTO;
    }
}
