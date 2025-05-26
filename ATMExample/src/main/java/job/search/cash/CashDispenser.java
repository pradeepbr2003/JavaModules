package job.search.cash;

import java.util.Map;

public abstract class CashDispenser {

    protected CashDispenser nextDispenser;

    public void setNextDispenser(CashDispenser cashDispenser) {
        this.nextDispenser = cashDispenser;
    }

    public abstract void dispense(long amount, Map<Long, Long> cashMap);

    public void validate(long amount) {
        if (amount % 100 != 0) {
            throw new RuntimeException(String.format("%n Invalid !: Amount should be multiples of 100/200/500 Rs %n"));
        }
        if (amount < 100) {
            throw new RuntimeException(String.format("%n Invalid !: Amount should be greater than 100 Rs %n"));
        }
    }
}
