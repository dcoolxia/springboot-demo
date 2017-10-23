package name.nvshen.exception;

import name.nvshen.enums.ResultEnum;

/**
 * 自定义异常
 * @author David
 *
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -3328093232585086487L;
    
    private int code;

    public BaseException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum. getCode();
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
}
