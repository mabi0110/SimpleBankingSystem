package SimpleBankingSystemStage2;

import java.util.Scanner;

public class CardAnatomy {
    private static final int CREATE_ACCOUNT = 1;
    private static final int LOG_IN = 2;
    private static final int EXIT = 0;
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        int userInput;
        do {
            printMenu();
            System.out.print(">");
            userInput = Integer.parseInt(readNumberFromUser());
            switch (userInput) {
                case CREATE_ACCOUNT -> createAccount();
                case LOG_IN -> logIntoAccount();
            }
        } while (userInput != EXIT);
        System.out.println("\nBye!");
    }

    private static void logIntoAccount() {
        System.out.println("\nEnter your card number:");
        System.out.print(">");
        long cardNumber = Long.parseLong(readNumberFromUser());
        System.out.println("Enter your pin:");
        System.out.print(">");
        String pin = readNumberFromUser();
        bank.findAccount(cardNumber, pin).ifPresentOrElse (
                Account::logIn,
                () -> System.out.println("\nWrong card number or PIN!"));
        System.out.println();
    }

    private static void createAccount() {
        Account account = new Account();
        bank.addAccount(account);
        System.out.println("Your card number:");
        long cardNumber = account.getCard().getCardNumber();
        System.out.println(cardNumber);
        System.out.println("Your card PIN:");
        String pin = account.getCard().getPin();
        System.out.println(pin);
        System.out.println();
    }

    private static void printMenu() {
        System.out.println(CREATE_ACCOUNT + ". Create an account\n" +
                LOG_IN + ". Log into account\n" +
                EXIT + ". Exit");
    }

    private static String readNumberFromUser() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
