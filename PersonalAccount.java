import java.util.ArrayList;
import java.util.List;

/**
 * Класс, представляющий личный банковский счет.
 */
public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Amount> transactions;

    /**
     * Конструктор для создания объекта PersonalAccount.
     *
     * @param accountNumber уникальный номер счета
     * @param accountHolder имя владельца счета
     */
    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Метод для внесения денег на счет.
     *
     * @param amount сумма для внесения
     */
    public void deposit(double amount) {
        Amount transaction = new Amount(amount, TransactionType.DEPOSIT);
        transactions.add(transaction);
        balance += amount;
    }

    /**
     * Метод для снятия денег со счета.
     *
     * @param amount сумма для снятия
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Недостаточно средств для снятия.");
            return;
        }
        Amount transaction = new Amount(amount, TransactionType.WITHDRAWAL);
        transactions.add(transaction);
        balance -= amount;
    }

    /**
     * Метод для вывода истории транзакций.
     */
    public void printTransactionHistory() {
        for (Amount transaction : transactions) {
            System.out.println(transaction.getTransactionType() + ": $" + transaction.getAmount());
        }
    }

    /**
     * Получить текущий баланс счета.
     *
     * @return текущий баланс
     */
    public double getBalance() {
        return balance;
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {
        // Создаем экземпляр PersonalAccount
        PersonalAccount account = new PersonalAccount(12345, "Джон Доу");

        // Тест 1: Внесение денег
        System.out.println("Тест 1: Внесение 1000 долларов.");
        account.deposit(1000);
        System.out.println("Текущий баланс: $" + account.getBalance()); // Ожидаем 1000

        // Тест 2: Снятие денег
        System.out.println("\nТест 2: Снятие 200 долларов.");
        account.withdraw(200);
        System.out.println("Текущий баланс: $" + account.getBalance()); // Ожидаем 800

        // Тест 3: Попытка снять больше, чем есть на счете
        System.out.println("\nТест 3: Попытка снять 1000 долларов.");
        account.withdraw(1000); // Это должно показать сообщение об ошибке

        // Тест 4: Вывод истории транзакций
        System.out.println("\nИстория транзакций:");
        account.printTransactionHistory(); // Должны увидеть историю транзакций

        // Тест 5: Проверка окончательного баланса
        System.out.println("\nФинальный баланс: $" + account.getBalance()); // Ожидаем 800
    }
}
