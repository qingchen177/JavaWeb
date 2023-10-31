package basic.reflect.inner.entity;

import java.util.ArrayList;

/**
 * @author qingchen
 * @date 31/10/2023 下午 2:33
 */

public class MyList extends ArrayList {
//    初始化代码块
    {
        add("initial");
        System.out.println("初始化代码块 modCount = " + modCount);
    }

    public MyList(){
        System.out.println("构造方法" + modCount);
    }

}
