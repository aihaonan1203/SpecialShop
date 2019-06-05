package com.jzhson.communal.base;

/**
 * Created by Hjb on 2019/6/5.
 */

public class MessageWrap <T> {

    private String type;
    private T bean;

    public MessageWrap(String type, T bean) {
        this.type = type;
        this.bean = bean;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
