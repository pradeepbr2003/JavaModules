package job.search.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenOddOperation {

    private static final List<Integer> numList = IntStream.rangeClosed(0, 100).boxed().toList();

    public static void extractEvenAndOddNumber() {
        Map<Boolean, List<Integer>> listMap = numList.stream().collect(Collectors.partitioningBy(i -> ((i % 2) == 0)));
        System.out.printf("Input numbers = %s", numList);
        System.out.printf("%n Separated Even and Odd numbers %n");
        listMap.forEach((k, v) -> System.out.printf("%n%s%n", v));
    }

}
