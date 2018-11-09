package com.example.test.entity;

/**
 * @program: test
 * @description: 留言类
 * @author: tankyx
 * @create: 2018-11-05 11:21
 **/
public class LeaveMessage {

    private String mes_id;
    private String usr_id;
    private String mes_content;
    private String create_time;
    private String state;

    public String getMes_id() {
        return mes_id;
    }

    public void setMes_id(String mes_id) {
        this.mes_id = mes_id;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getMes_content() {
        return mes_content;
    }

    public void setMes_content(String mes_content) {
        this.mes_content = mes_content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
