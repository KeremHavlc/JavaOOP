/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package odev_1;

import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author zombi
 */
public class Oyun {
    //Oyun sınıfı, oyunların özelliklerini ve kullanıcıların verdikleri puanları yönetir.
    //Her bir oyun için ad, tür, açıklama, fiyat gibi bilgileri içerir.
    //Ayrıca, oyunun değerlendirilmesi için kullanıcılar ve verdikleri puanları bir eşleme ile tutulur.
    String ad;
    String tur;
    String aciklama;
    double fiyat;
    HashMap<Kullanici, Integer> dereceler; // Kullanıcıların oyunu değerlendirmesi ve verdikleri puanları içeren eşleme
    String oyunAdi;
    //Oyun adının bir kopyasıdır
    public Oyun(String ad, String tur, String aciklama, double fiyat) {
        //Oyun sınıfının yapıcı metodu. Yeni bir oyun oluştururken ad, tür, açıklama ve fiyat bilgileri alınır.
        this.ad = ad;
        this.tur = tur;
        this.aciklama = aciklama;
        this.fiyat = fiyat;
        this.dereceler = new HashMap<>();
    }
    
    public void oyunDetay() {
        //Oyun detay çağrılınca daha öncesinde gelen ad tur açıklama ve fiyat bilgileri bu metod ile kullanıcıya gösterilir.
    JOptionPane.showMessageDialog(null,
        "Oyun Adı:" + ad + "\n"+
        "Tür:" + tur + "\n"+
        "Açıklama:" + aciklama + "\n"+
        "Fiyat:" + fiyat);
    }
    
    public void oyunDegerlendir(Kullanici kullanici, int puan) {
        //Oyunu puanlama da kullanılan puan ve puanı giren kullanıcı bilgisi gelir ve işleme girer.
        dereceler.put(kullanici, puan);
    }
    
    public void oyunculariListele() {
        //oyunu oynanan kullancılılar main classından çağrılınca bu metod çalışır.
        //Ancak main classında çağırma işlemi yapılmamıştır.
        //Yapamadım.
        System.out.println("Bu oyunu oynayan kullanlar:");
        for (Kullanici kullanici : dereceler.keySet()) {
            System.out.println(kullanici.adSoyad());
        }
    }
}
