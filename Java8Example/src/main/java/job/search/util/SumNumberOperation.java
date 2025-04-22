package job.search.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SumNumberOperation {
    public static void sumOfAllnumbers() {
        Random random = new Random();
        List<Integer> numList = random.ints(10, 1, 10).boxed().toList();
        System.out.printf("%n Input numbers = %s", numList);

        int sum = numList.stream().reduce(Integer::sum).get();

        System.out.printf("%n Sum of list = %d", sum);

        int sum1 = numList.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.printf("%n Sum of list = %d", sum1);

        int sum2 = numList.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("%n Sum of list = %d", sum2);

    }

}
