package com.mrtlptkn.javaoopandsolid.banking.bestpractice;

// Not: Birşeyin kalıtım olduğunu anlmak için is a ilişkisi vardır
// CheckingsAccount is a Account -> CheckingsAccount bir Account türüdür, bu yüzden kalıtım kullanmak mantıklıdır.
// Interfacelerde has a ilişkisi vardır -> ata sınıfta olmayabilir ama bu sınıfta bu yeteneğin olması gerekir.
// Vadesiz Hesap olsun (Para Transferi, EFT, Havale gibi işlemler yapabilir, yatırım yapabilir, faiz kazanabilir gibi özellikleri olabilir)
public class CheckingsAccount extends  Account implements IDebitable, ICredible {

    public CheckingsAccount(double initialBalance, String currency) {
        super(initialBalance, currency);
    }



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

    // bir fazi oranı hesaplaması farklı account nesnelerinde farklı özlelikleri gösterme işlemine burada başlar.

    @Override
    public void calculateInterest() {
            if(getBalance() > 100000){
                double interest = getBalance() * 0.0002; // %0.02 faiz
                balance-=interest;
                System.out.println("Vadesiz hesabınıza " + interest + " gecelik faiz eklendi. Yeni bakiye: " + getBalance());
            }
    }

}
