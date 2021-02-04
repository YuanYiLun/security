package cn.hyperchain.demo.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: chenshouchang@hyperchain.cn
 * Date: 2020-04-14
 * Time: 14:14
 * Description:
 */
@Data
@NoArgsConstructor
public class MyBaseResponse<T> extends BaseResponse<T> {

    public MyBaseResponse(int code) {
        this(code, null, null);
    }

    public MyBaseResponse(int code, String message) {
        this(code, message, null);
    }

    public MyBaseResponse(int code, String message, T data) {
        super(code, message, data);
    }

    public MyBaseResponse(Code code) {
        this(code, null);
    }

    public MyBaseResponse(Code code, T data) {
        this(code.getCode(), code.getMessage(), data);
    }

    public static MyBaseResponse with(Code code) {
        return with(code, null);
    }

    public static <T> MyBaseResponse with(Code code, T data) {
        return new MyBaseResponse<>(code, data);
    }

    @JsonIgnore
    public boolean isSuccessful() {
        return Code.SUCCESS.getCode() == this.getCode();
    }

}
