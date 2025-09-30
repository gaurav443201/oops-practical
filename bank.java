import java.util.Scanner;

class Bank {
    private final int accNo = 12345678;
    private final int pin = 1234;
    private double balance = 10000.0;
    private Scanner scanner;

    public Bank() {
        scanner = new Scanner(System.in);
    }

    private boolean validateAccountNumber() {
        System.out.print("Enter Account Number: ");
        String input = scanner.nextLine();
        
        try {
            int enteredAccNo = Integer.parseInt(input);
            return enteredAccNo == accNo;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validatePin() {
        System.out.print("Enter PIN: ");
        String input = scanner.nextLine();
        
        try {
            int enteredPin = Integer.parseInt(input);
            return enteredPin == pin;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    private double getAmountInput(String operation) {
        while (true) {
            System.out.print("Enter amount to " + operation + ": ₹");
            String amtInput = scanner.nextLine();
            
            try {
                double amount = Double.parseDouble(amtInput);
                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                    continue;
                }
                return amount;
            } 
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void checkBalance() {
        System.out.println("\n=== Check Balance ===");
        if (validatePin()) {
            System.out.printf("Your current balance is: ₹%.2f%n", balance);
        } 
        else {
            System.out.println("Invalid PIN!");
        }
    }

    public void withdraw() {
        System.out.println("\n=== Withdraw Money ===");
        
        double amount = getAmountInput("withdraw");
        
        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }
        
        if (validatePin()) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully!%n", amount);
            System.out.printf("New balance: ₹%.2f%n", balance);
        } 
        else {
            System.out.println("Invalid PIN!");
        }
    }

    public void deposit() {
        System.out.println("\n=== Deposit Money ===");
        
        double amount = getAmountInput("deposit");
        
        if (validatePin()) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully!%n", amount);
            System.out.printf("New balance: ₹%.2f%n", balance);
        } 
        else {
            System.out.println("Invalid PIN!");
        }
    }

    public void showMenu() {
        System.out.println("WELCOME TO BANK SYSTEM");
        
        if (!validateAccountNumber()) {
            System.out.println("Invalid account number!");
            System.out.println("Bank session ended.");
            return;
        }
        
        System.out.println("\nLogin successful!");
        
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        deposit();
                        break;
                    case 4:
                        System.out.println("Thank you for banking with us!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter 1-4.");
                }
            } 
            catch (NumberFormatException e) {
                System.out.println("Please enter numbers only.");
            }
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.showMenu();
    }
}
