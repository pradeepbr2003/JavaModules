package job.search;

import job.search.dto.Movie;
import job.search.dto.Theatre;
import job.search.dto.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static job.search.validator.BookingValidator.movieAvailableInTheatre;
import static job.search.validator.BookingValidator.showsAvailableForMovie;

public interface BookService {

    static void seatList(boolean[][] seatNumbers) {
        System.out.printf("%n Seats availability :  %n");
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = 0; j < seatNumbers.length; j++) {
                System.out.printf("Seat[%d][%d]= %b ", i + 1, j + 1, seatNumbers[i][j]);
            }
            System.out.printf("%n");
        }
    }

    private static int[][] findAvailableSeat(boolean[][] seatNumbers) {
        for (int i = 0, k = 0; i < seatNumbers.length; i++) {
            for (int j = 0; j < seatNumbers.length; j++) {
                if (seatNumbers[i][j] == false) {
                    return new int[][]{{i, j}};
                }
            }
        }
        System.out.printf("%n----------------------------------------------------------------%n");
        seatList(seatNumbers);
        System.out.printf("%n----------------------------------------------------------------%n");

        System.out.printf("%n House Full ! No Seats %n");
        return null;
    }

    private static int[][] bookSeat(Theatre theatre) {
        boolean[][] seatNumbers = theatre.getSeatNumbers();
        int[][] seatFound = findAvailableSeat(seatNumbers);
        if (seatFound != null) {
            seatNumbers[seatFound[0][0]][seatFound[0][1]] = true;
            seatFound = new int[][]{{seatFound[0][0] + 1, seatFound[0][1] + 1}};
        }
        return seatFound;
    }

    static List<Ticket> bookSeat(String movieName, Theatre theatre, int numOfTickets) {
        Movie movie = movieAvailableInTheatre(theatre, movieName);
        Date showTime = showsAvailableForMovie(theatre, movie);
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < numOfTickets; i++) {
            int[][] seatFound = bookSeat(theatre);
            if (seatFound != null) {
                Ticket ticket = Ticket.builder()
                        .movie(movie).theatreName(theatre.getName()).seatNumber(seatFound).showTime(showTime)
                        .build();
                tickets.add(ticket);
            } else {
                theatre.setHouseFull(true);
                break;
            }
        }
        return tickets;
    }
}
