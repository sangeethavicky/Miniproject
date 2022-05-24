
import java.util.Scanner;

public class AccountDriver {

    // Entry point of program
   public static void main(String[]args)
	{
	   System.out.println(" Read the Public username and password and Enter");
	   System.out.println("Username=Public and password=Bank");
	   Scanner input=new Scanner(System.in);
		String user,pass;
		System.out.print("Enter User name:");
		user=input.nextLine();
		System.out.print("Enter password:");
		pass=input.nextLine();
		if(user.equals("Public")&&(pass.equals("Bank")))
				{
			System.out.println("welcome to Bank Application");
			System.out.println("*****************************");
				}
		else
		{
			System.out.println("Sorry Try Again");
		}
		
				

        Scanner keyboard = new Scanner(System.in);

        // Create array of Accounts
        Account accounts [] = new Account[10];
        int numAccounts = 0; 

        int choice;

        do {
            choice = menu(keyboard);
            System.out.println();

            if(choice == 1) {
                accounts[numAccounts++] = createAccount(keyboard);
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts, keyboard);
            } else if(choice == 3) {
                doWithdraw(accounts, numAccounts, keyboard);
            } else if(choice == 4) {
                applyInterest(accounts, numAccounts, keyboard);
            } else {
                System.out.println("GoodBye!");
            }
            System.out.println();
        } while(choice != 5);
    }

   
    
    public static int accountMenu(Scanner keyboard) {
    	
        System.out.println("Select Account Type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        }while(choice < 1 || choice > 2);

        return choice;
    } 

    public static int searchAccount(Account accounts [], int count, int accountNumber) {

        for(int i=0; i<count; i++) {
            if(accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }

        return -1; 
    }

    
    public static void doDeposit(Account accounts [], int count, Scanner keyboard) {
        // Get the account number
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Please enter Deposit Amount: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {
       
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

       
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
          
            System.out.print("Please enter Withdraw Amount: ");
            double amount = keyboard.nextDouble();
            accounts[index].withdraw(amount);
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts [], int count, Scanner keyboard) {
      
        System.out.print("\nPlease enter account number: ");
        int accountNumber = keyboard.nextInt();

    
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {

      
            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No account exist with AccountNumber: " + accountNumber);
        }
    }

    
    public static Account createAccount(Scanner keyboard) {

        Account account = null; 
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print("Enter Account Number: ");
        accountNumber = keyboard.nextInt();

        if(choice == 1)  {
            System.out.print("Enter Transaction Fee: ");
            double fee = keyboard.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else { // Savings account

            System.out.print("Please enter Interest Rate: ");
            double ir = keyboard.nextDouble();
            account = new SavingsAccount(accountNumber, ir);
        }
        return account;
    }

    
    public static int menu(Scanner keyboard) {
    	System.out.println("**********************************");
    	System.out.println("Welcome to Application");
    	System.out.println("***********************************");
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 5);

        return choice;
    }    
}


