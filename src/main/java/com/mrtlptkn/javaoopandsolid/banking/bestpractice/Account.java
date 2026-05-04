package com.mrtlptkn.javaoopandsolid.banking.bestpractice;

// SavingsAccount -> Mevduat Hesap
// CheckingsAccount -> Mevduatsız Hesap


import java.util.UUID;

public abstract class Account {

    private final String accountNumber; // hesap numarası
    private double balance; // bakiye
    private final String currency;  // para birimi

    // initialBalance -> hesap açılışında başlangıç bakiyesi
    public Account(double initialBalance, String currency) {
        this.accountNumber = UUID.randomUUID().toString(); // benzersiz bir hesap numarası oluştur
        this.balance = initialBalance;
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void  deposit(double amount){
        if(amount <= 0){
            throw  new IllegalArgumentException("Yatırılacak miktar negatif olamaz.");
        }
        balance+=amount;
    }

    public void withdraw(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Çekilecek miktar negatif olamaz.");
        }

        if(balance - amount < 0){
            throw new IllegalArgumentException("Yetersiz bakiye.");
        }

        balance-=amount;
    }

    abstract public void calculateInterest(); // faiz hesaplama metodu, her hesap türü için farklı olabilir -> Mevduatsız hesap eğer 100000 üzerinde ise gecelik %0.02 faiz verir, Mevduat hesap ise gecelik %0.05 faiz verir gibi



}
