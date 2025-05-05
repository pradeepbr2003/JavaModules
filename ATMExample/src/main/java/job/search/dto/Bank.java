package job.search.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Bank {
    private final String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    Map<String, List<Account>> accountMap = new HashMap<>();

    public void openAccount(Account account) {
        if (accountMap.containsKey(bankName)) {
            this.accountMap.get(bankName).add(account);
        } else {
            this.accountMap.put(bankName, new ArrayList<>(List.of(account)));
        }
        System.out.printf("%n Account - %s opened with bank  - %s", account.getAccountNumber(), bankName);
    }
}
