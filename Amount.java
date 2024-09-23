/**
 * Класс, представляющий сумму транзакции.
 */
public class Amount {
    private double amount;
    private TransactionType transactionType;

    /**
     * Конструктор для создания объекта Amount.
     *
     * @param amount сумма транзакции
     * @param transactionType тип транзакции (DEPOSIT или WITHDRAWAL)
     */
    public Amount(double amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    /**
     * Получить сумму транзакции.
     *
     * @return сумма транзакции
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Получить тип транзакции.
     *
     * @return тип транзакции
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }
}
