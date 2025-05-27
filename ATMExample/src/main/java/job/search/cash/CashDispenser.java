package job.search.cash;

import java.util.Map;

public abstract class CashDispenser {

    protected CashDispenser nextDispenser;

    public void setNextDispenser(CashDispenser cashDispenser) {
        this.nextDispenser = cashDispenser;
    }

    public void dispenseCash(long amount, Map<Long, Long> cashMap) {
        amount = this.dispense(amount, cashMap);
        if (this.nextDispenser != null) {
            nextDispenser.dispenseCash(amount, cashMap);
        }
    }

    public abstract long dispense(long amount, Map<Long, Long> cashMap);

    public void validate(long amount) {
        if (amount % 100 != 0) {
            throw new RuntimeException(String.format("%n Invalid !: Amount should be multiples of 100/200/500 Rs %n"));
        }
        if (amount < 100) {
            throw new RuntimeException(String.format("%n Invalid !: Amount should be greater than 100 Rs %n"));
        }
    }
}
