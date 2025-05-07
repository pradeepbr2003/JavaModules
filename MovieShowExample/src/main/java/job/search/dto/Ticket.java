package job.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Ticket {
    private Movie movie;
    private String theatreName;
    private int[][] seatNumber;
    private Date showTime;

}

