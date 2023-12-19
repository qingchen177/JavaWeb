package basic.reflect.inner.entity;

/**
 * @author qingchen
 * @date 31/10/2023 上午 11:16
 */

public class MyMemberInnerObject {
    private int number = 100;

    private int setNumber(int number) {
        this.number = number;
        return this.number;
    }

    /**
     * *成员内部类
     */
    public class MemberInnerObject {
        private int number = 80;

        public void show() {
            int number = 60;
            System.out.println(number);
            System.out.println(this.number);
            // 成员内部类访问外部类方式：外部类名.this
            System.out.println(MyMemberInnerObject.this.number);
            System.out.println(MyMemberInnerObject.this.setNumber(-1));
            System.out.println(MyMemberInnerObject.this.number);
        }
    }
}
