package job.search;

import job.search.dto.Account;
import job.search.dto.Bank;
import job.search.service.AccountService;

import java.util.Map;
import java.util.UUID;

public class ATMExample {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();

        Account account = Account.builder()
                .accountNumber(UUID.randomUUID().toString()).holderName("Pradeep").balance(2000)
                .build();
        Bank bank = new Bank("HDFC");
        accountService.openAccount(bank, account);
        accountService.deposit(account, Map.of(500l, 10l, 200l, 30l, 100l, 100l));
        accountService.withDraw(account, 6500);

        account = Account.builder()
                .accountNumber(UUID.randomUUID().toString()).holderName("Deepak").balance(2000)
                .build();

        accountService.openAccount(bank, account);
        accountService.deposit(account, Map.of(500l, 5l, 200l, 10l, 100l, 3l));
        accountService.withDraw(account, 3200);

    }
}