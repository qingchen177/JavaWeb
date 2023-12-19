package basic.stream.custom.collector;

import java.util.stream.LongStream;

/**
 * @author qingchen
 * @date 15/11/2023 上午 9:56
 */

public class CollectorDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            long result = sideEffectSum(1_000_000);
            System.out.println(result);
        }
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        public long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
