package bankaccountapp;

public interface IBaseRate {
    //Напишите метод, который возвращает базовую ставку
    default double getBaseRate () {
        return 2.5;
    }


}
