package job.search.util;

import java.io.ObjectStreamException;
import java.util.HashMap;

public class BookingMap extends HashMap<Integer, String> {
    private static volatile BookingMap bookMapInstance = null;


    private BookingMap() {
        if (bookMapInstance != null) {
            throw new IllegalStateException("SeatBooking is already instantiated");
        }
    }

    public static final BookingMap getInstance() {
        if (bookMapInstance == null) {
            synchronized (BookingMap.class) {
                if (bookMapInstance == null) {
                    bookMapInstance = new BookingMap();
                }
            }
        }
        return bookMapInstance;
    }

    @Override
    public String put(Integer seatNumber, String employee) {
        validate(seatNumber);
        String res = super.put(seatNumber, employee);
        return res;
    }

    public void validate(Integer seatNumber) {
        if (seatNumber < 1 || seatNumber > 10) {
            String errorMessage = String.format("Seat Number - %d is invalid, please select valid Seats from 1-10", seatNumber);
            throw new RuntimeException(errorMessage);
        }
        if (this.size() == 10) {
            throw new RuntimeException("Seat is filled | Full House ");
        }
    }

    public void bookSeat(String employee, int seatNumber) {
        this.validate(seatNumber);
        if (this.containsValue(employee)) {
            System.out.printf("%n %s is already allocated for different seat number", employee);
            return;
        }
        if (this.containsKey(seatNumber)) {
            System.out.printf("%n Seat Number - %d already taken by %s", seatNumber, this.get(seatNumber));
        } else {
            this.put(seatNumber, employee);
            System.out.printf("%n Seat Number - %d is booked by %s", seatNumber, employee);
        }
    }

    public void releaseSeat(String employee) {
        if (this.containsValue(employee)) {
            int seatNumber = this.entrySet().stream()
                    .filter(e -> e.getValue().equalsIgnoreCase(employee)).findAny().get().getKey();

            this.remove(seatNumber);
            System.out.printf("%n Seat Number - %d is released by %s", seatNumber, employee);
            System.out.printf("%n Seat booking Details : %s %n", this);
        } else {
            System.out.printf("%n %s is not yet booked |  Invalid Checkout %n", employee);
        }
    }


    private BookingMap readResolve() throws ObjectStreamException {
        return bookMapInstance;
    }

    @Override
    public BookingMap clone() {
        throw new RuntimeException("BookingMap class is not supported for cloning");
    }
}
