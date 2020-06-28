package com.jwt.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
*封装的返回类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultTool {
    private Integer code;
    private String message;
    private Object data;
    public static ResultTool success(Object data){
        ResultTool tool = new ResultTool(200,"成功",data);
        return tool;
    }
    public static ResultTool error(Integer code){
        ResultTool tool = new ResultTool(code,"失败",null);
        return tool;
    }
}
