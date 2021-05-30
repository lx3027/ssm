package com.lx.crud.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回的类
 * @author lixun Email:lx3027@126.com
 * @create 2021-05-12 13:55
 */
public class Msg {

    //状态码 100-成功 200-失败
    private int code;
    //提示信息
    private String msg;
    //用过要返回给游览器的数据
    private Map<String,Object> extend = new HashMap<>();

    //成功
    public static Msg success(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功！");
        return result;
    }
    //失败
    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理失败！");
        return result;
    }

    public Msg add(String key,Object value){
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
