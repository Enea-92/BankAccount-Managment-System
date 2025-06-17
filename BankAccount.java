public class BankAccount {
    private String name;
    private String surname;
    private String accountNumber;
    private double balance;
    private int cardNumber;
    private String cardHolder;
    private String cardType;
    private String cardExpiryDate;
    private String cardCVV;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public int getCardNumber() { return cardNumber; }
    public void setCardNumber(int cardNumber) { this.cardNumber = cardNumber; }

    public String getCardHolder() { return cardHolder; }
    public void setCardHolder(String cardHolder) { this.cardHolder = cardHolder; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getCardExpiryDate() { return cardExpiryDate; }
    public void setCardExpiryDate(String cardExpiryDate) { this.cardExpiryDate = cardExpiryDate; }

    public String getCardCVV() { return cardCVV; }
    public void setCardCVV(String cardCVV) { this.cardCVV = cardCVV; }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    // Display account details
    public void displayDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name + " " + surname);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Card Type: " + cardType);
        System.out.println("Expiry Date: " + cardExpiryDate);
        System.out.println("CVV: " + cardCVV);
        System.out.println("Balance: $" + balance);
    }
}
