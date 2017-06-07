package com.zjut.sys.dto;

/**
 * Created by thRShy on 2017/6/7.
 */
public class Result<T> {
    private String type;
    private T data;

    public Result(String type, T data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
