package job.search.util;

import job.search.dto.Park;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static job.search.dto.ParkEnum.*;

public interface IParkUtil {
    Random random = new Random();
    List<Park> parkList = new ArrayList<>();

    List<Character> availableCarPark = IntStream.rangeClosed(65, 77).mapToObj(i -> ((char) i)).collect(Collectors.toList());
    List<Character> availableScooterPark = IntStream.rangeClosed(78, 90).mapToObj(i -> ((char) i)).collect(Collectors.toList());

    List<Character> allottedCarPark = new ArrayList<>();
    List<Character> allottedScooterPark = new ArrayList<>();

    Map<String, List<Character>> carParkDataMap = Map.of(AVAILABLE.value(), availableCarPark, ALLOTTED.value(), allottedCarPark);
    Map<String, List<Character>> scooterParkDataMap = Map.of(AVAILABLE.value(), availableScooterPark, ALLOTTED.value(), allottedScooterPark);

    Map<String, Map<String, List<Character>>> parkDataMap = Map.of(FOUR_WHEEL.value(), carParkDataMap, TWO_WHEEL.value(), scooterParkDataMap);

}
