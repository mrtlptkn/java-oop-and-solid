package com.mrtlptkn.javaoopandsolid.banking.bestpractice;

public class CheckingsAccount extends  Account {

    public CheckingsAccount(double initialBalance, String currency) {
        super(initialBalance, currency);
    }

    @Override
    public void calculateInterest() {
            if(getBalance() > 100000){
                double interest = getBalance() * 0.0002; // %0.02 faiz
                deposit(interest); // faizi hesaba ekle
                System.out.println("Vadesiz hesabınıza " + interest + " gecelik faiz eklendi. Yeni bakiye: " + getBalance());
            }
    }

}
