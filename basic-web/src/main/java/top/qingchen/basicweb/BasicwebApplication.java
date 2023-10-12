package top.qingchen.basicweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicwebApplication {

    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(BasicwebApplication.class);
//        //设置禁用banner打印
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.run(args);
        SpringApplication.run(BasicwebApplication.class, args);
    }

}
