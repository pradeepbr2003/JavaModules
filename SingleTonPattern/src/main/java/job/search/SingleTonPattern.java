package job.search;

import job.search.util.SeatBooking;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class SingleTonPattern {
    private final Random random = new Random();

    private final List<String> employees = IntStream.rangeClosed(10, 110).mapToObj(i -> "Employee-" + i).toList();
    private final List<Integer> seatNumbers = IntStream.rangeClosed(1, 10).boxed().toList();

    public static void main(String[] args) {
        SingleTonPattern obj = new SingleTonPattern();

        Thread bookingThread = new Thread(() -> {
            obj.checkInBooking();
        }, "bookingThread");

        Thread releaseThread = new Thread(() -> {
            obj.checkOutBooking();
        }, "releaseThread");

        releaseThread.start();
        bookingThread.start();
    }

    private void checkInBooking() {
        for (; ; ) {
            SeatBooking seatBooking = SeatBooking.getInstance();
            int seatNumber = seatNumbers.get(random.nextInt(0, 10));
            String employee = employees.get(random.nextInt(0, 10));

            try {
                seatBooking.bookSeat(employee, seatNumber);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.printf("%n Seat booking Details : %s %n", seatBooking.getSeatBookMap());
                System.out.printf("%n Exception : %s %n", e.getMessage());
                System.exit(0);
            }
        }
    }

    private void checkOutBooking() {
        for (; ; ) {
            SeatBooking seatBooking = SeatBooking.getInstance();
            String employee = employees.get(random.nextInt(0, 10));
            try {
                seatBooking.releaseSeat(employee);
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.printf("%n Seat booking Details : %s %n", seatBooking.getSeatBookMap());
                System.out.printf("%n Exception : %s %n", e.getMessage());
                System.exit(0);
            }
        }
    }
}
