package com.example.test.utils;

import com.alibaba.fastjson.JSON;
/**
 * @program: test
 * @description:
 * @author: tankyx
 * @create: 2018-11-05 15:53
 **/
public class ResponseObject
{
    private Object data;
    private Integer code;

    public static String genObj(Object data){
        ResponseObject res = new ResponseObject();
        res.data = data;
        if(data != null){
            res.code = ResponseCode.HTTP_SUCCESS;
        }else{
            res.code = ResponseCode.HTTP_FAILED;
        }
        return JSON.toJSONString(res);
    }

    public static String genObjWithCode(Integer code){
        ResponseObject res = new ResponseObject();
        res.code = code;
        return JSON.toJSONString(res);
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public static String genError(String errorinfo){
        ResponseObject res = new ResponseObject();
        res.data = errorinfo;
        res.code = ResponseCode.HTTP_EXCEPTION;
        return JSON.toJSONString(res);
    }
}
