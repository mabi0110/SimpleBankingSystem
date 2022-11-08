package SimpleBankingSystemStage1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Bank {

    private final Map<Long, Account> accounts = new HashMap<>();

    public Map<Long, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.put(account.getCard().getCardNumber(), account);
    }

    public Optional<Account> findAccount(long cardNumber, String pin) {
        if (accounts.containsKey(cardNumber)){
            Account account = accounts.get(cardNumber);
            if (accounts.get(cardNumber).getCard().getPin().equals(pin)) {
                return Optional.of(account);
            }
        }
        return Optional.empty();
    }

}
