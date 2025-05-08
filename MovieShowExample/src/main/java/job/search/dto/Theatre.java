package job.search.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static job.search.util.DateEnum.SHOW_TIME;

@Data
public class Theatre {
    private final String name;
    private List<ShowTime> showTimes = new ArrayList<>();

    public Theatre(String name) {
        this.name = name;
        initialize();
    }

    private void prepareShowTime(int index) {
        this.showTimes.add(ShowTime.builder()
                .movie(Movie.builder().title("Ranadheera").price(100).build())
                .date(SHOW_TIME.get().get(index))
                .seatNumbers(new boolean[4][4])
                .build());
    }

    private void initialize() {
        IntStream.range(0, SHOW_TIME.get().size() - 1).forEach(this::prepareShowTime);
        this.showTimes.add(ShowTime.builder()
                .movie(Movie.builder().title("Grandfather").price(100).build())
                .date(SHOW_TIME.get().get(SHOW_TIME.get().size() - 1))
                .seatNumbers(new boolean[4][4])
                .build());
    }
}
