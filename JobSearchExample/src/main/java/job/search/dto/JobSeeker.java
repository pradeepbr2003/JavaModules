package job.search.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobSeeker {
    private String candidateName;
    private String candidateEmail;
    private String panNumber;
    private String currentCompany;
    private JobProfile jobProfile;

    public void scheduleInterview(Interview interview) {
        System.out.printf("%n Please find the interview details for %s %n", this);
        System.out.printf("%n %s", interview.toString());
    }
}
