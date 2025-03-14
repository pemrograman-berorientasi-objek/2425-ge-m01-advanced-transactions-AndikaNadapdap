package fintech.model;

/**
 * @author 12S23013 - Andika Nadapdap
 * @author 12S23033 - Oloan Nainggolan
 */

 public class Account {
     private String id;
     private String owner;
     private String name;
     private double balance;
 
     public Account(String id, String owner, String name, double balance) {
         this.id = id;
         this.owner = owner;
         this.name = name;
         this.balance = balance;
     }
 
     public String getId() {
         return id;
     }
 
     public String getOwner() {
         return owner;
     }
 
     public String getName() {
         return name;
     }
 
     public double getBalance() {
         return balance;
     }
 
     public void setBalance(double balance) {
         this.balance = balance;
     }
 
     public void applyTransaction(Transaction transaction) {
         this.balance += transaction.getAmount();
     }
 
     @Override
     public String toString() {
         return "Account{" +
                 "id='" + id + '\'' +
                 ", owner='" + owner + '\'' +
                 ", name='" + name + '\'' +
                 ", balance=" + balance +
                 '}';
     }
 }