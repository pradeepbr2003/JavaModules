package job.search.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BankTest {

    private String bankName = "HDFC";
    private Bank bank = new Bank(bankName);

    @Test
    public void testOpenAccount2() {
        Account account = Mockito.mock(Account.class);
        bank.setAccountList(List.of(account));
        bank.openAccount(account);

        assertNotEquals(bank.getAccountList(), null);
        assertEquals(bank.getAccountList().size(), 1);
    }

    @Test
    public void testOpenAccount1() {
        Account account = Mockito.mock(Account.class);
        bank.openAccount(account);

        assertNotEquals(bank.getAccountList(), null);
        assertEquals(bank.getAccountList().size(), 1);
    }

    @Test
    public void testGetBankName() {
        assertEquals(bank.getBankName(), bankName);
    }

    @Test
    public void testGetAccountList() {
        assertEquals(bank.getAccountList().size(), 0);
    }

    @Test
    public void testSetAccountList() {
        List<Account> accountList = List.of(Account.builder().build());
        bank.setAccountList(accountList);
        assertEquals(bank.getAccountList().size(), 1);
    }
}