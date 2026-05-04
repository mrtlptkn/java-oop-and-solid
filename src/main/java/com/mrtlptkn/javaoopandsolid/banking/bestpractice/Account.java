package com.mrtlptkn.javaoopandsolid.banking.bestpractice;

// SavingsAccount -> Mevduat Hesap
// CheckingsAccount -> Mevduatsız Hesap


import java.util.UUID;

public abstract class Account {

    private final String accountNumber; // hesap numarası
    protected double balance; // bakiye
    // kaılıtım aldığımız sınıfın özelliğini değiştirmemiz lazım. bu sebeple sadece kalıtım alan sınıflra erişilebilir yapmalıyız.


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


    abstract public void calculateInterest(); // faiz hesaplama metodu, her hesap türü için farklı olabilir -> Mevduatsız hesap eğer 100000 üzerinde ise gecelik %0.02 faiz verir, Mevduat hesap ise gecelik %0.05 faiz verir gibi



}
