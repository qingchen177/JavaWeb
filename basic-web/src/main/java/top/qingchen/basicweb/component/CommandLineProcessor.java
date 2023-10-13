package top.qingchen.basicweb.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.qingchen.basicweb.common.constant.GlobalConstant;

/**
 * 特殊代码需要在应用启动后执行，可以通过ApplicationRunner或CommandLineRunner接口实现*
 *
 * @author qingchen
 * @date 12/10/2023 下午 4:36
 */
@Slf4j
@Component
public class CommandLineProcessor implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(GlobalConstant.LOG_PREFIX + "程序启动已启动");
    }
}
