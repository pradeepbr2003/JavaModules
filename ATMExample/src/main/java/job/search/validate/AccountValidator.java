package job.search.validate;

import job.search.dto.Account;

import java.util.Map;

public class AccountValidator {
    public static void validate(Account account, Long amount) {
        validateAccount(account);
        checkInsufficientFund(account, amount);
        minimumBalanceCheck(account, amount);
        amountInvalid(amount);
    }

    public static void validate(Account account, Map<Long, Long> amountMap) {
        validateAccount(account);
        validateDeposit(amountMap);
        validateDepositAmount(amountMap);
    }

    public static void validateAccount(Account account) {
        if (account == null) {
            throw new RuntimeException(String.format("%n Invalid : Account %n"));
        }
    }

    public static void checkInsufficientFund(Account account, Long amount) {
        if (account.getBalance() < amount) {
            throw new RuntimeException(String.format("%n Invalid : Requested amount : %d %n Insufficient Fund for %s %n", amount, account));
        }
    }

    public static void minimumBalanceCheck(Account account) {
        if (account.getBalance() < 2000) {
            throw new RuntimeException(String.format("%n Invalid : Minimum balance should be 2000 %n"));
        }
    }

    public static void minimumBalanceCheck(Account account, Long amount) {
        minimumBalanceCheck(account);
        if ((account.getBalance() - amount) < 2000) {
            throw new RuntimeException(String.format("%n Invalid : Requested amount : %d %n Minimum balance should be 2000 %n", amount));
        }
    }

    public static void amountInvalid(Long amount) {
        if (amount < 100) {
            throw new RuntimeException(String.format("%n Invalid : Requested amount : %d %n Amount less than 100 not acceptable %n", amount));
        }
        if ((amount % 100) != 0) {
            throw new RuntimeException(String.format("%n Invalid :  Requested amount : %d %n Amount should be multiple of 100/200/500  %n", amount));
        }
    }


    private static void validateDepositAmount(Map<Long, Long> amountMap) {
        amountMap.keySet().forEach(amt -> {
            if (amt != 100 && amt != 200 && amt != 500) {
                throw new RuntimeException(String.format("%n Invalid : %s %n It should be in 100/200/500 %n", amountMap));
            }
        });
    }

    private static void validateDeposit(Map<Long, Long> amountMap) {
        if (amountMap == null) {
            throw new RuntimeException(String.format("%n Invalid : amount  %s %n", amountMap));
        }
    }
}
