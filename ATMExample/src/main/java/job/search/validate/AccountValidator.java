package job.search.validate;

import job.search.dto.Account;

import java.util.Map;

public class AccountValidator {

    public static void isValidAccount(Account account) {
        if (account == null) {
            throw new RuntimeException(String.format("%n Invalid : Account %n"));
        }
    }

    public static void checkInsufficientFund(Account account, Long amount) {
        if (account.getBalance() < amount) {
            throw new RuntimeException(String.format("%n Invalid : Insufficient Fund for %s %n", account));
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
            throw new RuntimeException(String.format("%n Invalid : Minimum balance should be 2000 %n"));
        }
    }

    public static void amountInvalid(Long amount) {
        if (amount < 100) {
            throw new RuntimeException(String.format("%n Invalid : Amount less than 100 not acceptable %n"));
        }
        if ((amount % 100) != 0) {
            throw new RuntimeException(String.format("%n Invalid : Amount should be multiple of 100/200/500  %n"));
        }
    }


    public static void validate(Account account, Long amount) {
        isValidAccount(account);
        checkInsufficientFund(account, amount);
        minimumBalanceCheck(account, amount);
        amountInvalid(amount);
    }

    public static void validate(Account account, Map<Long, Long> amountMap) {
        if (account == null) {
            throw new RuntimeException(String.format("%n Invalid : Account %n"));
        }
        if (amountMap == null) {
            throw new RuntimeException(String.format("%n Invalid : amount  %s %n", amountMap));
        }
        amountMap.keySet().forEach(amt -> {
            if (amt != 100 && amt != 200 && amt != 500) {
                throw new RuntimeException(String.format("%n Invalid : %s %n It should be in 100/200/500 %n", amountMap));
            }
        });
    }
}
