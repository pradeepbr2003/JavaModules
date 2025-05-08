package job.search;

import job.search.dto.ShowTime;
import job.search.dto.Theatre;
import job.search.dto.Ticket;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

import static job.search.util.DateEnum.SHOW_TIME;

public class MovieShowExample {

    private static Random random = new Random();

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Narthaki");

        List<Date> bookTimeList = SHOW_TIME.get();

        IntStream.rangeClosed(0, 10).forEach(index -> {
            Date bookTime = bookTimeList.get(random.nextInt(0, bookTimeList.size()));
            System.out.println("-------------------------------------------------------");
            System.out.printf("%n Require Movie booking at the time : %s %n", bookTime);
            System.out.println("-------------------------------------------------------");

            Optional<ShowTime> optShowTime = theatre.getShowTimes().stream().filter(st -> st.getDate().equals(bookTime))
                    .findAny();
            System.out.printf("%n----------------------------------------------------------------%n");
            BookService.seatList(optShowTime.get().getSeatNumbers());
            System.out.printf("%n----------------------------------------------------------------%n");

            try {
                for (; !optShowTime.get().isHouseFull(); ) {
                    List<Ticket> tickets = BookService.bookSeat("Ranadheera", theatre, 7, bookTime);
                    System.out.printf("%n Ticket issued :  %s %n", tickets);
                }
                System.out.printf("%n----------------------------------------------------------------%n");
                BookService.seatList(optShowTime.get().getSeatNumbers());
                System.out.printf("%n----------------------------------------------------------------%n");
                System.out.printf("%n House Full ! No Seats %n");

            } catch (RuntimeException rte) {
                System.out.printf("%n %s %n", rte.getMessage());
            }
        });

    }
}