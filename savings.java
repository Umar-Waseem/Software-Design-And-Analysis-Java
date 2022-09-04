import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class savings extends account {

    savings(double balance){
        this.accountNumber = UUID.randomUUID().toString(); // generate random account number - unique number
        this.balance = balance;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.dateCreated = dtf.format(now);
    }


    // -------------------------------  methods being implemented from abstract class --------------------------------------- //
    @Override
    void makeDeposit(double amount) {
        this.balance += amount;
    }

    @Override
    void withdraw(double amount) {
        // ? can only withdraw amount equal or less than balance
        if (amount > this.balance){
            System.out.println("Insufficient funds");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal of" +  amount  +  "successful");
        }
    }

    @Override
    double checkBalance() {
        return this.balance;
        // todo display name
    }

    @Override
    double calculateZakat() {
        double zakat = 0.0;
        if(this.balance > 20000){
            zakat = (this.balance * 2.5) / 100;
            System.out.println("Zakat amount " + zakat + " is deducted from your account");
        }
        else{
            System.out.println("You are not eligible for Zakat");
        }
        return zakat;
    }

    @Override
    void printStatement() {
        System.out.println("Account Number: " + this.accountNumber + "\nBalance: " + this.balance + "\nDate Created: " + this.dateCreated);
        // todo print customer information
    }

    @Override
    void transferAmount(double amount) {
        if (amount > this.balance){
            System.out.println("Insufficient funds");
        } else {
            this.balance -= amount;
            System.out.println("Transfer of" +  amount  +  "successful");
        }
        // todo transfer to specific account
    }

    // -------------------------------  class own methods ------------------------------- //
    
    // todo void displayAllDeductions(){}
}
