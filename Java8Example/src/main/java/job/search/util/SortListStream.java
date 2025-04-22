package job.search.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortListStream {
    private static final Random random = new Random();

    private static final List<Integer> firstList = random.ints(10, 1, 50).distinct()
            .boxed().toList();
    private static final int[] firstArr = firstList.stream().mapToInt(Integer::intValue).toArray();
    private static final List<Integer> secondList = random.ints(10, 10, 100).distinct()
            .boxed().toList();
    private static final int[] secondArr = secondList.stream().mapToInt(Integer::intValue).toArray();

    public static void merge2UnsortedInto1SortedList() {
        System.out.printf("%n First List = %s", firstList);
        System.out.printf("%n Second List = %s", secondList);

        List<Integer> sortedList = Stream.concat(firstList.stream(), secondList.stream()).sorted().toList();
        List<Integer> uniqueSortedList = Stream.concat(firstList.stream(), secondList.stream()).distinct().sorted().toList();

        System.out.printf("%n Merged Sorted List = %s", sortedList);
        System.out.printf("%n Merged Unique Sorted List = %s", uniqueSortedList);

    }


    public static void merge2UnsortedInto1SortedArray() {
        System.out.printf("%n Second List = %s", convertArrList(secondArr));
        int[] sortedArr = IntStream.concat(Arrays.stream(firstArr), Arrays.stream(secondArr)).sorted().toArray();
        System.out.printf("%n Merged Sorted List = %s", convertArrList(sortedArr));
    }

    private static List<Integer> convertArrList(int[] arr) {
        return Arrays.stream(arr).boxed().toList();
    }
}
