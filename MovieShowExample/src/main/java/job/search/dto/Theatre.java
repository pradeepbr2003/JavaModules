package job.search.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class Theatre {
    private final String name;
    private boolean houseFull;
    private boolean[][] seatNumbers = new boolean[4][4];
    private Map<Movie, List<Date>> showTime;

    public Theatre(String name) {
        this.name = name;
        intialize();
    }

    private void intialize() {
        Movie movie = Movie.builder().title("Ranadheera").price(100).build();
        Movie movie1 = Movie.builder().title("Grandfather").price(100).build();
        List<Date> dates = List.of(new Date("07-may-2025 11:30 pm"), new Date("07-may-2025 2:30 pm"), new Date("07-may-2025 5:30 pm"));
        List<Date> dates1 = List.of(new Date("07-may-2025 8:30 pm"));
        showTime = Map.of(movie, dates, movie1, dates1);
    }
}
