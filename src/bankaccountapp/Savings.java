package bankaccountapp;

public class Savings extends  Account {
    //Перечислить свойства, специфичные для Сберегательного счета
    private int safeDepositBoxID;
    private int getSafeDepositBoxKey;

    //Конструктор для инициализации настроек для сберегательных свойств
    public Savings (String name,String sSN, double initDeposit) {
        super(name,sSN,initDeposit);
        accountNumber = "1" + accountNumber;
        setSafeDepositBox();

    }

    @Override
    public void setRate() {
        rate = getBaseRate() - .25;
    }

    private void setSafeDepositBox () {
        safeDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        getSafeDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }



    //Перечислить любые методы, специфичные для сбережений
    public void showInfo () {
        System.out.println("ACCOUNT TYPE: Savings");
        super.showInfo();
        System.out.println(
                "Your Savings Account Features" +
                        "\n Safety Deposit Box ID: " + safeDepositBoxID +
                        "\n Safety Deposit Box Key: " + getSafeDepositBoxKey
        );
    }
}
