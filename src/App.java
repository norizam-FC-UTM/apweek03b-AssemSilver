import java.util.Scanner;
import java.util.ArrayList;

class BankAccount {

    String name;
    double balance;
    double dividendRate; // example: 0.05 = 5%
    ArrayList<String> transactionHistory;
    // int idx;

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<String>();
        //this.idx = 0;
        this.transactionHistory.add("Account created with deposit: "+ initialDeposit);
        //this.transactionHistory[idx] = "Account Created with deposit: "+ initialDeposit;
    }

    public double getBalance(){
        return this.balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount <= 0){
            System.out.println("Invalid amount");
        }
        else {
            balance = balance + amount;
            transactionHistory.add("Deposit: " + amount);
            //idx++;
        }
        

    }

    // Withdraw money
    public void withdraw(double amount) {

        if (balance - amount < 0){
            System.out.println("Not enough balance");
        }
        else {
            balance = balance - amount;
            transactionHistory.add("withdraw: " + amount);
            //idx++;
        }
        


        // too simple - need refinement
    }

    // Calculate dividend
    public double calculateDividend() {
        return balance * dividendRate;
    }

    // Apply dividend to balance
    public void applyDividend() {
        double dividend = calculateDividend();
        balance = balance + dividend;
        transactionHistory.add("Add Dividend: " + dividend);
        //idx++;
    }

    public void PrintTransactionHistory(){
        for (int i = 0; i < transactionHistory.size(); i++) {
            System.out.println(transactionHistory.get(i));
        }
    }

    // Set dividend rate
    public void setDividendRate(double rate) {
        dividendRate = rate;
        // too simple - need refinement
    }

    // Display account information
    public void printObjectState() {
        System.out.println("\n===== ACCOUNT INFO =====");
        System.out.println("Name          : " + name);
        System.out.println("Balance       : RM " + balance);
        System.out.println("Dividend Rate : " + dividendRate * 100 + "%");
        System.out.println();
    }
}

public class App {
    public static void main(String[] args) {
        int[] finMark = {88, 75, 60, 80, 90, 95, 77, 91, 77, 80};
        for (int elem:finMark){
            System.out.println(elem);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Bank Account SYSTEM =====");

        
        BankAccount acc1 = new BankAccount("Ali", 10);
        BankAccount a2 = new BankAccount("Bali", 10);
        BankAccount a3 = new BankAccount("Cali", 10);
        BankAccount a4 = new BankAccount("Dali", 10);
        BankAccount a5 = new BankAccount("Eali", 10);


        System.out.println(a3);

        a3.deposit(575);
        a3.setDividendRate(0.125);
        a3.applyDividend();
        a3.printObjectState();

        BankAccount[] accArr = new BankAccount[7]; 
        System.out.println(accArr);
        System.out.println(accArr[0]);
        System.out.println(accArr[1]);
        System.out.println(accArr[2]);
        System.out.println(accArr[3]);
        System.out.println(accArr[4]);


        accArr[0] = acc1;
        accArr[1] = a2;
        accArr[2] = a3;

        accArr[3] = new BankAccount("SITI", 500);
        accArr[4] = new BankAccount("SIVA", 1000);
        accArr[5] = a4;
        accArr[6] = a5;

        //deposit another rm700 to Siti
        accArr[3].deposit(700);

        accArr[4].withdraw(70);
        accArr[4].deposit(400);
        accArr[4].withdraw(200);

        for (int x = 0; x < 7; x++){
            accArr[x].printObjectState();
        }

        for (int x = 0; x < 7; x++){
            accArr[x].setDividendRate(0.075);
            accArr[x].applyDividend();
            accArr[x].printObjectState();
        }

        BankAccount temp = accArr[0];
        for (BankAccount elem : accArr){
            if (elem.getBalance() > temp.getBalance()){
                temp = elem;
            }
        }

        System.out.println("The account with the most balance is: ");
        temp.printObjectState();

        accArr[4].PrintTransactionHistory();    

        System.out.println("===== END OF PROGRAM =====");

        sc.close();
    }
}

/* 
public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANK ACCOUNT SYSTEM =====");

        // Input
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();

        System.out.print("Enter initial deposit: RM ");
        double initialDeposit = sc.nextDouble();

        // Create account
        BankAccount acc1 = new BankAccount(name, initialDeposit);

        System.out.println("\nAccount created successfully.");
        acc1.printObjectState();

        // Deposit
        System.out.println("----- DEPOSIT -----");
        System.out.print("Enter deposit amount: RM ");
        double depositAmount = sc.nextDouble();
        acc1.deposit(depositAmount);
        acc1.printObjectState();

        // Withdraw
        System.out.println("----- WITHDRAW -----");
        System.out.print("Enter withdrawal amount: RM ");
        double withdrawAmount = sc.nextDouble();
        acc1.withdraw(withdrawAmount);
        acc1.printObjectState();

        // Dividend
        System.out.println("----- YEAR-END DIVIDEND -----");
        System.out.print("Enter dividend rate (example 0.05 for 5%): ");
        double rate = sc.nextDouble();
        acc1.setDividendRate(rate);
        acc1.applyDividend();

        acc1.printObjectState();

        System.out.println("===== END OF PROGRAM =====");

        sc.close();
    }
}
    */

/*
 * import java.util.Scanner;
 * 
 * class BankAccount {
 * 
 * String name;
 * double balance;
 * double dividentRate; // e.g. 0.03 = 3%
 * 
 * // Constructor
 * public BankAccount(String name, double initDeposit) {
 * this.name = name;
 * this.balance = initDeposit;
 * }
 * 
 * // Deposit money
 * public void deposit(double amount) {
 * balance = balance + amount;
 * }
 * 
 * // Withdraw money
 * public void withdraw(double amount) {
 * balance = balance - amount;
 * }
 * 
 * // Calculate divident
 * public double calculateDivident() {
 * return balance * dividentRate;
 * }
 * 
 * // Add divident into balance
 * public void applyDivident() {
 * double divident = calculateDivident();
 * balance += divident;
 * }
 * 
 * public void setDividentRate(double theRate) {
 * this.dividentRate = theRate;
 * }
 * 
 * // Display account info
 * public String printObjState() {
 * return "===== ACCOUNT INFO ===== \n" +
 * "Name          : " + name +
 * "Balance       : RM " + balance +
 * "Divident Rate : " + dividentRate * 100;
 * }
 * }
 * 
 * public class App {
 * public static void main(String[] args) throws Exception {
 * System.out.println("Hello, World!");
 * 
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.println("CREATING NEW BANK ACCOUNT");
 * System.out.print("Enter account holder name: ");
 * String name = sc.nextLine();
 * 
 * System.out.println("Enter initial deposit: ");
 * double initialDeposit = sc.nextDouble();
 * 
 * // Create account
 * BankAccount acc1 = new BankAccount(name, initialDeposit);
 * System.out.println("Acc Successfully created...initial deposit=RM" +
 * initialDeposit);
 * acc1.printObjState();
 * // Perform operations
 * System.out.println("\n--- PERFORMING TRANSACTIONS ---");
 * System.out.println("Enter amount Deposit RM...");
 * double depo = sc.nextDouble();
 * acc1.deposit(depo);
 * System.out.println(acc1.printObjState());
 * System.out.println("Enter amount Withdraw RM...");
 * double wd = sc.nextDouble();
 * acc1.withdraw(wd);
 * acc1.printObjState();
 * System.out.
 * println("\n\n\nEND OF 2026 - CALC DIVIDENT AT END OF FINANTIAL YEAR");
 * System.out.println("Enter div rate (ie 0.5 for 5%");
 * double theRate = sc.nextDouble();
 * acc1.setDividentRate(theRate);
 * acc1.applyDivident();
 * 
 * // Final output
 * acc1.printObjState();
 * 
 * sc.close();
 * }
 * }
 */