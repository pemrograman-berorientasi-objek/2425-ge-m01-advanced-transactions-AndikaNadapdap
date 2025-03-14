package fintech.driver;

import fintech.model.Transaction;
import fintech.model.Account;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 12S23013 Andika Nadapdap
 * @author 12S23033 Oloan Nainggolan
 */
public class Driver1 {

    public static void main(String[] _args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();
        
        while (scan.hasNextLine()) {
            String commandLine = scan.nextLine();
            String[] parts = commandLine.split("#");
            String command = parts[0];

            switch (command) {
                case "create-account":
                    String owner = parts[1];
                    String accountName = parts[2];
                    Account account = new Account(command, owner, accountName, 0.0);
                    accounts.put(accountName, account);
                    System.out.println(account.toString());
                    break;

                case "create-transaction":
                    accountName = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String postedAt = parts[3];
                    String note = parts[4];
                    account = accounts.get(accountName);
                    if (account != null) {
                        Transaction transaction = new Transaction(accountName, amount, note, postedAt, account.getBalance());
                        account.applyTransaction(transaction);
                        System.out.println(transaction.toString());
                    } else {
                        System.out.println( accountName);
                    }
                    break;

                case "show-account":
                    accountName = parts[1];
                    account = accounts.get(accountName);
                    if (account != null) {
                        System.out.println(account.toString());
                    } else {
                        System.out.println(accountName);
                    }
                    break;

                default:
                    System.out.println(command);
                    break;
            }
        }
    }
}
