package com.jwt.controller;

import com.jwt.bean.ResultTool;
import com.jwt.config.JwtProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试接口")
@RequestMapping(value = "test"+ JwtProperties.v1)
public class TestController {
     @ApiOperation("用户测试接口")
     @GetMapping("/test")
    public ResultTool t1(){
         return ResultTool.success("测试成功");
     }

}
