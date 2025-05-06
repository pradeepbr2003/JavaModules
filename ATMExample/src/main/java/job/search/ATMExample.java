package job.search;

import job.search.common.AccountHolderEnum;
import job.search.common.AmountEnum;
import job.search.dto.Account;
import job.search.dto.Bank;
import job.search.service.AccountService;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static job.search.common.AmountEnum.*;

public class ATMExample {
    private static final Random random = new Random();
    private static final AccountService accountService = new AccountService();
    private static final Bank bank = new Bank("HDFC");

    public static void main(String[] args) {
        Arrays.stream(AccountHolderEnum.values()).map(ATMExample::getAccount).limit(10)
                .forEach(ATMExample::transaction);
    }

    private static void transaction(Account account) {
        accountService.openAccount(bank, account);
        accountService.deposit(account, Map.of(
                FIVE_HUNDRED.get(),
                random.nextLong(3, 10),
                TWO_HUNDRED.get(), random.nextLong(10, 30),
                HUNDRED.get(), random.nextLong(30, 70)));
        long amt = random.nextInt(10, 100) * AmountEnum.values()[random.nextInt(0, AmountEnum.values().length)]
                .get();
        accountService.withDraw(account, amt);
    }

    private static Account getAccount(AccountHolderEnum ah) {
        return Account.builder()
                .accountNumber(UUID.randomUUID().toString())
                .holderName(ah.name())
                .balance(2000)
                .build();
    }
}