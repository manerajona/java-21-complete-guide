import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTest {

    private BankAccount account;
    private static int count = 0;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting JUnit tests..");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Tests finished. total=" + count);
    }

    @AfterEach
    void tearDown() {
        count=0;
    }

    @BeforeEach
    void setUp() {
        account = new BankAccount("Jona", "Manera", 1000.00, BankAccount.CHECKING);
    }

    @Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test()
    public void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, () ->
                account.withdraw(600.00, false)
        );
        assertEquals(1000.00, account.getBalance(), 0);
    }

    @Test
    void getBalance() {
        assertEquals(1000.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue(account.isChecking());
    }

    @Test
    public void dummyTest() {
        int i = 1 + 1;
        assertEquals(2, i);
    }
}