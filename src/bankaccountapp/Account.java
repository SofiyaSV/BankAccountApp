package bankaccountapp;

public abstract class Account implements IBaseRate  {
    //Список общих свойств для сохранения и проверки учетных записей
    private String name;
    private String sSN;
    private double balance;
    private static int index = 10000;

    protected String accountNumber;
    protected double rate;



    //Конструктор для установки базовых свойств и инициализации учетной записи
    public Account (String name,String sSN, double initDeposit) {
        index++;
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit ;
        //Номер счета
        this.accountNumber = setAccountNumber();
       // System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
        setRate();
    }

    public abstract void setRate ();

    private String setAccountNumber () {
        String lastTWoOfSSN = sSN.substring(sSN.length() - 2 , sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTWoOfSSN + uniqueID + randomNumber;
    }

    public void compound () {
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest:$ " + accruedInterest);
        printBalance();
    }

    //Перечислить распространенные методы (Транзакции)
    public void deposit (double amount) {
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }
    public void withdraw (double amount) {
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }
    public void transfer (String toWhere, double amount ) {
      balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance () {
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo () {
        System.out.println(
                "NAME: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRATE: " + rate + "%"
        );
    }

}
