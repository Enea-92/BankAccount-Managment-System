import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static int lastCardNumber = 1000;
    static Random random = new Random();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> checkBalance();
                case 5 -> viewAccountDetails();
                case 6 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 6);
    }

    public static void createAccount() {
        BankAccount account = new BankAccount();

        System.out.print("Enter first name: ");
        account.setName(scanner.next());

        System.out.print("Enter surname: ");
        account.setSurname(scanner.next());

        // Generate random 10-digit account number
        String accountNumber = generateAccountNumber();
        account.setAccountNumber(accountNumber);
        System.out.println("Your account number is: " + accountNumber);

        // Auto-increment card number
        lastCardNumber++;
        account.setCardNumber(lastCardNumber);
        System.out.println("Your card number is: " + lastCardNumber);

        scanner.nextLine(); // consume newline leftover

        System.out.print("Enter card holder name: ");
        account.setCardHolder(scanner.nextLine());

        System.out.print("Enter card type (e.g., VISA): ");
        account.setCardType(scanner.next());

        // Generate random expiry date
        String expiryDate = generateExpiryDate();
        account.setCardExpiryDate(expiryDate);
        System.out.println("Your card expiry date is: " + expiryDate);

        // Generate random CVV
        String cvv = generateCVV();
        account.setCardCVV(cvv);
        System.out.println("Your CVV is: " + cvv);

        System.out.print("Enter initial deposit: ");
        account.setBalance(scanner.nextDouble());

        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    public static BankAccount findAccount(String accNo, int cardNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNo) && acc.getCardNumber() == cardNo) {
                return acc;
            }
        }
        return null;
    }

    public static void deposit() {
        System.out.print("Enter account number: ");
        String acc = scanner.next();
        System.out.print("Enter card number: ");
        int card = scanner.nextInt();

        BankAccount account = findAccount(acc, card);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amt = scanner.nextDouble();
            account.deposit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void withdraw() {
        System.out.print("Enter account number: ");
        String acc = scanner.next();
        System.out.print("Enter card number: ");
        int card = scanner.nextInt();

        BankAccount account = findAccount(acc, card);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amt = scanner.nextDouble();
            account.withdraw(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void checkBalance() {
        System.out.print("Enter account number: ");
        String acc = scanner.next();
        System.out.print("Enter card number: ");
        int card = scanner.nextInt();

        BankAccount account = findAccount(acc, card);
        if (account != null) {
            System.out.println("Current Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void viewAccountDetails() {
        System.out.print("Enter account number: ");
        String acc = scanner.next();
        System.out.print("Enter card number: ");
        int card = scanner.nextInt();

        BankAccount account = findAccount(acc, card);
        if (account != null) {
            account.displayDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    // Helper methods to generate random account number, expiry date, CVV

    public static String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateExpiryDate() {
        int month = random.nextInt(12) + 1;
        int currentYear = java.time.Year.now().getValue() % 100; // last 2 digits
        int year = currentYear + random.nextInt(6);
        return String.format("%02d/%02d", month, year);
    }

    public static String generateCVV() {
        int cvvNum = random.nextInt(1000);
        return String.format("%03d", cvvNum);
    }
}
