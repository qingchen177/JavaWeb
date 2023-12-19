package basic.thread;

/**
 * @author qingchen
 * @date 7/11/2023 下午 1:34
 */

public class MyThreadPoolExecutor {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    public static void main(String[] args) {
        System.out.println(COUNT_BITS);
        System.out.println(CAPACITY);
        // 补码0000 0010 ~ 补码1111 1101 反码1111 1100 原码1000 0011
        System.out.println(~2);
    }
}
