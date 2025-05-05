package job.search.service;

import job.search.dto.Account;
import job.search.dto.Bank;
import job.search.validate.AccountValidator;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    public void withDraw(Account account, long amount) {
        AccountValidator.validate(account, amount);
        Map<Long, Long> denominationMap = new HashMap<>();
        withDraw500(amount, denominationMap);
        System.out.printf("%n Account Holder - %s withdraw %d amount with denomination of  %s ", account.getHolderName(), amount, denominationMap);
        account.setBalance(account.getBalance() - amount);
        balance(account);
    }

    private void withDraw100(long amount, Map<Long, Long> denominationMap) {
        if (amount >= 100) {
            denominationMap.put(100l, amount / 100);
        }
    }

    private void withDraw200(long amount, Map<Long, Long> denominationMap) {
        if (amount >= 200) {
            denominationMap.put(200l, amount / 200);
        }
        withDraw100(amount % 200, denominationMap);
    }

    private void withDraw500(long amount, Map<Long, Long> denominationMap) {
        if (amount >= 500) {
            denominationMap.put(500l, amount / 500);
        }
        withDraw200(amount % 500, denominationMap);
    }


    public void deposit(Account account, Map<Long, Long> amountMap) {
        AccountValidator.validate(account, amountMap);
        long amount = amountMap.entrySet().stream().mapToLong(e -> e.getKey() * e.getValue()).sum();
        account.setBalance(account.getBalance() + amount);
        System.out.printf("%n An amount of %d is deposited to %s", amount, account);
        balance(account);
    }

    public void openAccount(Bank bank, Account account) {
        AccountValidator.minimumBalanceCheck(account);
        bank.openAccount(account);
        balance(account);
    }

    public void balance(Account account) {
        System.out.printf("%n %s  : Current balance is %s %n", account.getHolderName(), account.getBalance());
    }
}
