package exception;

public class Account {
    protected double balance;

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount){
        this.balance = balance + amount;
    }
    public void withdraw(double amount) throws OverDraftException{
        if (balance - amount < 0)
            throw new OverDraftException("Not enough money", this.balance - amount );
        this.balance = balance - amount;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        Account a = new Account(200);
        a.deposit(100);
        try {
            a.withdraw(400);
        } catch (OverDraftException e) {
            System.out.println("Deficit : " + e.getDeficit());
            e.printStackTrace();
        }
    }
}
