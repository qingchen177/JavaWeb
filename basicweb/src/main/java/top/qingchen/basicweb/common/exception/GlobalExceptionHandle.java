package top.qingchen.basicweb.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.qingchen.basicweb.common.constant.GlobalConstant;
import top.qingchen.basicweb.common.pojo.Result;

/**
 * @author qingchen
 * @date 13/10/2023 下午 1:56
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    /**
     * 捕获所有异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result<String> ex(Exception ex) {
        ex.printStackTrace();// 打印堆栈信息
        log.error(GlobalConstant.LOG_PREFIX + "发生异常：" + ex.getMessage());
        return Result.error("操作失败，请联系管理员查看异常信息！");
    }
}
