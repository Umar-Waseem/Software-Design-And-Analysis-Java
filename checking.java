import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class checking extends Account {

    int freeTransactionsForWithdrawal;
    int freeTransactionsForDeposit;

    checking() {
        super();
        this.accountNumber = "";
        this.balance = 0.0;
        this.dateCreated = "";
        this.freeTransactionsForWithdrawal  = 0;
        this.freeTransactionsForDeposit = 0;
    }

    checking(double balance, String date, String accountNumber) {
        this.dateCreated = date;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.freeTransactionsForWithdrawal  = 0;
        this.freeTransactionsForDeposit = 0;
    }

    @Override
    double checkBalance() {
        System.out.println("Your checking account balance is: " + this.balance);
        return this.balance;
    }

    @Override
    void printStatement() {
        System.out.println("Checking Account Number: " + this.accountNumber + "\nBalance: " + this.balance + "\nDate Created: " + this.dateCreated + "\n");
    }
    
    @Override
    void makeDeposit(double amount) {
        if(this.freeTransactionsForDeposit < 2){
            this.freeTransactionsForDeposit++;
            this.balance += amount;
            System.out.println("Deposited " + amount + " successfully in your checking account");
        }
        else{
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            this.deductionRecord += "10.0 deposit fee deducted on " + dtf.format(now) + "\n";

            this.balance -= 10.0; 
            this.balance += amount;
            System.out.println("Deposited " + amount + " successfully in your checking account with deduction of 10.0 deposit fee");
        
        }

    }

    @Override
    void transferAmount(double amount) {
        
    }
    
    @Override
    double calculateZakat() {
        System.out.println("Zakat is not applicable on a checking account");
        return 0.0;
    }
    
    @Override
    void withdraw(double amount) {

        // ? can withdraw more than balance up to 5000
        if(amount > this.balance + 5000){
            System.out.println("Insufficient funds");
        } 
        else {

            if(this.freeTransactionsForWithdrawal < 2){
                this.freeTransactionsForWithdrawal++;
                this.balance -= amount;
                System.out.println("Withdrawal of " + amount + " successful");
            } 
            else {
                this.balance -= amount;
                this.balance -= 10.0;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                this.deductionRecord += "Transaction fee of " + 10.0 + " deducted on " + dtf.format(now) + "\n";
                System.out.println("Withdrawal of " + amount + " successful with deduction of 10.0 transaction fee");
            }
            
        }
    
    }

    // ------------------------------- class own methods ------------------------------- //
    String displayAllDeductions(){
        return this.deductionRecord;
    }

}
