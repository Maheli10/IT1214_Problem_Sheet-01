class BankAccount {
    private int accountNumber; 
    private String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder; 
        this.balance = balance;
    }

    public int getAccountNumber() { 
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Successfully withdrew " + amount + " from account " + accountNumber);
    }
}

class Bank {
    private BankAccount[] account=new BankAccount[5];
    private int numberOfAccounts=0;

    public void addAccount(BankAccount BankAccount) {
        if (numberOfAccounts < account.length) {
            account[numberOfAccounts] = BankAccount;
            numberOfAccounts++;
            System.out.println("Account " + BankAccount.getAccountNumber() + " added successfully.");
        } else {
            System.out.println("Cannot add more accounts.");
        }
    }

    public void withdrawMoney(int accountNumber, double amount) {
        boolean found = false;
        for (int i = 0; i < numberOfAccounts; i++) {
            if (account[i].getAccountNumber() == accountNumber) {
                found = true;
                try {
                    account[i].withdraw(amount);
                } catch (IllegalArgumentException e) {
                    System.out.println("Withdrawal failed for account " + accountNumber + ": " + e.getMessage());
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Account with number " + accountNumber + " not found.");
        }
    }

    public void displayAllAccounts() {
        if (numberOfAccounts == 0) {
            System.out.println("No accounts in the bank yet.");
            return;
        }
        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("Account: "+account[i].getAccountNumber()+",Holder: "+account[i].getAccountHolder()+", Balance: "+account[i].getBalance());
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        bank.withdrawMoney(1001, 6000.0);

        bank.withdrawMoney(1002, 1000.0);

        bank.displayAllAccounts();
    }
}