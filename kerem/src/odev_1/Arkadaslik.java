/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package odev_1;

/**
 *
 * @author zombi
 */
public class Arkadaslik {
    //arkadaslıkistegigönder metoduna kullanici1 ve kullanici2 gelir
     public void arkadaslikIstegiGonder(Kullanici kullanici1, Kullanici kullanici2) {
        //kullanici1 kullanici2 yi ekler.
        kullanici1.arkadasEkle(kullanici2);
        //kullanıcı2 kullanıcı1 i ekler.
        kullanici2.arkadasEkle(kullanici1);
        System.out.println(kullanici1.adSoyad() + " ve " + kullanici2.adSoyad() + " artik arkadaslar.");
        //ekran yazdırlır. 
     }
    
    public void arkadaslikIstegiKabulEt(Kullanici kullanici1, Kullanici kullanici2) {
        //arkadaslık kabul et çağrılınca ekleme işlemi olur.
        kullanici1.arkadasEkle(kullanici2);
        kullanici2.arkadasEkle(kullanici1);
        System.out.println(kullanici1.adSoyad() + " ve " + kullanici2.adSoyad() + " artik arkadaslar.");
    }
    
    public void arkadaslikIstegiReddet(Kullanici kullanici1, Kullanici kullanici2) {
        //reddet çağrılınca ekleme işlemi yapmadan direkt konsola yazdırlır.
        System.out.println(kullanici1.adSoyad() + " arkadaslık istegini reddetti.");
    }
}
