package com.sanusi.reginstallmentservice.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Response<T> {

    private static final String SUCCESS_MSG = "success";
    private static final String ERROR_CODE = "-1001";

    private Integer status;
    private String message;
    private T data;

    private Response(int status, String msg, T data) {
        this.setStatus(status);
        this.setMessage(msg);
        this.setData(data);
    }

    public static <T> Response<T> success(Integer status, T data) {
        return new Response<T>(status, SUCCESS_MSG, data);
    }

    @Override
    public String toString() {
        return "Response [status=" + status + ",  msg=" + message + ", data=" + data + "]";
    }

}
