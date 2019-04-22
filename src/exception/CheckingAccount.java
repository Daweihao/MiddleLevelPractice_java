package exception;

public class CheckingAccount extends Account{
    private double overdraftProtection;
    public CheckingAccount(double balance) {
        super(balance);
    }
    public void withdraw(double amount) throws OverDraftException{
        if (this.balance + overdraftProtection - amount < 0)
            throw new OverDraftException("Deficit :",amount - (this.balance + overdraftProtection));
        this.balance -= amount;
    }

    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount(200, 300);
        ca.deposit(100);
        System.out.println(ca.getBalance());
        try {
            ca.withdraw(200);
            ca.withdraw(200);
            ca.withdraw(200);
            ca.withdraw(200);
        } catch (OverDraftException e) {
            System.out.println("Deficit :" + e.getDeficit());
            e.printStackTrace();
        }
    }
}
