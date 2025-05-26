package job.search;

import job.search.dto.Account;
import job.search.dto.Bank;
import job.search.helper.ATMHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ATMExampleTest {

    @Mock
    private Bank bank;

    @Test
    public void testMain() {
        String bankName = "HDFC";
        Account account = Account.builder()
                .accountNumber(UUID.randomUUID().toString())
                .holderName("pradeep")
                .balance(2000)
                .build();

        List<Account> accountList = List.of(account);
        when(bank.getBankName()).thenReturn(bankName);
        when(bank.getAccountList()).thenReturn(accountList);

        accountList.forEach(ATMHelper::openAccount);
        accountList.forEach(ATMHelper::depositAmount);
        ATMHelper.withDrawAmount(account);

        assertNotEquals(bank.getAccountList(), null);
        assertEquals(bank.getAccountList().size(), 1);
        assertEquals(bank.getBankName(), bankName);
        assertEquals(bank.getAccountList().get(0), account);
    }
}