package com.mrtlptkn.javaoopandsolid.controller;


import com.mrtlptkn.javaoopandsolid.banking.badpractice.Accounting;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounting")
public class AccountingController {


    @PostMapping("savingsInterest") // endpoint -> /api/accounting/calculate-interest
    public String calculateSavingsAccountInterest() {
        // burada vadeli hesap faizini hesaplama işlemi yapılır
        // örneğin, SavingsAccount sınıfından bir nesne oluşturup calculateInterest metodunu çağırabiliriz

        // yazılımcı account Number set etmeyi unuttu ama kod çalıştı.
        // currency unutulmuş

        Accounting accounting = new Accounting();
        accounting.setAccountNumber("123456789");
        accounting.setCurrency("USD");
        accounting.setBalance(1000);
        accounting.setAccountType("SavingsAccount");
        accounting.setInterestRate(0.05f);
        double result =  accounting.calculateInterest();


        return "Vadeli hesap faizi hesaplandı. Faiz Oranı " + result + " -> Güncel Bakiye " + accounting.getBalance() + " Account Number : " + accounting.getAccountNumber();
    }


    @PostMapping("checkingsInterest") // endpoint -> /api/accounting/calculate-interest
    public String calculateCheckingsAccountInterest() {
        // burada vadeli hesap faizini hesaplama işlemi yapılır
        // örneğin, SavingsAccount sınıfından bir nesne oluşturup calculateInterest metodunu çağırabiliriz

        Accounting accounting = new Accounting();
        accounting.setAccountNumber("123456789");
        accounting.setBalance(1000);
        accounting.setBalance(-500); // balnace değiştirmemiz gerekir.
        accounting.setAccountType("CheckingsAccount");
        accounting.setCurrency("USD");
        accounting.setInterestRate(0.05f);
        double result =  accounting.calculateInterest();


        accounting.setAccountNumber("5467891015"); // hesap numarası değiştirilmiş, bu da büyük bir sorun çünkü hesap numarası benzersiz olmalı ve değiştirilememeli, bu durum veri tutarsızlığına yol açar. immutable olmadı.


        return "Vadesiz hesap faizi hesaplandı. Faiz Oranı " + result + " -> Güncel Bakiye " + accounting.getBalance() + " Account Number : " + accounting.getAccountNumber();
    }

    @PostMapping("accountingTest")
    public  String accountingTest() {

        Accounting savingAccounts = new Accounting();
        savingAccounts.setAccountNumber("123456789");
        savingAccounts.setBalance(1000);
        savingAccounts.setAccountType("SavingsAccount");
        savingAccounts.setCurrency("USD");
        // saving Accounts üzerinde günlük faiz uygulanabilir mi ? evet
        savingAccounts.setInterestRate(0.05f);

        Accounting checkingAccounts = new Accounting();
        checkingAccounts.setAccountNumber("123456789");
        checkingAccounts.setBalance(1000);
        checkingAccounts.setAccountType("CheckingsAccount");
        checkingAccounts.setCurrency("USD");
        // checking Accounts üzerinde günlük faiz uygulanabilir mi ? hayır
        checkingAccounts.setInterestRate(0.05f);

        // InvestmentAccount -> (Yatırım) (risk seviyesi gibi farklı özellikler olabilir)


        // Kural: Ortak zorunlu alanları base bir nesne üzerinde tanımlamamız gerekir.
        // Inheritance -> ortak özelliklerin doğru bir şekilde aktarılması




        return  "";
    }



}
