import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

abstract class Account {
    String accountNumber;
    double balance;
    String dateCreated;
    String deductionRecord;
    
    public Account(){
        this.accountNumber = "";
        this.balance = 0.0;
        this.dateCreated = "";
        this.deductionRecord = "";
    }

    public Account(double balance){
        this.accountNumber = UUID.randomUUID().toString(); // generate random account number - unique number
        this.balance = balance;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.dateCreated = dtf.format(now);
        this.deductionRecord = "";
    }

    // -------------------------------  getters ------------------------------- //
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }

    // -------------------------------  setters ------------------------------- //
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    // -------------------------------  utility methods ------------------------------- //
    abstract double checkBalance();
    abstract void printStatement(Customer customer);
    abstract void makeDeposit(double amount);
    abstract void transferAmount(Account destAccount);
    abstract double calculateZakat();
    abstract void withdraw(double amount); // different limit of withdrawal for different accounts
    abstract void printDeductionRecord();
}
