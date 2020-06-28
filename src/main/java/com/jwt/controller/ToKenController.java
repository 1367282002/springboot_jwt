package com.jwt.controller;

import com.jwt.bean.ResultTool;
import com.jwt.config.JwtConfig;
import com.jwt.config.JwtProperties;
import com.jwt.pojo.User;
import com.jwt.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(tags = "token接口")
@RequestMapping(value = "user"+JwtProperties.open)
public class ToKenController {


    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    @ApiOperation("用户登录返回token的接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true),
            @ApiImplicitParam(name = "passWord", value = "用密码", required = true)
    })
    public ResultTool login (@RequestParam("userName") String userName,
                             @RequestParam("passWord") String passWord){


        /** 验证userName，passWord和数据库中是否一致，如不一致，直接return ResultTool.errer(); 【这里省略该步骤】*/
        User user = new User();
        user.setUser(userName);
        user.setPassword(passWord);
        // 这里模拟通过用户名和密码，从数据库查询userId
        User loginUser = userService.login(user);

        if(loginUser == null){
            return ResultTool.error(403) ;
        }

        // 这里把userId转为String类型，实际开发中如果subject需要存userId，则可以JwtConfig的createToken方法的参数设置为Long类型
        String userId = loginUser.getUid() + "";
        String token = jwtConfig.createToken(userId) ;
        if (!StringUtils.isEmpty(token)) {

            return ResultTool.success(token) ;
        }
        return ResultTool.error(403);
    }

    @PostMapping("/info")
    public ResultTool info (){
        return ResultTool.success("info") ;
    }
    @ApiOperation("用户获取登录信息")
    @GetMapping("/getUserInfo")
    public ResultTool getUserInfo(HttpServletRequest request){
        String usernameFromToken = jwtConfig.getUsernameFromToken(request.getHeader("token"));
        return ResultTool.success(usernameFromToken) ;
    }



}
