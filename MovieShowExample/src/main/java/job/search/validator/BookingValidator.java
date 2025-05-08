package job.search.validator;

import job.search.dto.ShowTime;
import job.search.dto.Theatre;

import java.util.Date;
import java.util.Optional;

public interface BookingValidator {

    static ShowTime isValidTimeBook(Theatre theatre, String movieName, Date bookTime) {
        if (bookTime.before(new Date())) {
            throw new RuntimeException(String.format("%n Exception : Invalid book time: %s %n Book time should be future time %n", bookTime));
        }
        if (theatre.getShowTimes().stream().noneMatch(st -> st.getMovie().getTitle().equalsIgnoreCase(movieName))) {
            throw new RuntimeException(String.format("%n Exception : Movie - %s does not exists in Theatre - %s %n", movieName, theatre.getName()));
        }

        Optional<ShowTime> optShowTime = theatre.getShowTimes().stream().filter(st -> (st.getDate().equals(bookTime) && st.getMovie().getTitle().equalsIgnoreCase(movieName))).findAny();
        if (optShowTime.isPresent()) {
            return optShowTime.get();
        } else {
            throw new RuntimeException(String.format("%n No Shows for movie - %s available at this booking time - %s  at theatre - %s %n", movieName, bookTime, theatre.getName()));
        }
    }
}
