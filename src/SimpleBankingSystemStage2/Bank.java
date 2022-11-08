package SimpleBankingSystemStage2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Bank {

    private static final int MII = 4;   // Major Industry Identifier (MII)
    public static final int BIN = 400000;  // Bank Identification Number
    private final Map<Long, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getCard().getCardNumber(), account);
    }

    public Optional<Account> findAccount(Long cardNumber, String pin) {
        if (accounts.containsKey(cardNumber)) {
            Account account = accounts.get(cardNumber);
            if (accounts.get(cardNumber).getCard().getPin().equals(pin)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }

}
