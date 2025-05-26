package job.search.cash;

import java.util.Map;

public class CashDispenser500 extends CashDispenser {
    @Override
    public void dispense(long amount, Map<Long, Long> cashMap) {
        if (amount > 500) {
            cashMap.put(500l, amount / 500);
            amount = amount % 500;
        }
        this.nextDispenser.dispense(amount, cashMap);
    }
}
