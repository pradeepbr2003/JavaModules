package job.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Random;

@Data
@Builder
public class Company {
    private String name;
    private String location;
    private JobDescription jobDescription;

    public void shareProfile(JobSeeker jobSeeker) {
        Random random = new Random();
        Date date1 = new Date(System.currentTimeMillis());
        Date date = new Date(System.currentTimeMillis());
        date.setMonth(random.nextInt(date1.getMonth(), date1.getMonth() + 4));
        jobSeeker.scheduleInterview(Interview.builder().company(this)
                .timeSlot(date).mode("F2F").build());
        System.exit(0);
    }
}
