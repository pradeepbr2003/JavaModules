package job.search.dto;

import lombok.Builder;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@Builder
public class JobProfile {
    private String skillSet;
    private double yearsOfExp;
    private String currentRole;


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return "JobProfile{\n" +
                skillSet + "\n" +
                df.format(yearsOfExp) + " yrs \n" +
                currentRole + "\n" +
                '}';
    }
}
