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
        
        //More than 0 balance at first - can be negative after (overdraft)
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        // Account number must be valid (no 0) 
        // AccountNumber should be only 10 digits min and max 
        //    - assign a local var for length 
        int length = String.valueOf(accountNumber).length(); // length will be 5
        
        if (accountNumber <= 0 && length != 10) 
        {
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
    
    //Deposit Method - increase balance
    public void Deposit(double amount)
    {
    	//validation on amount 
    		//must be a double and more than 0 
    	if (amount <= 0 || (((Object)amount) instanceof Double == false)) 
    	{
            throw new IllegalArgumentException("Amount must be a decimal and more than 0.");
    	}
    	//if it makes it here than assign new balance 
    	double newBalance = this.Balance + amount;
    	this.Balance = newBalance;
    	System.out.printf("New Balance: $f", newBalance); //let console know the new balance
    }
    
    //Withdraw method - decrease balance
    public void Withdraw(double amount)
    {
    	//validation on amount 
		//must be a double and more than 0 
		if (amount <= 0 || (((Object)amount) instanceof Double == false)) 
		{
	        throw new IllegalArgumentException("Amount must be a decimal and more than 0.");
		}
		//if it makes it here than assign new balance 
		double newBalance = this.Balance - amount;
		this.Balance = newBalance;
		System.out.printf("New Balance: $f", newBalance); //let console know the new balance
	    
    }
    
}
