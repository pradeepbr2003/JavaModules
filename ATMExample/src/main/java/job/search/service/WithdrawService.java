package job.search.service;

import java.util.Map;

public class WithdrawService {

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

    public void withDraw500(long amount, Map<Long, Long> denominationMap) {
        if (amount >= 500) {
            denominationMap.put(500l, amount / 500);
        }
        withDraw200(amount % 500, denominationMap);
    }

}
