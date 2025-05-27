package job.search.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class WithdrawServiceTest {

    private WithdrawService withdrawService;
    private Map<Long, Long> cashMap;

    @Before
    public void setUp() throws Exception {
        withdrawService = new WithdrawService();
        cashMap = new HashMap<>();
    }

    @Test
    public void withDraw() {
        long amount = 2300;
        System.out.printf("%n Amount to be with drawn is : %s %n", amount);
        withdrawService.withDraw(amount, cashMap);
        System.out.printf("%n Cash - %s %n ", cashMap);
        assertEquals(cashMap.containsKey(500l), true);
        assertEquals(cashMap.containsKey(200l), true);
        assertEquals(cashMap.containsKey(100l), true);
    }
}