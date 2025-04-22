package job.search.util;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Map;

public class SeatBooking implements Serializable {
    private static volatile SeatBooking INSTANCE = null;

    private final BookingMap seatBookMap = BookingMap.getInstance();

    private SeatBooking() {
        if (INSTANCE != null) {
            throw new IllegalStateException("SeatBooking is already instantiated");
        }
    }

    public static final SeatBooking getInstance() {
        if (INSTANCE == null) {
            synchronized (SeatBooking.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SeatBooking();
                }
            }
        }
        return INSTANCE;
    }

    public Map<Integer, String> getSeatBookMap() {
        return seatBookMap;
    }

    public void bookSeat(String employee, int seatNumber) {
        seatBookMap.bookSeat(employee, seatNumber);
    }

    public void releaseSeat(String employee) {
        seatBookMap.releaseSeat(employee);
    }

    private SeatBooking readResolve() throws ObjectStreamException {
        return INSTANCE;
    }

    @Override
    protected SeatBooking clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("SeatBooking class is not supported for cloning");
    }

}
