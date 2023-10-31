package basic.reflect.compare;

import basic.reflect.compare.comparator.AgeComparator;
import basic.reflect.compare.entity.PaiDaXing;
import basic.reflect.compare.entity.Pikachu;

/**
 * @author qingchen
 * @date 31/10/2023 上午 9:34
 */

public class CompareDemo {
    public static void main(String[] args) {
        Pikachu one = new Pikachu().setAge(1).setName("1");
        Pikachu two = new Pikachu().setAge(2).setName("2");

        if (one.compareTo(two) > 0) {
            System.out.println("one = " + one);
        }

        PaiDaXing three = new PaiDaXing().setAge(3).setName("3");
        PaiDaXing four = new PaiDaXing().setAge(4).setName("4");
        AgeComparator ageComparator = new AgeComparator();

        if (ageComparator.compare(three, four) > 0) {
            System.out.println("three = " + three);
        }
    }
}
