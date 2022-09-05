import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class checking extends account {

    int numberOfFreeTransactionsForWithdrawal;

    checking() {
        super();
        this.accountNumber = "";
        this.balance = 0.0;
        this.dateCreated = "";
        this.numberOfFreeTransactionsForWithdrawal  = 0;
    }

    checking(double balance) {
        this.accountNumber = UUID.randomUUID().toString(); // generate random account number - unique number
        this.balance = balance;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.dateCreated = dtf.format(now);
        this.numberOfFreeTransactionsForWithdrawal  = 0;
    }

    @Override
    double checkBalance() {
        return this.balance;
    }

    @Override
    void printStatement() {
        System.out.println("Checking Account Number: " + this.accountNumber + "\nBalance: " + this.balance + "\nDate Created: " + this.dateCreated);
    }
    
    @Override
    void makeDeposit(double amount) {
        this.balance += amount;
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
        } else {
            this.balance -= amount;
            double deductedAmount = 0.0;
            if(this.numberOfFreeTransactionsForWithdrawal < 3){
                this.numberOfFreeTransactionsForWithdrawal++;
            } else {
                deductedAmount = this.balance -= 10.0;
            }
            System.out.println("Withdrawal of" +  amount  +  "successful with deduction of" + deductedAmount);
        }
    }
    
}
