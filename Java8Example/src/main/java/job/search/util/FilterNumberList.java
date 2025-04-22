package job.search.util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FilterNumberList {

    private static final Random random = new Random();
    private static final List<Integer> numList = random.ints(80, 1, 100).distinct().boxed()
            .collect(Collectors.toList());

    public static void multipleOfSpecifiedNumber(int product) {
        System.out.printf("%n Input numbers = %s", numList);

        List<Integer> listMultipleOf5 = numList.stream().filter(num -> (num % product) == 0).toList();
        System.out.printf("%n Multiple of 5 numbers = %s", listMultipleOf5);
    }
}
