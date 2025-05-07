package job.search.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    private String title;
    private int price;
}
