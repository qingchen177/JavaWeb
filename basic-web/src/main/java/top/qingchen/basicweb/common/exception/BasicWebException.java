package top.qingchen.basicweb.common.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author qingchen
 * @date 13/10/2023 下午 4:49
 */
@Getter
@Setter
@ToString
public class BasicWebException extends RuntimeException {
    /**
     * 异常信息*
     */
    private String message;

    /**
     * 异常码*
     */
    private Integer code;

    public BasicWebException(Throwable cause) {
        super(cause);
    }

    public BasicWebException(String message) {
        this(-1, message);
    }

    public BasicWebException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
