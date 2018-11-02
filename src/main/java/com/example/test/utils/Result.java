package com.example.test.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @description: 返回结果封装类
 * @author: tankyx
 * @create: 2018-11-02 15:28
 **/
public class Result {
    //状态码，成功200，失败400
    private int code;
    //错误和成功信息
    private String msg;
    //包含的数据
    private Map<String,Object> extend = new HashMap<String,Object>();

    //成功信息
    public static Result result(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("处理成功！");
        return result;
    }

    //失败信息
    public static Result fail(){
        Result result = new Result();
        result.setCode(400);
        result.setMsg("处理失败");
        return result;
    }

    //添加包含的数据
    public Result add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
