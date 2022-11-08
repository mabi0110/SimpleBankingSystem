package SimpleBankingSystemStage2;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {
    private static final int BALANCE = 1;
    private static final int LOG_OUT = 2;
    private static final int EXIT = 0;
    private String accountIdentifier;
    private static final int LOWER_RANGE = 0;
    private static final int UPPER_RANGE = 9;
    private final Card card;
    private int balance = 0;

    public Card getCard() {
        return card;
    }

    Account() {
        String tempAccountIdentifier = Bank.BIN + "" + generateAccountIdentifier();
        Long lastDigit = luhnAlgorithmCheck(tempAccountIdentifier);
        this.accountIdentifier = tempAccountIdentifier + "" + lastDigit;
        this.card = new Card(accountIdentifier);
    }

    private Long luhnAlgorithmCheck(String cardNumber) {
        String[] cardNumberArray = getCardNumberArray(cardNumber);
        ArrayList<Long> multiplied = getMultipliedCardNumber(cardNumberArray);
        ArrayList<Long> subtract9 = getCardNumberSubtract9(multiplied);
        int addAllNumber = addAllNumbers(subtract9);
        Long lastDigit = (long) checkSum(addAllNumber);
        return lastDigit;
    }

    private int checkSum(int addAllNumber) {
        int i = addAllNumber % 10;
        return 10 - i;
    }

    private int addAllNumbers(ArrayList<Long> subtract9) {
        int sum = 0;
        for (Long sub : subtract9) {
            sum += sub;
        }
        return sum;
    }

    private ArrayList<Long> getCardNumberSubtract9(ArrayList<Long> multiplied) {
        ArrayList<Long> subtract9 = new ArrayList<>();

        for (Long multi : multiplied) {
            if (multi > 9) {
                subtract9.add(multi - 9);
            } else {
                subtract9.add(multi);
            }
        }
        return subtract9;
    }

    private ArrayList<Long> getMultipliedCardNumber(String[] cardNumberWithoutLastDigit) {
        ArrayList<Long> multiplied = new ArrayList<>();
        for (int i = 0; i < cardNumberWithoutLastDigit.length; i++) {
            long l;
            if (i % 2 == 0) {
                l = Long.parseLong(cardNumberWithoutLastDigit[i]) * 2;
            } else {
                l = Long.parseLong(cardNumberWithoutLastDigit[i]);
            }
            multiplied.add(l);
        }
        return multiplied;
    }

    private String[] getCardNumberArray(String cardNumber) {
        return cardNumber.split("");
    }

    private String generateAccountIdentifier() {
        StringBuilder accountIdentifier = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            long digit = LOWER_RANGE + (long) (Math.random() * ((UPPER_RANGE - LOWER_RANGE) + 1));
            accountIdentifier.append(digit);
        }
        return (accountIdentifier.toString());
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
