package job.search.cash;

import java.util.Map;

public class CashDispenser100 extends CashDispenser {
    @Override
    public long dispense(long amount, Map<Long, Long> cashMap) {
        if (amount >= 100) {
            cashMap.put(100l, amount / 100);
        }
        return 0l;
    }
}