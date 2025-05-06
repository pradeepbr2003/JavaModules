package job.search.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private final String bankName;
    private List<Account> accountList = new ArrayList<>();

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void openAccount(Account account) {
        if (!accountList.contains(account)) {
            accountList.add(account);
            System.out.printf("%n Account - %s opened with bank  - %s", account.getAccountNumber(), bankName);
        } else {
            System.out.printf("%n Account - %s already exists with bank  - %s", account.getAccountNumber(), bankName);
        }
    }
}
