package job.search.service;

import job.search.cash.CashDispenser;
import job.search.cash.CashDispenser100;
import job.search.cash.CashDispenser200;
import job.search.cash.CashDispenser500;

import java.util.Map;

public class WithdrawService {
    private CashDispenser cashDispenser;

    public WithdrawService() {
        initialize();
    }

    public void withDraw(long amount, Map<Long, Long> denominationMap) {
        cashDispenser.validate(amount);
        cashDispenser.dispenseCash(amount, denominationMap);
    }

    private void initialize() {
        cashDispenser = new CashDispenser500();
        CashDispenser200 cashDispenser200 = new CashDispenser200();
        CashDispenser100 cashDispenser100 = new CashDispenser100();
        cashDispenser.setNextDispenser(cashDispenser200);
        cashDispenser200.setNextDispenser(cashDispenser100);
    }
}
