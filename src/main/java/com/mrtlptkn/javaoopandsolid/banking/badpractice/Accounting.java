package com.mrtlptkn.javaoopandsolid.banking.badpractice;

public class Accounting {

    private double balance; // bakiye
    private String currency;  // para birimi
    private String accountType; // hesap türü (mevduat veya vadesiz)
    private float interestRate; // faiz oranı (sadece mevduat hesapları için geçerli)
    private String accountNumber; // hesap numarası

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double calculateInterest() {
        if (this.accountType.equals("SavingsAccount")) {
            double interest = this.balance * this.interestRate * 0.0005; // %0.05 faiz
            this.balance += interest; // faizi hesaba ekle
            System.out.println("Vadeli hesabınıza " + interest + " faiz eklendi. Yeni bakiye: " + this.balance);
            return interest;
        } else if (this.accountType.equals("CheckingsAccount")) {
            double interest = this.balance * 0.0002;
            System.out.println("Vadesiz hesabınıza " + interest + " gecelik faiz eklendi. Yeni bakiye: " + this.balance);
            return interest;
        }
        else {
            throw new IllegalArgumentException("Geçersiz hesap türü.");
        }
    }
}
