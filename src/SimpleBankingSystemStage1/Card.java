package SimpleBankingSystemStage1;

public class Card {

    private static final int MII = 4;   // Major Industry Identifier (MII)
    private static final int BIN = 400000;  // Bank Identification Number
    private long cardNumber;
    private String pin;
    private static final int LOWER_RANGE = 0;
    private static final int UPPER_RANGE = 9;


    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    Card(String accountIdentifier){
        this.cardNumber = Long.parseLong(BIN + "" + accountIdentifier);
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
