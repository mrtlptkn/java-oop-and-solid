package com.mrtlptkn.javaoopandsolid.banking.bestpractice;

public class SavingsAccount extends  Account{

    private final float dailyInterestRate; // günlük faiz oranı

    public SavingsAccount(double initialBalance, String currency,float dailyInterestRate) {
        super(initialBalance, currency);
        this.dailyInterestRate = dailyInterestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * dailyInterestRate * 0.0005; // %0.05 faiz
        deposit(interest); // faizi hesaba ekle
        System.out.println("Vadeli hesabınıza " + interest + " faiz eklendi. Yeni bakiye: " + getBalance());
    }
}
