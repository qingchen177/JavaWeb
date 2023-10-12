package top.qingchen.basicweb.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 特殊代码需要在应用启动后执行，可以通过ApplicationRunner或CommandLineRunner接口实现*
 *
 * @author qingchen
 * @date 12/10/2023 下午 4:36
 */
@Component
public class CommandLineProcessor implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("CommandLineProcessor is triggered. hello 程序启动后执行代码！！！ ");
        System.out.println("1+1=" + Math.random());
    }
}
