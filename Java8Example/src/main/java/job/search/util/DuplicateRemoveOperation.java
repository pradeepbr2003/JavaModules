package job.search.util;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateRemoveOperation {
    private static final Random random = new Random();
    private static final List<Integer> numList = random.ints(100, 1, 100).boxed().toList();

    public static void removeDuplicateNumbers() {
        //Remove Duplicate elements from list
        System.out.printf("%n Input numbers = %s And %n size of list = %d", numList, numList.size());

        List<Integer> uniqueList = numList.stream().distinct().toList();
        System.out.printf("%n%n Unique numbers = %s And %n size of list = %d", uniqueList, uniqueList.size());

        Map<Integer, Long> countMap = numList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.printf("%n%n count map = %s", countMap);

        Map<Integer, Long> duplcateCountMap = countMap.entrySet().stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.printf("%n%n duplicate count map = %s", duplcateCountMap);
    }

}
