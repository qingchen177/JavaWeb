package basic.reflect.inner.entity;

/**
 * @author qingchen
 * @date 31/10/2023 上午 11:29
 */

public class MyPartInnerObject {
    public int number = 100;

    public void m1(){
        System.out.println("m1");
    }

    public void m2(){
        /**
         * 局部内部类*
         */
        class PartInnerObject{
            private int number = 80;
            void m1() {
                System.out.println("number = " + number);
                MyPartInnerObject.this.m1();
                System.out.println(this.number);
                System.out.println(MyPartInnerObject.this.number);
            }
        }
        new PartInnerObject().m1();
    }

    public void m3(){
        /**
         * 匿名内部类*
         */
        {
            m1();
            number=999;
            System.out.println(number);
            this.m2();
        }
    }
}
