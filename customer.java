import java.util.UUID;

class Customer {
    String name;
    String address;
    String phoneNumber;
    String accountNumber;
    // Account[] customersAccounts;
    

    public Customer(){
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        // this.customersAccounts = new Account[2];
    }
    
    public Customer(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountNumber = UUID.randomUUID().toString();
        // this.customersAccounts = new Account[2];
        // customersAccounts[0] = new checking(0);
        // customersAccounts[1] = new savings(0);

        // customersAccounts[0].setAccountNumber(this.accountNumber);
        // customersAccounts[1].setAccountNumber(this.accountNumber);
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



    // -------------------------------  utility methods ------------------------------- //
    // function for printing customer
    public void printCustomer(){
        System.out.println("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nAccount Number: " + accountNumber);
    }
    
    // make a new account
    public void makeNewAccount(){

    }

    public void closeAccount(){

    }

    public void customerInfo(){
        System.out.println("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nAccount Number: " + accountNumber);
    }

    // public void getCustomerCheckingAccountInfo(){
    //     customerInfo();
    //     this.customersAccounts[0].printStatement();
    // }

    // public void getCustomerSavingsAccountInfo(){
    //     customerInfo();
    //     this.customersAccounts[1].printStatement();
    // }

}
