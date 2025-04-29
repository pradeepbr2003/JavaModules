package job.search.dto;

import lombok.Builder;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@Builder
public class JobDescription {
    private String requiredSkill;
    private double requiredExp;
    private String designation;

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return "JD {\n" +
                requiredSkill + "\n" +
                df.format(requiredExp) + " yrs \n" +
                designation + "\n" +
                '}';
    }
}
