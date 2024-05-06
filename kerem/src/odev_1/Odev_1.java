package odev_1;

import javax.swing.JOptionPane;

public class Odev_1 {

    public static void main(String[] args) {
        // Daha sonrasında seçimlerde kullanmak üzere Puan tablosu oluşturuluyor.
        PuanTablosu puanlar = new PuanTablosu();
        //Kullanıcılar ve Oyunlar Daha öncesinde burada tanımlanmıştır
        Kullanici kullanici1 = new Kullanici("Kerem", "Havlucu", "kkhavlucu", "123456", "kkhvlc@example.com");
        Kullanici kullanici2 = new Kullanici("Berkant", "Havlucu", "brknthvlc", "123456", "brknthvlc@example.com");
        Oyun oyun1 = new Oyun("PUBG", "Aksiyon", "Hayatta kalma Oyunu", 50.00);
        Oyun oyun2 = new Oyun("League Of Legends", "MOBA", "Sihirdar Vadisi", 0.00);      

        //Başlangıç için kullanici1 seçilmektedir daha sonrasında seçimlerde case 8 seçilirse 
        //kullanici2 değişimi sağlanacaktır.Ayrıca alınan oyunlar ve puanlamalar vs.işlemleri
        //için secilenKullanici sonrasında kullanılmıştır.
        Kullanici secilenKullanici = kullanici1;

        // Kullanıcının işlem yapmaya devam edip etmeyeceğini kontrol etmek için bool tipinde 
        //devam oluşturulmuştur.En sonda false olarak döndürülüp program kapatılır.
        boolean devam = true;
        //Ana döngü devam olduğu sürece devam etmektedir.
        while (devam) {
            //Burada kullanıcıdan yapmak istediği işlemleer secim değişkenine aktarılmıştır.
            //daha sonrasında switch case ile secime göre işlem yapabilmek içindir.
            String secim = JOptionPane.showInputDialog(
                    //Burada Kullanıcıya işlemler gösterilmektedir.
                    "Lütfen yapmak istediğiniz işlemi seçiniz:\n"
                            + "1. Oyun Satın Al\n"
                            + "2. Oyun Puanla\n"
                            + "3. Kullanıcı Bilgilerini Görüntüle\n"
                            + "4. Satın Alınan Oyunları Görüntüle\n"
                            + "5. Arkadaşlarını Görüntüle\n"
                            + "6. Puan Tablosunu Görüntüle\n"
                            + "7. En İyi Oyunları Görüntüle\n"
                            + "8. Kullanıcı Değiştir\n"
                            + "9. Arkadaşlık İsteği Gönder\n"
                            + "10. Çıkış");
            //case ile işlem yaparken kullanabilmek için daha öncesinde secim değişkeni 
            //string oldugu için onu INT tipine dönüştürmektedir.
            int secimInt = Integer.parseInt(secim);
            //Switch Case Yapısı Başlatılıyor...
            switch (secimInt) {
                //1.Seçimde Oyun satın alma işlemleri gerçekleşiyor.
                case 1:
                    int oyunSecimi = Integer.parseInt(JOptionPane.showInputDialog("Hangi oyunu satın almak istiyorsunuz? (1 veya 2)"));
                    //Seçilen oyun oyunSecimi değişkenine aktarılıyor.
                    if (oyunSecimi == 1) {
                        //1.oyun seçildiyse oyunSatınAl'a oyun1 gönderilir ve oyun1 satın alma işlemi gerçekleşir.
                        secilenKullanici.oyunSatınAl(oyun1);
                    } else if (oyunSecimi == 2) {
                        //2.oyun seçildiyse oyunSatınAl'a oyun2 gönderilir ve oyun2 satın alma işlemi gerçekleşir.
                        secilenKullanici.oyunSatınAl(oyun2);
                    } else {
                        //Farklı bir durumda hata mesajı gösterilir.
                        JOptionPane.showMessageDialog(null, "Geçersiz oyun seçimi!");
                    }
                    break;
                case 2:
                    //Oyun Puanlama İşlemi Yapılır.
                    int puanOyunSecimi = Integer.parseInt(JOptionPane.showInputDialog("Hangi oyunu puanlamak istiyorsunuz? (1 veya 2)"));
                    //Puanlanacak oyun bir değişkene atanır.
                    int puan = Integer.parseInt(JOptionPane.showInputDialog("Puanınız: "));
                    //Verilen puanda bir değişkene atanır
                    if (puanOyunSecimi == 1) {
                        //seçilen oyun ve girilen puan metoda gider.Böylece puanlama gerçekleşir.
                        secilenKullanici.oyunuPuanla(oyun1, puan);
                    } else if (puanOyunSecimi == 2) {
                        //seçilen oyun ve girilen puan metoda gider.Böylece puanlama gerçekleşir.
                        secilenKullanici.oyunuPuanla(oyun2, puan);
                    } else {
                        //Farklı bir durumda hata mesajı gösterilir.
                        JOptionPane.showMessageDialog(null, "Geçersiz oyun seçimi!");
                    }
                    break;
                case 3:
                    //Seçilen kullanıcı başlangıçta 1(bir) olduğu için kullaniciBilgisi birinci kullanıcıyı gösterir.
                    //daha sonra işlemlerde kullanici değiştirilirse yani case 8 çalışırsa seçilenkulanıcı artık 2 olacağı için
                    //kullaniciBilgisinde 2 gösterilir.
                        secilenKullanici.kullaniciBilgisi();
                    break;
               case 4:
                   //seçili olan kullanıcının oyun listesi gösterilir.
                        secilenKullanici.oyunlariGoster(); // Oyunların listesini göster
                        int oyunIndex = Integer.parseInt(JOptionPane.showInputDialog("Detaylarını görmek istediğiniz oyunun numarasını girin:"));
                        //Detay görmek istenilen oyunu bir değişkene atadım.
                    if (oyunIndex == 1) {
                        oyun1.oyunDetay(); // Seçilen oyunun detaylarını göster
                    } else if (oyunIndex == 2) {
                        oyun2.oyunDetay(); // Seçilen oyunun detaylarını göster
                    } else {
                        //Farklı bir durumda hata mesajı gösterilir.
                        JOptionPane.showMessageDialog(null, "Geçersiz oyun numarası!");
                    }
                    break;
                case 5:
                    //seçilen kullanıcın arkaadaşları gösterili
                    //metodun devamında arkadaş yok ise farklı durum veriliyor .
                    secilenKullanici.arkadaslariGoster();
                    break;
                case 6:
                    //PuanTablosuGörüntüle metodu çağrılır.
                    //metodun detayları kendi classında açıklanmıştır.
                    puanlar.puanTablosuGoruntule();
                    break;
                case 7:
                    //enIyiOyunlar metodu çağrılır
                    //metodun detaylarını kendi classında açıkladım.
                    puanlar.enIyiOyunlar();
                    break;
                case 8:
                    //Başlangıçta oluşturdugumuz ve kullanici 1 e atadığım seçilenkullanıcıyı değiştirmek için
                    //bu case kullanılır.
                    if (secilenKullanici == kullanici1) {
                        secilenKullanici = kullanici2;
                    } else {
                        secilenKullanici = kullanici1;
                    }
                    break;
                case 9:
                    //Bu kısım arkadaşların birbiriyle arkadaş olmasını sağlar 
                    //kendi classında açıklandı.
                    Arkadaslik arkadaslik = new Arkadaslik();
                    arkadaslik.arkadaslikIstegiGonder(kullanici1, kullanici2);
                    break;
                case 10:
                    //çıkış yapmak için kullanılır
                    devam = false;
                    break;
                default:
                    //farklı bir durumda hata mesajı gösterilir.
                    JOptionPane.showMessageDialog(null, "Geçersiz seçim!");
                    break;
            }
        }
    }
}
