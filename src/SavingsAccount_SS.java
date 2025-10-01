
public class SavingsAccount_SS extends BankAccount_SS
{

	
	/*
	 * Savings account needs to inherit Account 
	 * All the aspects of account and nothing additional 
	 */
	
	//Same arguments for constructor as parent class
	public SavingsAccount_SS(long accountNumber, double balance)
	{
		//Call superclass constructor (base arguments)
		//initialized
		super(accountNumber, balance);
		
		//enforce positive balance
		  if(balance < 0)
		  {
			  //since object is initialized, ensure its 0.
	          this.Balance = 0;	
			  throw new IllegalArgumentException("Balance must be positive. Set to 0"); //throw exception to let console know
		  }	
	
		
		
		
	}
	
	//SavingsAccount cannot have overdraft - override setter 
	
	@Override
	public void setBalance(double balance) {
        if (((Object)balance) instanceof Double == false) {
            throw new IllegalArgumentException("Balance must be a double.");
        }
        
        if(balance < 0)
        	throw new IllegalArgumentException("Balance must be positive");
        this.Balance = balance;
		
	}
	@Override
    //Withdraw method - decrease balance BUT cannot exceed balance 50(no OD)
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
		//HAS to have enough to cover the withdraw in the balance 
		if (newBalance < 50)
		{
			//Insufficient funds
			System.out.printf("Balance: %.2f%nShort By: %.2f%n", this.Balance, newBalance);
			throw new IllegalArgumentException("Insufficient Funds!");
		}
		//Assigned new balance
		this.Balance = newBalance;
		System.out.printf("New Balance: %.2f", newBalance); //let console know the new balance
	    
    }
	
}
