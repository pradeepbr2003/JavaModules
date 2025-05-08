package job.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ShowTime {
    private Movie movie;
    private Date date;
    private boolean houseFull;
    private boolean[][] seatNumbers;
}
