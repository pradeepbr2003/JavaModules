package job.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Interview {
    private Date timeSlot;
    private String mode;
    private Company company;

    @Override
    public String toString() {
        return "Interview{\n" + timeSlot + "\n" +
                mode + "\n" + company + "\n" +
                "}";
    }
}
