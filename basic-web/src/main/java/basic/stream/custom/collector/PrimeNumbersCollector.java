package basic.stream.custom.collector;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * @author qingchen
 * @date 14/11/2023 下午 5:21
 */

public class PrimeNumbersCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    /**
     * A function that creates and returns a new mutable result container.
     *
     * @return a function which returns a new, mutable result container
     */
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
//        return () ->
//                new HashMap<Boolean, List<Integer>>(2) {
//                    {
//                        put(Boolean.TRUE, new ArrayList<Integer>());
//                        put(Boolean.FALSE, new ArrayList<Integer>());
//                    }
//                };
        return new MySupplier();
    }

    public class MySupplier implements Supplier<Map<Boolean, List<Integer>>> {
        /**
         * Gets a result.
         *
         * @return a result
         */
        @Override
        public Map<Boolean, List<Integer>> get() {
            return new HashMap<Boolean, List<Integer>>(2) {
                {
                    put(Boolean.TRUE, new ArrayList<Integer>());
                    put(Boolean.FALSE, new ArrayList<Integer>());
                }
            };
        }
    }

    /**
     * A function that folds a value into a mutable result container.
     *
     * @return a function which folds a value into a mutable result container
     */
    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true), candidate))
                    .add(candidate);
        };
    }

    /**
     * A function that accepts two partial results and merges them.  The
     * combiner function may fold state from one argument into the other and
     * return that, or may return a new result container.
     *
     * @return a function which combines two partial results into a combined
     * result
     */
    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (m1, m2) -> {
            m1.get(true).addAll(m2.get(true));
            m1.get(false).addAll(m2.get(false));
            return m1;
        };
    }

    /**
     * Perform the final transformation from the intermediate accumulation type
     * {@code A} to the final result type {@code R}.
     *
     * <p>If the characteristic {@code IDENTITY_TRANSFORM} is
     * set, this function may be presumed to be an identity transform with an
     * unchecked cast from {@code A} to {@code R}.
     *
     * @return a function which transforms the intermediate result to the final
     * result
     */
    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    /**
     * Returns a {@code Set} of {@code Collector.Characteristics} indicating
     * the characteristics of this Collector.  This set should be immutable.
     *
     * @return an immutable set of collector characteristics
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

    public static boolean isPrime(List<Integer> primes, int candidate){
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidateRoot)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
}
