package odev_1;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Kullanici {
    
 // Kullanıcı sınıfı, kullanıcı bilgilerini, satın alınan oyunları, arkadaşları ve oyunları puanlamayı yönetir.
 // Her bir kullanıcı için ad, soyad, kullanıcı adı, şifre, e-posta gibi bilgileri içerir.
 // Kullanıcının satın aldığı oyunlar ve arkadaşları birer liste ile tutulur.
    //kullanıcının bilgileri aşağıdadır.
    private String ad;
    private String soyad;
    private String kullaniciAdi;
    private String sifre;
    private String email;
    private ArrayList<Oyun> satinAlinanOyunlar;// Kullanıcının satın aldığı oyunların listesi
    private HashMap<Kullanici, Integer> arkadaslar;// Kullanıcının arkadaşları ve bu arkadaşlara ait puanlar

    public Kullanici(String ad, String soyad, String kullaniciAdi, String sifre, String email) {
        this.ad = ad;
        this.soyad = soyad;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.email = email;
        this.satinAlinanOyunlar = new ArrayList<>();
        this.arkadaslar = new HashMap<>();
    }

    public String adSoyad() {
        return ad + " " + soyad;
    }

    public void kullaniciBilgisi() {
        // Main classında kullanıcı bilgisi çağrılınca aşağıdaki işlemler gösterilir.
        //her bilgiyi bir bilgiler değişkenine atadım
        String bilgiler = "**Kullanıcı Bilgileri:**\n"
                + "Ad: " + ad + "\n"
                + "Soyad: " + soyad + "\n"
                + "Kullanıcı Adı: " + kullaniciAdi + "\n"
                + "E-posta: " + email;
        //atadğım bilgiler değişkenini ekrana gösterdim
        JOptionPane.showMessageDialog(null, bilgiler);
    
    
    }

    public void oyunSatınAl(Oyun oyun) {
        //satınAlınanOyunlara gelen oyun add ile eklenmiştir.
        satinAlinanOyunlar.add(oyun);
        //eklendikten sonra mesaj gösterilmiştir.
        JOptionPane.showMessageDialog(null, oyun.ad + " oyunu başarıyla satın alındı!");
    }

    public void arkadasEkle(Kullanici kullanici) {
        //arkadaşlara kullanıcı put ile eklenmiştir.Eklenen arkadaş kullanıcı ve arkadaş listesine eklenir
        arkadaslar.put(kullanici, 1); 
        //Mesaj gösterilir.
        JOptionPane.showMessageDialog(null, kullanici.adSoyad() + " ile arkadaşlık kuruldu!");
    }

    public void oyunlariGoster() {
        //Main classında çağrılınca çalışır ve önce dolu veya boş olup olmadığı durumlar kontrol edilir.
        if (satinAlinanOyunlar.isEmpty()) {
            //Boş ise mesaj gösterilir.
            JOptionPane.showMessageDialog(null, "Herhangi bir oyun satın almadınız.");
            return;
        }
        //Dolu ise oyunlar oyunlar değişkenine atanır
        String oyunlar = "**Satın Alınan Oyunlar:**\n";
        //oyunların her birini alt alta += ile yazar
        for (Oyun oyun : satinAlinanOyunlar) {
            oyunlar += "- " + oyun.ad + "\n";
        }
        //Mesaj gösterilir.
        JOptionPane.showMessageDialog(null, oyunlar);
    }

    public void oyunuPuanla(Oyun oyun, int puan) {
        //Oyun puanlama çağrılınca burası çalışır ve 
        //ilk önce girilen puanın 0-10 arasında olup olmadığı kontrol edilir.
        if (puan < 0 || puan > 10) {
            JOptionPane.showMessageDialog(null, "Puan 0 ile 10 arasında olmalıdır!");
            return;
        }
        oyun.oyunDegerlendir(this, puan);//Oyun değerlendire girilen puan gönderilir 
        //Ve mesaj gösterilir gösterilirken verilen puan da yazar.
        JOptionPane.showMessageDialog(null, oyun.ad + " oyununa " + puan + " puanı verdiniz!");
    }

    public void arkadaslariGoster() {
        //Arkadaş listesine daha öcne yukarıda atmıştı.Burada ilk önce dolu olup olmadığı kontrol edilir.
        //ona göre işlem yapılır.
        if (arkadaslar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Herhangi bir arkadaşınız yok.");
            return;
        }
        String arkadaslarListesi = "**Arkadaşlar:**\n";
        //for d öngüsü ile arkadaşlar gösterilir.Gösterilirken ad soyad bilgileri yazar.
        for (Kullanici kullanici : arkadaslar.keySet()) {
            arkadaslarListesi += "- " + kullanici.adSoyad() + "\n";
        }
        //arkadaşlar yukarıda arkadaslarListesi değişkenine atanmıştır mesaj ile bu gösterilir.
        JOptionPane.showMessageDialog(null, arkadaslarListesi);
    }
}