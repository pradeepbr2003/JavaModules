package job.search.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lift extends Thread {
    private String liftName;
    private int currentFloor;
    private volatile
    boolean isAvailable;
}