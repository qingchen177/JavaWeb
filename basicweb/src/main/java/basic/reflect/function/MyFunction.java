package basic.reflect.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @author qingchen
 * @date 31/10/2023 下午 3:27
 */

public class MyFunction {
    public static void main(String[] args) {
        //消费性接口
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        consumer.accept(6);
        //lambda表达式形式
        Consumer<List<String>> consumer1 = (a) -> a.add("name");
        Consumer<List<String>> consumer2 = (b) -> b.add("age");
        ArrayList<String> list = new ArrayList<>();
        consumer1.andThen(consumer2).accept(list);
        list.forEach(System.out::println);

        //供给型接口
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "name";
            }
        };
        System.out.println(supplier.get());
        //lambda 表达式形式
        Supplier<String> supplier1 = () -> "name";


        //断言型接口
        Predicate<String> predicate1 = (x) -> x.equals("name");
        System.out.println(predicate1.test("name"));
        System.out.println(predicate1.negate().test("name"));
        Predicate<String> predicate2 = (x) -> x.endsWith("s");
        System.out.println(predicate1.and(predicate2).test("name"));
        System.out.println(predicate1.or(predicate2).test("name"));
    }
}
