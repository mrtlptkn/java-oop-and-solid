package com.mrtlptkn.javaoopandsolid.banking.bestpractice;

// Birikim Hesabı (Mevduat Faizli Hesap)
public class SavingsAccount extends  Account implements ICredible,IDebitable{
    @Override
    public void credit(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Çekilecek miktar negatif olamaz.");
        }

        if(balance - amount < 0){
            throw new IllegalArgumentException("Yetersiz bakiye.");
        }

        balance-=amount;
    }


    @Override
    public void debit(double amount) {
        if(amount <= 0){
            throw  new IllegalArgumentException("Yatırılacak miktar negatif olamaz.");
        }
        balance+=amount;
    }

    private final float dailyInterestRate; // günlük faiz oranı

    public SavingsAccount(double initialBalance, String currency,float dailyInterestRate) {
        super(initialBalance, currency);
        this.dailyInterestRate = dailyInterestRate;
    }

    public float getDailyInterestRate(){
        return dailyInterestRate;
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * dailyInterestRate * 0.0005; // %0.05 faiz
        balance+=interest;
        System.out.println("Vadeli hesabınıza " + interest + " faiz eklendi. Yeni bakiye: " + getBalance());
    }
}
