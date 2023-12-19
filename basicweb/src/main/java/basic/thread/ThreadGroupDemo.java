package basic.thread;

/**
 * @author qingchen
 * @date 6/11/2023 下午 4:37
 */

public class ThreadGroupDemo {
    public static void main(String[] args) {

        //获取线程组名字
        Thread thread = new Thread(()->{
            System.out.println("current thread group name:"+Thread.currentThread().getThreadGroup().getName());
            System.out.println("current thread name:"+Thread.currentThread().getName());

        });

        thread.start();
        System.out.println("main method thread name:"+Thread.currentThread().getName());

        //设置线程组统一异常
        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        Thread thread1 = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("test exception");
            }
        });

        thread1.start();
    }


}
