package job.search.helper;

import job.search.dto.ShowTime;
import job.search.dto.Theatre;
import job.search.dto.Ticket;
import job.search.service.BookService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

public interface MoveShowHelper {

    void execute();

    static void bookShow(Theatre theatre, List<Date> bookTimeList) {
        Random random = new Random();
        IntStream.rangeClosed(0, 10).forEach(index -> {
            Date bookTime = bookTimeList.get(random.nextInt(0, bookTimeList.size()));
            System.out.println("-------------------------------------------------------");
            System.out.printf("%n Require Movie booking at the time : %s %n", bookTime);
            System.out.println("-------------------------------------------------------");

            Optional<ShowTime> optShowTime = theatre.getShowTimes().stream().filter(st -> st.getDate().equals(bookTime)).findAny();
            displaySeats(optShowTime.get());

            try {
                for (; !optShowTime.get().isHouseFull(); ) {
                    List<Ticket> tickets = BookService.bookSeat("Ranadheera", theatre, 7, bookTime);
                    System.out.printf("%n Ticket issued :  %s %n", tickets);
                }
                displaySeats(optShowTime.get());
                System.out.printf("%n House Full ! No Seats %n");
            } catch (RuntimeException rte) {
                System.out.printf("%n %s %n", rte.getMessage());
            }
        });

    }

    private static void displaySeats(ShowTime showTime) {
        System.out.printf("%n----------------------------------------------------------------%n");
        BookService.seatList(showTime.getSeatNumbers());
        System.out.printf("%n----------------------------------------------------------------%n");
    }
}
