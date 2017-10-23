package name.nvshen.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import name.nvshen.bean.BaseResult;
import name.nvshen.exception.BaseException;

/**
 * 自定义异常处理
 * @author David
 *
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);
    
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public BaseResult<String> handle(Exception e) {
        BaseResult<String> resule = new BaseResult<String>();
        if (e instanceof BaseException) {
            resule.setCode(((BaseException) e).getCode());
        } else {
            log.error("【系统异常】{}", e);
            resule.setCode(-1);
        }
        resule.setMsg(e.getMessage());
        return resule;
    }
}
