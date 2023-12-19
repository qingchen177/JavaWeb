package top.qingchen.basicweb.common.constant.myenum;

/**
 * @author qingchen
 * @date 18/10/2023 上午 10:11
 */

public enum AuditRecordOperation {
    /**
     * 用于注解BasicWebLog中的operationType
     */

    UNKNOWN("未知"),
    ADD("新增"),
    UPDATE("修改"),
    DELETE("删除"),
    QUERY("查询"),
    UPLOAD("上传"),
    DOWNLOAD("下载"),
    LOGIN_OUT("登出"),
    LOGIN("登录"),
    SIGN("注册");

    private final String value;

    AuditRecordOperation(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
