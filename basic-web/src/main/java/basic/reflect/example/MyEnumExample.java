package basic.reflect.example;

import basic.reflect.constant.MyEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author qingchen
 * @date 30/10/2023 下午 3:05
 */

public class MyEnumExample {
    public static void main(String[] args) throws Exception {
        enumReflect(MyEnum.class);
    }

    private static void enumReflect(Class<?> clazz) throws Exception {
        Class<? extends Class> reflectClass = clazz.getClass();
        boolean isEnum = reflectClass.isInstance(Enum.class);
        boolean flag = false;
        if (flag) {
            // 所有的枚举类，都是默认继承java.lang.Enum，
            // 继承了父类除构造函数外的所有东西，
            // 并且子类要帮助父类进行构造，
            // 而我们所写的类并没有帮助父类构造，
            // 枚举比较特殊，虽然我们写了两个参数，
            // 但默认还添加了两个参数 不写此处抛异常NoSuchMethod
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);

            //抛异常IllegalArgumentException
            //表明枚举类不支持反射生成构造方法
            // newInstance 方法中的 if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            //            throw new IllegalArgumentException("Cannot reflectively create enum objects");
            Object o = constructor.newInstance();
            Method test = clazz.getMethod("test");
            Object result = test.invoke(o, null);
            System.out.println("result = " + result);
        }
        Method method = clazz.getMethod("values");
        Object dicts = method.invoke(null, null);
        System.out.println("dicts = " + dicts);
    }
}
