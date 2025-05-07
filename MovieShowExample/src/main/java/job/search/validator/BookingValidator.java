package job.search.validator;

import job.search.dto.Movie;
import job.search.dto.Theatre;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookingValidator {

    static Movie movieAvailableInTheatre(Theatre theatre, String movieName) {
        Map<Movie, List<Date>> showTime = theatre.getShowTime();
        Optional<Movie> optMovie = showTime.keySet().stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(movieName)).findAny();

        if (!optMovie.isPresent()) {
            throw new RuntimeException(String.format("%n Movie - %s is not available at Theatre - %s %n", movieName, theatre.getName()));
        }
        return optMovie.get();
    }

    static Date showsAvailableForMovie(Theatre theatre, Movie movie) {
        Map<Movie, List<Date>> showTime = theatre.getShowTime();
        Optional<Date> optShowTime = showTime.get(movie).stream().filter(d -> d.after(new Date())).findFirst();

        if (!optShowTime.isPresent()) {
            throw new RuntimeException(String.format("%n No Shows available for Movie - %s at Theatre - %s %n", movie.getTitle(), theatre.getName()));
        }
        return optShowTime.get();
    }

}
