package job.search;

import job.search.dto.Theatre;
import job.search.dto.Ticket;

import java.util.List;

public class MovieShowExample {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Narthaki");
        System.out.printf("%n----------------------------------------------------------------%n");
        BookService.seatList(theatre.getSeatNumbers());
        System.out.printf("%n----------------------------------------------------------------%n");

        for (; !theatre.isHouseFull(); ) {
            List<Ticket> tickets = BookService.bookSeat("Ranadheera", theatre, 7);
            System.out.printf("%n Ticket issued :  %s %n", tickets);
        }
    }
}