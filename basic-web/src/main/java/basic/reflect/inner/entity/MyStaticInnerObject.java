package basic.reflect.inner.entity;

/**
 * @author qingchen
 * @date 31/10/2023 上午 11:05
 */

public class MyStaticInnerObject {
    String name;

    /**
     * *静态内部类
     */
    public static class InnerObject {
        private static final String INNER = "inner";
    }
}
