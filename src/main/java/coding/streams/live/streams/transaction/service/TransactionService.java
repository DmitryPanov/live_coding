package coding.streams.live.streams.transaction.service;

public class TransactionService {
    enum Type {PAYMENT, REFUND}

    static class TransactionData {
        final Type type;
        final String currency;
        final Long amount;

        TransactionData(Type type,
                        String currency,
                        Long amount) {
            this.type = type;
            this.currency = currency;
            this.amount = amount;
        }

        String getCurrency() {
            return currency;
        }

        Long getAmount() {
            return amount;
        }

        Type getType() {
            return type;
        }
    }
}

