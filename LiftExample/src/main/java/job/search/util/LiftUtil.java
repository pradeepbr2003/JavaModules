package job.search.util;

import job.search.dto.Lift;

import java.util.List;

public class LiftUtil {

    private List<Lift> liftList;

    public LiftUtil() {
        if (liftList == null) {
            Lift l1 = Lift.builder().liftName("A").currentFloor(0).isAvailable(true).build();
            Lift l2 = Lift.builder().liftName("B").currentFloor(5).isAvailable(true).build();
            Lift l3 = Lift.builder().liftName("C").currentFloor(1).isAvailable(true).build();
            Lift l4 = Lift.builder().liftName("D").currentFloor(2).isAvailable(true).build();

            Lift l5 = Lift.builder().liftName("E").currentFloor(3).isAvailable(true).build();
            Lift l6 = Lift.builder().liftName("F").currentFloor(4).isAvailable(true).build();
            Lift l7 = Lift.builder().liftName("G").currentFloor(6).isAvailable(true).build();
            Lift l8 = Lift.builder().liftName("H").currentFloor(7).isAvailable(true).build();

            liftList = List.of(l1, l2, l3, l4, l5, l6, l7, l8);
        }
    }

    public void pressUp(int floor) {
        List<Lift> availableLifts = findAvailableLifts();
        availableLifts.forEach(lift -> {
            synchronized (lift) {
                lift.setAvailable(false);
                if (floor == lift.getCurrentFloor()) {
                    System.out.printf("%n Lift-%s is at same Floor-%d Door opened , please get in ! %n", lift.getLiftName(), floor);
                } else if (floor > lift.getCurrentFloor()) {
                    System.out.printf("%n Lift-%s is coming up to Floor-%d... Please wait! %n", lift.getLiftName(), floor);
                    try {
                        Thread.sleep(1000 * (floor - lift.getCurrentFloor()));
                    } catch (InterruptedException e) {
                        System.out.printf("%n Error in lift service !  %s %n", e.getMessage());
                    }
                    System.out.printf("%n Lift-%s  - Floor-%d Door opened , please get into lift ! %n", lift.getLiftName(), floor);
                    lift.setAvailable(true);
                    lift.setCurrentFloor(floor);
                }
                lift.notifyAll();
            }
        });
    }

    public void pressDown(int floor) {
        List<Lift> availableLifts = findAvailableLifts();
        availableLifts.forEach(lift -> {
            synchronized (lift) {
                lift.setAvailable(false);
                if (floor == lift.getCurrentFloor()) {
                    System.out.printf("%n Lift-%s same Floor-%d Door opened, please get in! %n", lift.getLiftName(), floor);
                } else if (floor < lift.getCurrentFloor()) {
                    System.out.printf("%n Lift-%s is coming down to Floor-%d... Please wait! %n", lift.getLiftName(), floor);
                    try {
                        Thread.sleep(1000 * (lift.getCurrentFloor() - floor));
                    } catch (InterruptedException e) {
                        System.out.printf("%n Error in lift service !  %s %n", e.getMessage());
                    }
                    System.out.printf("%n Lift-%s  - Floor-%d Door opened , please get into lift ! %n", lift.getLiftName(), floor);
                    lift.setAvailable(true);
                    lift.setCurrentFloor(floor);
                }
                lift.notifyAll();
            }
        });
    }

    private List<Lift> findAvailableLifts() {
        List<Lift> availableLifts = liftList.stream().filter(l -> l.isAvailable()).toList();
        if (availableLifts.isEmpty()) {
            availableLifts.forEach(lift -> {
                synchronized (lift) {
                    System.out.printf("%n Lift-%d is busy ... Please wait %n", lift.getLiftName());
                    try {
                        lift.wait();
                    } catch (InterruptedException e) {
                        System.out.printf("%n Error : %s %n waiting at Lift-%s %n", e.getMessage(), lift.getLiftName());
                    }
                    notifyAll();
                }
            });
        }
        return availableLifts;
    }

}
