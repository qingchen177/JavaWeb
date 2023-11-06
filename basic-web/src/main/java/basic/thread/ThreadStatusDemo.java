package basic.thread;

/**
 * @author qingchen
 * @date 6/11/2023 下午 5:05
 */

public class ThreadStatusDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "1");

        //lambda
        Thread b = new Thread(() -> testMethod(), "2");

        a.start();
        a.join();
//        Thread.sleep(1000L);
        b.start();

        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());

    }

    private static synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
