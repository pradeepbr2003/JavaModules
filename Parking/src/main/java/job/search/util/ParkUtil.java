package job.search.util;

import job.search.dto.Park;
import job.search.dto.ParkEnum;

import java.util.List;

import static job.search.dto.ParkEnum.FOUR_WHEEL;
import static job.search.dto.ParkEnum.TWO_WHEEL;

public class ParkUtil implements IParkUtil {

    public static void unPark(Park park) {
        if (!parkList.contains(park)) {
            System.out.printf("%n Vehicle with reg-no = %s is already un-parked %n", park.getVehicleNumber());
            return;
        }
        if (park.getType().equalsIgnoreCase(FOUR_WHEEL.value())) {
            unParkVehicle(availableCarPark, FOUR_WHEEL, park, allottedCarPark);
        } else if (park.getType().equalsIgnoreCase(TWO_WHEEL.value())) {
            unParkVehicle(availableScooterPark, TWO_WHEEL, park, allottedScooterPark);
        } else {
            System.out.printf("%n This Vehicle not supported : %s %n", park.getType());
        }
    }

    public static void park(Park park) {
        if (parkList.contains(park)) {
            System.out.printf("%n Vehicle with reg-no = %s is already parked %n", park.getVehicleNumber());
            return;
        }
        if (park.getType().equalsIgnoreCase(FOUR_WHEEL.value())) {
            parkVehicle(availableCarPark, FOUR_WHEEL, park, allottedCarPark);
        } else if (park.getType().equalsIgnoreCase(TWO_WHEEL.value())) {
            parkVehicle(availableScooterPark, TWO_WHEEL, park, allottedScooterPark);
        } else {
            System.out.printf("%n This Vehicle not supported : %s %n", park.getType());
        }
    }

    private static void parkVehicle(List<Character> availablePark, ParkEnum parkEnum, Park park, List<Character> allottedPark) {
        if (availablePark.isEmpty()) {
            System.out.printf("%n Parking Full for %s %n", parkEnum.value());
        } else {
            Character parkingValue = availablePark.remove(random.nextInt(0, availablePark.size()));
            park.setParkValue(parkingValue);
            allottedPark.add(parkingValue);
            parkList.add(park);
        }
    }

    private static void unParkVehicle(List<Character> availablePark, ParkEnum parkEnum, Park park, List<Character> allottedPark) {
        if (!allottedPark.contains(park.getParkValue())) {
            System.out.printf("%n Invalid ! Vehicle is not parked in this zone! %n", park.getVehicleNumber());
        }
        allottedPark.remove(park.getParkValue());
        availablePark.add(park.getParkValue());
        parkList.remove(park);
        System.out.printf("%n %s is un-parked %n", park);
    }

    public static void display() {
        System.out.printf("%n Allotted  and available Parking Lots for 4-wheeler : %s %n", parkDataMap.get(FOUR_WHEEL.value()));
        System.out.printf("%n Allotted  and available Parking Lots for 2-wheeler : %s %n", parkDataMap.get(TWO_WHEEL.value()));

        System.out.printf("%n Parked Vehicle Details : %n Reg Num \t Lot \t Type \t %n");
        System.out.printf("------------------------------------------");
        parkList.forEach(p -> {
            System.out.printf("%n %s \t %s \t %s \t", p.getVehicleNumber(), p.getParkValue(), p.getType());
        });
    }

}
