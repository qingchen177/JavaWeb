package top.qingchen.basicweb;

import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import top.qingchen.basicweb.controller.BasicWebUserController;

@SpringBootTest
class BasicwebApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SAXReader saxReader;

    @Test
    void contextLoads() {
    }

    @Test
    void getBeans() {
        BasicWebUserController basicWebUserController = (BasicWebUserController) applicationContext.getBean("basicWebUserController");
        System.out.println("basicWebUserController = " + basicWebUserController);

        BasicWebUserController bean = applicationContext.getBean(BasicWebUserController.class);
        System.out.println("bean = " + bean);

        BasicWebUserController bean2 = applicationContext.getBean("basicWebUserController", BasicWebUserController.class);
        System.out.println("bean2 = " + bean2);
    }

    @Test
    void getOtherBeans() {
        //获取第三方bean
        String encoding = saxReader.getEncoding();
        System.out.println("encoding = " + encoding);

        Object saxReader = applicationContext.getBean("SAXReader");
        System.out.println("saxReader = " + saxReader);
    }

}
