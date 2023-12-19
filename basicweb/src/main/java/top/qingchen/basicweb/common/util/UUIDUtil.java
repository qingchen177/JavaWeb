package top.qingchen.basicweb.common.util;

import java.util.UUID;

/**
 * @author qingchen
 * @date 27/10/2023 上午 9:14
 */

public class UUIDUtil {
    /**
     * 生成uuid，去除'-'，大写
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

    }
}
