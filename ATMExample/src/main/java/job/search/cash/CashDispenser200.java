package job.search.cash;

import java.util.Map;

public class CashDispenser200 extends CashDispenser {
    @Override
    public void dispense(long amount, Map<Long, Long> cashMap) {
        if (amount > 200) {
            cashMap.put(200l, amount / 200);
            amount = amount % 200;
        }
        this.nextDispenser.dispense(amount, cashMap);
    }
}
