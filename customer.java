class customer {
    String name;
    String address;
    String phoneNumber;
    String accountNumber;

    public customer(){
        this.name = "";
        this.address = "";
        this.phoneNumber = "";
        this.accountNumber = "";
    }
    
    public customer(String name, String address, String phoneNumber, String accountNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
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


    // -------------------------------  utility methods ------------------------------- //
    // function for printing customer
    public void printCustomer(){
        System.out.println("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\nAccount Number: " + accountNumber);
    }
    
}
