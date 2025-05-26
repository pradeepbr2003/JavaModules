package job.search.cash;

import java.util.Map;

public class CashDispenser100 extends CashDispenser {
    @Override
    public void dispense(long amount, Map<Long, Long> cashMap) {
        cashMap.put(100l, amount / 100);
    }
}