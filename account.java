abstract class account {
    String accountNumber;
    double balance;
    String dateCreated;
    
    public account(){
        this.accountNumber = "";
        this.balance = 0.0;
        this.dateCreated = "";
    }

    public account(String accountNumber, double balance, String dateCreated){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dateCreated = dateCreated;
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
    abstract void makeDeposit(double amount);
    abstract void printStatement();
    abstract double calculateZakat();
    abstract void withdraw(double amount); // different limit of withdrawal for different accounts

}
