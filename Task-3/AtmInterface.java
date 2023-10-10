import java.util.Scanner;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  Class name :         ATMInterface
//  Description :       This program Display a menu with options to check balance, deposit, and withdraw funds.
//                      Perform transactions based on user input.Validate user input to ensure accurate transactions.                     
//                      Display appropriate messages for successful and failed transactions. ANSI escape codes are
//                      used for text formatting to enhance the user interface.                     
//  Author :            Gore Bharati 
//  Date :              03/10/2023
//  Update Date :       11/10/2023
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\u001B[32m Enter initial account balance: \u001B[0m");
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("\u001B[32mSelect an option: \u001B[0m");
            int choice = scanner.nextInt();

            atm.performTransaction(choice, scanner);
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\u001B[36mDeposit of $" + amount + " successful. Current balance: $" + balance + "\u001B[0m"); // Cyan color
        } else {
            System.out.println("\u001B[31mInvalid deposit amount.\u001B[0m"); // Red color
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\u001B[36mWithdrawal of $" + amount + " successful. Current balance: $" + balance + "\u001B[0m"); // Cyan color
        } else {
            System.out.println("\u001B[31mInvalid withdrawal amount or insufficient balance.\u001B[0m"); // Red color
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("\u001B[36m--------------------------\u001B[0m");
        System.out.println("\u001B[36m ----ATM Menu:----\u001B[0m"); // Cyan color
        System.out.println("\u001B[36m 1. Check Balance \u001B[0m");
        System.out.println("\u001B[36m 2. Deposit \u001B[0m");
        System.out.println(" \u001B[36m3. Withdraw\u001B[0m");
        System.out.println(" \u001B[36m4. Exit\u001B[0m");
        System.out.println("\u001B[36m------------------------\u001B[0m"); // Reset color
    }

    public void performTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("\u001B[35m Current balance: \u001B[0m" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("\u001B[35m Enter deposit amount: \u001B[0m");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                break;
            case 3:
                System.out.print("\u001B[35m Enter withdrawal amount: \u001B[0m");
                 double withdrawalAmount = scanner.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
                break;
            case 4:
                System.out.println("\u001B[32mExiting ATM. Thank you!\u001B[0m"); // Green color
                scanner.close();
                System.exit(0);
            default:
                System.out.println("\u001B[31mInvalid choice. Please select a valid option.\u001B[0m"); // Red color
        }
    }
}
