import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void resetTestClassFields() {
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testFee() {
        assertEquals(1, SimpleBankAccountWithAtm.FEE);
    }

    @Test
    void testDeposit() {
        double depositAmount = 10;
        bankAccount.deposit(accountHolder.getId(), depositAmount);

        double expectedBalance = depositAmount - SimpleBankAccountWithAtm.FEE;
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccount.deposit(2, 50);
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(accountHolder.getId(), 100);
        double initialAmount = bankAccount.getBalance();

        double withdrawalAmount = 10;
        bankAccount.withdraw(accountHolder.getId(), withdrawalAmount);

        double withdrawalAmountWithFee = withdrawalAmount + SimpleBankAccountWithAtm.FEE;
        double expectedBalance = initialAmount - withdrawalAmountWithFee;
        assertEquals(expectedBalance, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> bankAccount.withdraw(accountHolder.getId(), 10)),
                () -> assertEquals(0, bankAccount.getBalance()));
    }
}
