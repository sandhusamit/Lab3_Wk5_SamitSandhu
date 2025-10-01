public class BankAccount_SS {
    /*
     * Attributes – accountNumber, balance
     * (accountNumber is final)
     * Constructor validates inputs strictly.
     */
    
    protected final int AccountNumber;
    protected double Balance; 
    
    // Constructor with both attributes
    public BankAccount_SS(int accountNumber, double balance) {
        
        // Runtime "type checks"
        if (((Object)accountNumber) instanceof Integer == false) {
            throw new IllegalArgumentException("Account number must be an integer.");
        }
        if (((Object)balance) instanceof Double == false) {
            throw new IllegalArgumentException("Balance must be a double.");
        }
        
        // Validation rules
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        if (accountNumber <= 0) {
            throw new IllegalArgumentException("Account number must be positive.");
        }
        
        AccountNumber = accountNumber;
        Balance = balance;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        if (((Object)balance) instanceof Double == false) {
            throw new IllegalArgumentException("Balance must be a double.");
        }
        Balance = balance;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }
}
