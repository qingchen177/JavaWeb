package top.qingchen.basicweb.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * 读取启动时的命令行参数
 *
 * @author qingchen
 * @date 12/10/2023 下午 1:32
 */
@Component
public class ArgumentReader {
    //    @Autowired  ArgumentReader构造器的@Autowired注解其实可以省略，因为在仅有一个构造器的情况下，框架会自动通过该构造器进行注入
    public ArgumentReader(ApplicationArguments args) {
        if (args.containsOption("test")) {
            System.out.println("test is find.");
            System.out.println("命令参数：" + args.getOptionNames());
            System.out.println("无命令参数：" + args.getNonOptionArgs());

        }
    }
}
