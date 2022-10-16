
import util.InputUtil;
import util.OutputUtil;

public class MenuView {

    public static void menu() {
        InputUtil.init();
        OutputUtil.clrScreen();

        System.out.println("Welcome to the Account Management System");

        System.out.println("Please enter the name of customer: ");
        String customerName = InputUtil.getStringInput();

        System.out.println("Please enter the address of customer: ");
        String customerAddress = InputUtil.getStringInput();

        System.out.println("Please enter the phone number of customer: ");
        String customerPhoneNumber = InputUtil.getStringInput();

        Customer customer = new Customer(customerName, customerAddress, customerPhoneNumber);

        System.out.println("Customer created successfully");
        System.out.println("Welcome " + customer.getName() + "!");

        System.out.println("Please select an option from the menu below: ");
        System.out.println("1. Create a new account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Transfer money");
        System.out.println("5. View account details");
        System.out.println("6. Display deductionRecords");
        System.out.println("7. Exit");

        int option = InputUtil.getIntInput();

        do {
            switch (option) {
                case 1:
                    System.out.println("Please select the type of account you want to create: ");

                    System.out.println("1. Checking Account");
                    System.out.println("2. Savings Account");

                    int accountType1 = InputUtil.getIntInput();
                    customer.openNewAccount(accountType1);

                    break;

                case 2:
                    System.out.println("Please select the type of account you want to deposit money in: ");

                    System.out.println("1. Checking Account");
                    System.out.println("2. Savings Account");

                    int accountType2 = InputUtil.getIntInput();

                    System.out.println("Please enter the amount you want to deposit: ");
                    double amount = InputUtil.getDoubleInput();

                    if (accountType2 == 1) {
                        customer.getCustomerCheckingAccount().makeDeposit(amount);
                    } else if (accountType2 == 2) {
                        customer.getCustomerSavingsAccount().makeDeposit(amount);
                    } else {
                        System.out.println("Invalid account type");
                    }

                    break;

                case 3:
                    
                System.out.println("Please select the type of account you want to withdraw money from: ");
                    
                    System.out.println("1. Checking Account");
                    System.out.println("2. Savings Account");
                    int accountType3 = InputUtil.getIntInput();
                    System.out.println("Please enter the amount you want to withdraw: ");
                    double amount2 = InputUtil.getDoubleInput();
                    if (accountType3 == 1) {
                        customer.getCustomerCheckingAccount().withdraw(amount2);
                    } else if (accountType3 == 2) {
                        customer.getCustomerSavingsAccount().withdraw(amount2);
                    } else {
                        System.out.println("Invalid account type");
                    }
                    break;

                case 4:
                    System.out.println("Please select the type of account you want to transfer money from: ");
                    System.out.println("1. Checking Account");
                    System.out.println("2. Savings Account");
                    int accountType4 = InputUtil.getIntInput();
                    System.out.println("Please select the type of account you want to transfer money to: ");
                    System.out.println("1. Checking Account");
                    System.out.println("2. Savings Account");
                    int accountType5 = InputUtil.getIntInput();
                    if (accountType4 == 1 && accountType5 == 2) {
                        customer.getCustomerCheckingAccount().transferAmount(customer.getCustomerSavingsAccount());
                    } else if (accountType4 == 2 && accountType5 == 1) {
                        customer.getCustomerSavingsAccount().transferAmount(customer.getCustomerCheckingAccount());
                    } else {
                        System.out.println("Invalid account type");
                    }
                    break;

                case 5:
                    System.out.println("Please select the type of account you want to view: ");
                    System.out.println("1. Checking Account");
                    System.out.println("2. Savings Account");
                    int accountType6 = InputUtil.getIntInput();
                    if (accountType6 == 1) {
                        customer.getCustomerCheckingAccount().printStatement(customer);
                    } else if (accountType6 == 2) {
                        customer.getCustomerSavingsAccount().printStatement(customer);
                    } else {
                        System.out.println("Invalid account type");
                    }
                    break;

                case 6:
                    // display deductionRecord
                    customer.getCustomerSavingsAccount().printDeductionRecord();

                    customer.getCustomerCheckingAccount().printDeductionRecord();
                    break;

                case 7:
                    System.out.println("1 for checking account");
                    System.out.println("2 for savings account");
                    int accountType7 = InputUtil.getIntInput();
                    customer.openNewAccount(accountType7);
                    break;
                // close account
                case 8:
                    customer.closeAccount();
                    break;
                case 9:
                    System.out.println("Thank you for using the Account Management System");
                    break;
            }
            System.out.println("Please select an option from the menu below: ");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Transfer money");
            System.out.println("5. View account details");
            System.out.println("6. Display deductionRecords");
            System.out.println("7. Exit");
            option = InputUtil.getIntInput();

        } while (option != 9);
    }

}
