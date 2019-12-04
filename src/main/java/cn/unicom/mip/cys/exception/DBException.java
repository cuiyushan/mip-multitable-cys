package cn.unicom.mip.cys.exception;

public class DBException extends Exception {

    // serialVersionUID
    private static final long serialVersionUID = 1837008913832210480L;

    // 异常信息
    public String message;

    public DBException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
