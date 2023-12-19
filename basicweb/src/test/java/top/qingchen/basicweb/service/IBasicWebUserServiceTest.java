package top.qingchen.basicweb.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.qingchen.basicweb.entity.BasicWebUser;

/**
 * @author qingchen
 * @date 12/10/2023 下午 6:42
 */
@SpringBootTest
public class IBasicWebUserServiceTest {

    @Autowired
    private IBasicWebUserService service;

    @Test
    public void test(){
        BasicWebUser id = service.getById(-1);
        System.out.println("id = " + id);

    }
}
