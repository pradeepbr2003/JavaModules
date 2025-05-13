package job.search.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MaxMinStream {
    private static final List<Integer> list = new Random().ints(10, 1, 50).distinct()
            .boxed().collect(Collectors.toList());

    public static void approach1() {
        System.out.printf("%n Input Numbers :  %s", list);
        int max1 = list.stream().max(Integer::compareTo).get();
        int max2 = list.stream().filter(i -> (i != max1)).max(Integer::compareTo).get();
        int max3 = list.stream().filter(i -> (i != max1) && (i != max2)).max(Integer::compareTo).get();

        System.out.printf("%n Max1 = %d \t ,Max2 = %d \t ,Max3=%d %n", max1, max2, max3);

        int min1 = list.stream().min(Integer::compareTo).get();
        int min2 = list.stream().filter(i -> (i != min1)).min(Integer::compareTo).get();
        int min3 = list.stream().filter(i -> (i != min1) && (i != min2)).min(Integer::compareTo).get();

        System.out.printf("%n Min1 = %d \t ,Min2 = %d \t ,Min3=%d %n", min1, min2, min3);
    }

    public static void approach2() {
        System.out.printf("%n Input Numbers :  %s", list);

        List<Integer> maxList = list.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
        List<Integer> minList = list.stream().sorted().limit(3).toList();
        System.out.printf("%nMax numbers = %s  %n Min numbers = %s", maxList, minList);
    }

    public static void approach3() {
        System.out.printf("%n Input Numbers :  %s", list);

        int[] sortedArr = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        int len = sortedArr.length - 1;

        System.out.printf("%n Min numbers = %s  %n Max numbers = %s",
                List.of(sortedArr[0], sortedArr[1], sortedArr[2]),
                List.of(sortedArr[len], sortedArr[len - 1], sortedArr[len - 2]));
    }

    public static void maxMinOfNumber() {
        System.out.printf("%n Input numbers = %s And %n size of list = %d", list, list.size());
        int max = list.stream().max(Integer::compareTo).get();
        int min = list.stream().min(Integer::compareTo).get();
        System.out.printf("%n Big Number = %d %n Small Number = %d%n", max, min);
        Collections.sort(list);
        System.out.printf("%n Sorted numbers = %s And %n size of list = %d", list, list.size());

    }
}
