package job.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Student {
    private String studId;
    private String studName;
    private List<String> bookIdList;
}
