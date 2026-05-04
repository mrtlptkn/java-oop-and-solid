package com.mrtlptkn.javaoopandsolid.controller;


import com.mrtlptkn.javaoopandsolid.banking.bestpractice.Account;
import com.mrtlptkn.javaoopandsolid.banking.bestpractice.CheckingsAccount;
import com.mrtlptkn.javaoopandsolid.banking.bestpractice.InvestementAccount;
import com.mrtlptkn.javaoopandsolid.banking.bestpractice.SavingsAccount;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account") // endpoint
public class AccountController {

    @PostMapping("savingsInterest") // endpoint -> /api/accounting/calculate-interest
    public String calculateSavingsAccountInterest() {
        // burada vadeli hesap faizini hesaplama işlemi yapılır
        // örneğin, SavingsAccount sınıfından bir nesne oluşturup calculateInterest metodunu çağırabiliriz

        // Senaryolar
        // 1. Yanlışlıkla Account Number değiştirsek
        // 2. Currency unutulmuş
        // 3. balance müdehale etmeye çalışalım
        // 4. -500 lira ekleme yapabiliyor muyuz (Hayır)
        // 5. Negatif bir değer ekleme veya çıkarmaya izin varmı
        // 6. Bakiyemizi aşan bir tutarı çekebiliyor muyuz?



        // Not: Burada sol tarafta Account yazmamızın sebebi, ben sadece account ait ortak özellikleri kullanarak bir işlem yapacağım demektir.

        SavingsAccount acc = new SavingsAccount(1000, "USD", 0.05f);
        // balance değiştirmek için yukarıdaki 2 method kullanmaız gerekir. Bad practice bu düşünülmedi.
        // acc.getDailyInterestRate(); // günlük faiz oranını alma



        // Başarılı olduk.
        // acc.deposit(-750); // Nagtif değer set edilemez
        // acc.withdraw(50000); // bakiye yetersiz durum.


        InvestementAccount i = new InvestementAccount(5000, "USD");



        acc.calculateInterest();


        return "Vadeli hesap faizi hesaplandı. -> Güncel Bakiye " + acc.getBalance() + " Account Number : " + acc.getAccountNumber();
    }

    @PostMapping("checkingsInterest") // endpoint -> /api/accounting/calculate-interest
    public String calculateCheckingsAccountInterest() {

        Account acc2 = new CheckingsAccount(150000, "USD");
        acc2.calculateInterest();

        // burada vadesiz hesap faizini hesaplama işlemi yapılır
        // örneğin, CheckingsAccount sınıfından bir nesne oluşturup calculateInterest metodunu çağırabiliriz
        return "Vadesiz hesap faizi hesaplandı. -> Güncel Bakiye " + acc2.getBalance() + " Account Number : " + acc2.getAccountNumber();
    }


    @PostMapping("abstractionTest")
    public String abstractionTest() {
        // Asbtraction -> Soyutlama. yani bir işin özetinin öncesinde oluşturulması daha sonrasında detayının düşünülmesi olaydı.

        // Genel Geçer şeyler  -> Tüm alt nesneleri ilgileren konuların genel özellikleri abstractionda tanımlanır.

        // Müşterilen 2 çeşit hesabı vardır. Mevduat ve Mevduatsız
        // Bu hesaplarda belirli faziler işletir.
        // Hesap numarası ilk oluşturulduğu ana hesap kapatılana kadar değişmez
        // hesabının para birimi açılışta belirlenir değiştirilemez
        // Hesaba ilk bakiye yüklemesi hesap açılışında olabilir.

        // Mevduat Hesabını gecelik 0.0005 oranında faiz işletir ve günlük olarak belirli dönmelerde belirlenen
        // oranlara göre faiz işletir.
        // Vadesiz (Mevduatsız) hesap sadece geceler 0.0002 oranında faiz işletir ve günlük faiz yoktur.
        // Concrete Class -> Somut Sınıflar newlenmesi gerekir.


        // Account acc = new Account(); -> Abstract sınıflar ile Concrete Class ayrımını iyi yapmışız.

        //  abstract public void calculateInterest(); -> bu method faizi nasıl hesaplayacağımıza dair hiç bir fikrimiz yok. Fiktirimin olmuşması için concrete somut bir sınafa geçmemiz lazım.
        // @Override -> Ben bu işin akışın şuan düşünebiliyorum. O yüzden ovveride ediyorum yani -> kodun içindeki bloğu yazabiliyorum.

        CheckingsAccount checking = new CheckingsAccount(150000, "USD");
        // günlük faiz oranı yok
        SavingsAccount saving = new SavingsAccount(1000, "USD", 0.05f);
        // günlük faiz oranı var
        saving.getDailyInterestRate();






        return "Abstraction Test";

    }

}
