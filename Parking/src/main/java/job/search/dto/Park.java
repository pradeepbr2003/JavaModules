package job.search.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Park {
    private String vehicleNumber;
    private String type;
    private Character parkValue;
}
