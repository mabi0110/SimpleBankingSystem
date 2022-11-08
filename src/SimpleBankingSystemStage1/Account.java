package SimpleBankingSystemStage1;

import java.util.Scanner;

public class Account {

    private static final int BALANCE = 1;
    private static final int LOG_OUT = 2;
    private static final int EXIT = 0;
    private Card card;
    private String accountIdentifier;
    private static final int LOWER_RANGE = 0;
    private static final int UPPER_RANGE = 9;
    
    private int balance = 0;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    Account(){
        this.accountIdentifier = generateAccountIdentifier();
        this.card = new Card(accountIdentifier);
    }

    private String generateAccountIdentifier()  {
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long digit = LOWER_RANGE + (long) (Math.random() * ((UPPER_RANGE - LOWER_RANGE) + 1));
            pin.append(digit);
        }
        return (pin.toString());
    }

    public void logIn() {
        System.out.println("\nYou have successfully logged in!");
        System.out.println();
        int userInput;
        do {
            printMenu();
            System.out.print(">");
            userInput = Integer.parseInt(readNumberFromUser());
            switch (userInput) {
                case BALANCE -> showBalance();
                case LOG_OUT -> logOutMessage();
                case EXIT -> System.exit(0);
            }
        } while (userInput != LOG_OUT);
        
    }

    private void logOutMessage() {
        System.out.println("\nYou have successfully logged out!");
    }

    private void showBalance() {
        System.out.println("\nBalance: " + balance);
        System.out.println();
    }


    private static void printMenu() {
        System.out.println(BALANCE + ". Balance\n" +
                LOG_OUT + ". Log out\n" +
                EXIT + ". Exit");
    }

    private static String readNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
}
