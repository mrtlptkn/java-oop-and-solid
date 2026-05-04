package com.mrtlptkn.javaoopandsolid.banking.bestpractice;



// ? Biz yatırım hesabınadan para çekemeyiz anca yatırımımızı bozabilir.
// Account Base sınıfana uyumsuzluk söz konusu  ?
// Ne yapacağız ?  -> Yıllar sonra bir geliştirme biz piyango bileti vurdu.

// Yatırım Hesabı (Altın, Döviz, Hisse Senedi vb. yatırımlar için kullanılabilir)
public class InvestementAccount extends Account implements Investable {
    public InvestementAccount(double initialBalance, String currency) {
        super(initialBalance, currency);
    }

    @Override
    public void calculateInterest() {
        // Yatırım hesapları için faiz hesaplama mantığı burada olabilir, örneğin belirli bir getiri oranına göre faiz ekleyebiliriz.
        // Bu sadece bir örnek, gerçek dünyada yatırım hesapları genellikle daha karmaşıktır ve farklı türde yatırımlar içerebilir.
        double interest = getBalance() * 0.0003; // %0.03 faiz
        balance-=interest;
        System.out.println("Yatırım hesabınıza " + interest + " faiz eklendi. Yeni bakiye: " + getBalance());
    }

    @Override
    public void invest() {
        // Yatırım yapma mantığı burada olabilir, örneğin belirli bir miktarı farklı yatırım araçlarına yönlendirebiliriz.
        // Bu sadece bir örnek, gerçek dünyada yatırım işlemleri genellikle daha karmaşıktır ve farklı türde yatırımlar içerebilir.
        System.out.println("Yatırım işlemi gerçekleştirildi.");
    }


    // Investment için Dummy Code
    // yama atmak TODO
//    @Override
//    public void withdraw(double amount) {
//        // super.withdraw(amount); // mevcut çekme işlemini gerçekleştirelim
//       throw new UnsupportedOperationException("Yatırım hesabından para çekilemez, ancak yatırım bozabilirsiniz.");
//    }
}
