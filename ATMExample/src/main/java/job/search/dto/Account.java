package job.search.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String holderName;
    private String accountNumber;
    private long balance;
}
