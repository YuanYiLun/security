package cn.hyperchain.demo.base;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: chenshouchang@hyperchain.cn
 * Date: 2020-04-14
 * Time: 14:14
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public BaseResponse(int code) {
        this(code, null, null);
    }

    public BaseResponse(int code, String message) {
        this(code, message, null);
    }

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse with(int code) {
        return with(code, null, null);
    }

    public static BaseResponse with(Code code) {
        return with(code);
    }

    public static BaseResponse with(int code, String message) {
        return with(code, message, null);
    }

    public static <T> BaseResponse<T> with(int code, T data) {
        return with(code, null, data);
    }

    public static <T> BaseResponse<T> with(int code, String message, T data) {
        return new BaseResponse<>(code, message, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
