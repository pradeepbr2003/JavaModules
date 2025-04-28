package job.search;

import job.search.dto.Park;
import job.search.util.ParkUtil;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static job.search.dto.ParkEnum.FOUR_WHEEL;
import static job.search.dto.ParkEnum.TWO_WHEEL;

public class ParkingExample {
    public static void main(String[] args) {
        Random random = new Random();
        List<String> vehicleType = List.of(FOUR_WHEEL.value(), TWO_WHEEL.value());
        List<Park> parkList = IntStream.rangeClosed(2012, 2025)
                .mapToObj(i -> Park.builder().type(vehicleType.get(random.nextInt(0, 2))).vehicleNumber("KA41-P-" + i).build())
                .toList();
        parkList.forEach(p -> ParkUtil.park(p));
        ParkUtil.display();

        random.ints(parkList.size() / 2, 0, parkList.size())
                .forEach(i -> {
                    ParkUtil.unPark(parkList.get(i));
                });

        ParkUtil.display();
    }
}