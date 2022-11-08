package SimpleBankingSystemStage2;

public class Card {
    private final Long cardNumber;
    private final String pin;
    private static final int LOWER_RANGE = 0;
    private static final int UPPER_RANGE = 9;

    public Long getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    Card(String accountIdentifier) {
        this.cardNumber = Long.parseLong(accountIdentifier);
        System.out.println("\nYour card has been created");
        this.pin = generatePin();
    }

    private String generatePin() {
        StringBuilder pin = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int digit = LOWER_RANGE + (int) (Math.random() * ((UPPER_RANGE - LOWER_RANGE) + 1));
            pin.append(digit);
        }
        return pin.toString();
    }

}
