import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String accountNumber;
    private Account[] customersAccounts ;
    private int noOfCheckingAccounts;
    private int noOfSavingsAccounts;


    public Customer(){
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        this.customersAccounts = new Account[2];
        this.noOfCheckingAccounts = 0;
        this.noOfSavingsAccounts = 0;
    }
    
    public Customer(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountNumber = UUID.randomUUID().toString();
        this.customersAccounts = new Account[2];
        this.noOfCheckingAccounts = 0;
        this.noOfSavingsAccounts = 0;

    }

    // -------------------------------  getters ------------------------------- //
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Account getCustomerCheckingAccount(){
        if(this.noOfCheckingAccounts == 0){
            System.out.println("No checking account found for this customer");
            return null;
        }
        else{
            return this.customersAccounts[0];
        }
    }

    public Account getCustomerSavingsAccount(){
        if(this.noOfSavingsAccounts == 0){
            System.out.println("No savings account found for this customer");
            return null;
        }
        else{
            return this.customersAccounts[1];
        }
    }

    public int getNoOfCheckingAccounts() {
        return this.noOfCheckingAccounts;
    }

    public int getNoOfSavingsAccounts() {
        return this.noOfSavingsAccounts;
    }


    // -------------------------------  setters ------------------------------- //
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomersAccounts(Account[] customersAccounts) {
        this.customersAccounts = customersAccounts;
    }

    public void setNoOfCheckingAccounts(int noOfCheckingAccounts) {
        this.noOfCheckingAccounts = noOfCheckingAccounts;
    }

    public void setNoOfSavingsAccounts(int noOfSavingsAccounts) {
        this.noOfSavingsAccounts = noOfSavingsAccounts;
    }


    // -------------------------------  utility methods ------------------------------- //
    // function for printing customer
    public void printCustomer(){
        System.out.println("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nAccount Number: " + accountNumber);
    }
    

    public void closeAccount(){
        if(this.noOfCheckingAccounts == 0 && this.noOfSavingsAccounts == 0){
            System.out.println("No account found for this customer");
        }
        else{
            if(this.noOfCheckingAccounts == 1){
                this.customersAccounts[0] = null;
                this.noOfCheckingAccounts = 0;
            }
            if(this.noOfSavingsAccounts == 1){
                this.customersAccounts[1] = null;
                this.noOfSavingsAccounts = 0;
            }
        }
    }

    public void customerInfo(){
        System.out.println("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nAccount Number: " + accountNumber);
    }
    
    public void openNewAccount(int choice){
        
        boolean condition = true;
        
        while (condition) {
            
            System.out.println("What type of account do you want to open ? ");
            System.out.println("1. Checking Account ");
            System.out.println("2. Savings Account ");
    

    
            
            if(choice == 1 && this.noOfCheckingAccounts > 0  ){
                // if choice is for a checking and it already exists 
                System.out.println("You already have a checking account, you cannot create another one.");
                return;
            }
            else if(choice == 2 && this.noOfSavingsAccounts > 0){
                // if choice is for a saving account and it already exists
                System.out.println("You already have a savings account, you cannot create another one.");
                return;
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String dateCreated = dtf.format(now);
            

            switch(choice){
                case 1:
                    // create a checking account
                    this.customersAccounts[0] = new checking(0, dateCreated, this.accountNumber );
                    this.noOfCheckingAccounts++;
                    System.out.println("Checking account created successfully.");
                    condition = false;
                    break;
    
                case 2:
                    // make new savings account
                    this.customersAccounts[1] = new savings(0, dateCreated, this.accountNumber );
                    this.noOfSavingsAccounts++;
                    System.out.println("Savings account created successfully.");
                    condition = false;
                    break;
    
                default:
                    System.out.println("Invalid choice.");
                    condition = false;
                    break;
            }
        }

    }

    public void getCustomerCheckingAccountInfo(){
        this.customersAccounts[0].printStatement(this);
    }

    public void getCustomerSavingsAccountInfo(){
        this.customersAccounts[1].printStatement(this);
    }

}
