package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List <Account> accounts = new LinkedList<Account>();





        /*
        Checking chkacc1 = new Checking("Tom Wilson","35672358", 1500);
        Savings savacc1 = new Savings("Rich Lowe","37823976" ,2500);
        savacc1.showInfo();
        System.out.println("**********");
        chkacc1.showInfo();
          */
        //Прочитать файл CSV, затем создайте новые учетные записи на основе этих данных.
        String file = "C:\\Users\\USER\\Desktop\\original.csv";
        List <String []> newAccountHolder = utilities.CSV.read(file);
        for (String [] accountHolder : newAccountHolder) {
           // System.out.println("NEW ACCOUNT");
            String name = accountHolder[0];
            String sSN = accountHolder [1];
            String accountType = accountHolder[2];
            double initDeposit =Double.parseDouble(accountHolder [3]);
            //System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposit);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name,sSN, initDeposit));
            }
            else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name,sSN, initDeposit));
            }
            else{
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for (Account acc : accounts) {
            System.out.println("*****************");
            acc.showInfo();
        }






    }
}
