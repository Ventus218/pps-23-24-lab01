package example.model;

public class SimpleBankAccountWithAtm implements BankAccount {

    private final BankAccount bankAccount;

    /**
     * The amount of money that every operation will consume from the balance.
     */
    public static final double fee = 1;

    public SimpleBankAccountWithAtm(final AccountHolder holder, final double balance) {
        this.bankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public AccountHolder getHolder() {
        return this.bankAccount.getHolder();
    }

    @Override
    public double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        final double amountWithFee = amount - fee;
        this.bankAccount.deposit(userID, amountWithFee);
    }

    @Override
    public void withdraw(int userID, double amount) {
        final double amountWithFee = amount + fee;

        if (amountWithFee > getBalance()) {
            throw new IllegalArgumentException("The amount of a withdrawal ($" + amount + ") plus the fee ($" + fee
                    + ") must be lower or a equals to the account balance ($" + getBalance() + ").");
        }

        if (getBalance() >= amountWithFee) {
            this.bankAccount.withdraw(userID, amountWithFee);
        }
    }

}
