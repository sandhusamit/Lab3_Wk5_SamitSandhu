import java.util.Scanner;

public class DriverMainClass_SamitSandhu {
	/*
	 * DriverMainClass_yourFullName

	//Run 1
	Should Create 3 Objects with dynamic inputs from user using scanner library. 
	Create a Bank Account with initial balance of $1500:
	Deposit $1000 into account:
	New balance after depositing $ ?
	//Run 2 
	Withdraw $600 from account:
	New balance after withdrawing ? 
	//Run 3 
	Withdraw $2500 from account:

	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare  scanner
		Scanner sc = new Scanner(System.in);
		String res = "";
		long accountNum = 0;
			//get user account number
        while (!res.equalsIgnoreCase("q")) 
        {

            
    		//Run 1
            try {
            	//first object
                // Ask for account number
                System.out.println("Enter account number (10 digits) q for quit");
                res  = sc.next();
                
                if (res.equalsIgnoreCase("q")) {
                    System.out.println("Exiting program...");
                    System.exit(0);
                }
                else
                {
                	try
                	{
                		accountNum = Long.parseLong(res);
                		
                	}catch (Exception e) {
                        System.out.println("Unexpected error: " + e.getMessage());
                        sc.nextLine(); // clear buffer to avoid infinite loop
                	}
                }
                	
                // Create bank account with initial balance $1500
                BankAccount_SS myAccount = new BankAccount_SS(accountNum, 1500.00);
                System.out.printf("Initial Balance: %.2f%n", myAccount.getBalance());
                // Deposit $1000
                myAccount.Deposit(1000);
                System.out.println("");
                
                //second object
                System.out.println("Enter Savings Account Details(account num and balance: ");
                SavingsAccount_SS savAccount = new SavingsAccount_SS(sc.nextLong(), sc.nextDouble());
                System.out.printf("Initial Balance: %.2f%n", savAccount.getBalance());
                //Deposit 40
                savAccount.Deposit(40); 
                System.out.println("");
                
                //third object
                System.out.println("Enter Second Account Details(account num and balance: ");
                BankAccount_SS myAccount1 = new BankAccount_SS(sc.nextLong(), sc.nextDouble());
                System.out.printf("Initial Balance: %.2f%n", myAccount1.getBalance());
                //Allows users multiple tries 
                while(true) {
                	try {
                
		                System.out.println("Enter Deposit Amount: ");
		                myAccount1.Deposit(sc.nextDouble());
		                break;
                	}catch (Exception e) {
                        System.out.println("Unexpected error: " + e.getMessage());
                        sc.nextLine(); // clear buffer to avoid infinite loop
                	}

     

  


                }
                System.out.println("");
                //Run 2 - Withdraw
                
                //Account
                System.out.println("Enter withdrawal from main account: ");
                double withdrawal = sc.nextDouble();
                myAccount.Withdraw(withdrawal);
                System.out.println("");
                //SavAccount
                System.out.println("Enter withdrawal from savings: ");  //must have sufficient funds
                withdrawal = sc.nextDouble();
                savAccount.Withdraw(withdrawal);
                System.out.println("");
                //Account1
                System.out.println("Enter withdrawal from second account: ");
                withdrawal = sc.nextDouble();
                myAccount1.Withdraw(withdrawal);
                System.out.println("");
                
                //Run 3
                System.out.println("2500 withdrawn from each account: \n");
                myAccount.Withdraw(2500);
                System.out.println("");

                myAccount1.Withdraw(2500);
                System.out.println("");

                savAccount.Withdraw(2500);
                
                
                
            break; // exit loop if everything went fine
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Try again...\n");
                sc.nextLine(); // clear buffer
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                sc.nextLine(); // clear buffer to avoid infinite loop
            }
                	
        }
	}
}
