package job.search.util;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOperation {

    public static void countEachCharacterInString() {
        String name = "pradeep";
        Map<Character, Long> charCountMap = name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.printf("%n Input string = %s %n  count of char = %s ", name, charCountMap);
    }

}
