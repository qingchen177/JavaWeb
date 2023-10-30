package basic.reflect.constant;

/**
 * @author qingchen
 * @date 30/10/2023 下午 1:56
 */

public enum MyEnum {
    JAVA("Java", 1),
    CPP("c++", 2);

    private String name;
    private Integer sortNumber;

    MyEnum() {
        this.name = "constructor";
        this.sortNumber = -1;
    }

    MyEnum(String name, int sortNumber) {
        this.name = name;
        this.sortNumber = sortNumber;
    }

    public static MyEnum[] test() {
        return values();
    }
}
