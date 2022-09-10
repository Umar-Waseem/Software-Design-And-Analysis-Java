import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class savings extends Account {

    // deduction record

    savings(){
        super();
        this.accountNumber = "";
        this.balance = 0.0;
        this.dateCreated = "";
        this.deductionRecord = "";
    }

    savings(double balance, String date, String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateCreated = date;
        this.deductionRecord = "";
    }


    // -------------------------------  methods being implemented from abstract class --------------------------------------- //
    @Override
    void makeDeposit(double amount) {
        System.out.println("Deposited " + amount + " successfully in your savings account");
        this.balance += amount;
    }

    @Override
    void withdraw(double amount) {
        // ? can only withdraw amount equal or less than balance
        if (amount > this.balance){
            System.out.println("Insufficient funds in your savings account");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal of " +  amount  +  " successful from your savings account");
        }
    }

    @Override
    double checkBalance() {
        System.out.println("Your savings account balance is: " + this.balance);
        return this.balance;
    }

    @Override
    double calculateZakat() {
        double zakat = 0.0;
        if(this.balance > 20000){
            zakat = (this.balance * 2.5) / 100;
            this.balance -= zakat;
            System.out.println("Zakat amount " + zakat + " is deducted from your account");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            deductionRecord += "Zakat Amount: " + zakat + " deducted on " + dtf.format(now) + "\n";
        }
        else{
            System.out.println("You are not eligible for Zakat");
        }
        return zakat;
    }

    @Override
    void printStatement(Customer customer) {
        customer.printCustomer();
        System.out.println("Savings Account Number: " + this.accountNumber + "\nBalance: " + this.balance + "\nDate Created: " + this.dateCreated + "\n");
    }

    @Override
    void transferAmount(Account destAccount) {
        System.out.println("Enter the amount you want to transfer: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        if (amount > this.balance){
            System.out.println("Insufficient funds in your savings account");
        } else {
            this.balance -= amount;
            destAccount.setBalance(destAccount.getBalance() + amount);
            System.out.println("Transfer of " +  amount  +  " successful from your savings account to " + destAccount.accountNumber);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.deductionRecord += "Transfer of " + amount + " to " + destAccount.accountNumber + " successful on " + dtf.format(now) + "\n";
        }
        sc.close();
    }

    // -------------------------------  class own methods ------------------------------- //
    
    void displayAllDeductions(){
        System.out.println(this.deductionRecord);
    }
    // todo void calculateInterestRate(){}
}
