/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package odev_1;

import java.util.HashMap;

/**
 *
 * @author zombi
 */
public  class PuanTablosu {
    //PuanTablosu sınıfı, oyunların puanlarını ve en iyi oyunları yönetir.
    //Her bir oyunun puanını ve en yüksek puan alan oyunları saklar.
    HashMap<Oyun, Double> puanlar;
    // Oyunların puanlarını ve oyunlar arasındaki ilişkiyi tutan eşleme
    
    public PuanTablosu() {
        //PuanTablosu sınıfının yapıcı metodu. Yeni bir puan tablosu oluşturur.
        this.puanlar = new HashMap<>();
    }
    
    public  void puanTablosuGoruntule() {
      //Puan tablosunu konsola yazdıran metot.
     // Her bir oyunun adı ve puanı ekrana yazdırılır.
        for (Oyun oyun : puanlar.keySet()) {
            System.out.println("Oyun: " + oyun.ad + ", Puan: " + puanlar.get(oyun));
        }
    }
    
    public void enIyiOyunlar() {
      //En iyi oyunları konsola yazdıran metot.
     // En yüksek puana sahip oyunlar ve puanları ekrana yazdırılır.
        System.out.println("En Iyi Oyunlar:");
       
        for (Oyun oyun : puanlar.keySet()) {
            System.out.println("Oyun: " + oyun.ad + ", Puan: " + puanlar.get(oyun));
        }
    }
}
