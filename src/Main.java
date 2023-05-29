import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        UrunManager urunManager = new UrunManager();
        BireyselMusteriManager bireyselMusteriManager = new BireyselMusteriManager();
        KurumsalMusteriManager kurumsalMusteriManager = new KurumsalMusteriManager();

        LocalDate uretimTarihi = LocalDate.of(2023, 10, 5);
        LocalDate sonKullanmaTarihi = LocalDate.of(2024, 10, 5);

        //Bireysel Müşteri
        BireyselMusteri bireyselMusteri = new BireyselMusteri();
        bireyselMusteri.setId(1);
        bireyselMusteri.setAd("Emre");
        bireyselMusteri.setSoyad("Demir");
        bireyselMusteri.setTcKimlikNumarasi("1234567890");
        bireyselMusteri.setEmail("emredemir@gmail.com");
        bireyselMusteri.setSifre("12345");

        //Kurumsal Müşteri
        KurumsalMusteri kurumsalMusteri = new KurumsalMusteri();
        kurumsalMusteri.setId(2);
        kurumsalMusteri.setKurumAd("IBS Software");
        kurumsalMusteri.setVergiKimlikNumarasi("1236574");
        kurumsalMusteri.setEmail("info@ibs.com");
        kurumsalMusteri.setSifre("123456");

        //Elektronik
        Elektronik elektronik = new Elektronik();
        elektronik.setId(1);
        elektronik.setAd("MSI Leopard GX Serisi");
        elektronik.setAciklama("Elektronik Açıklama");
        elektronik.setBarkod("B-1234");
        elektronik.setFiyat(35000);
        elektronik.setStokMiktari(17);
        elektronik.setKategori("Elektronik");
        elektronik.setUretici("MSI");
        elektronik.setUretimTarihi(uretimTarihi);
        elektronik.setSonKullanmaTarihi(sonKullanmaTarihi);


        // Kıyafet
        Kiyafet kiyafet = new Kiyafet();
        kiyafet.setId(2);
        kiyafet.setAd("Zara Kapüşonlu Mont");
        kiyafet.setAciklama("Zara Mont");
        kiyafet.setBarkod("K-1234");
        kiyafet.setBeden("Large");
        kiyafet.setFiyat(2200);
        kiyafet.setKategori("Kıyafet/Giyim");
        kiyafet.setStokMiktari(265);
        kiyafet.setUretici("Zara");
        kiyafet.setUretimTarihi(uretimTarihi);

        try
        {
            elektronik.setFiyat(-20000);
            urunManager.fiyatGuncelle(elektronik);
        }
        catch (Hata e)
        {
            System.out.println("Hata: " + e.getMessage());
        }

        urunManager.urunEkle(elektronik);
        urunManager.urunEkle(kiyafet);

        for (Urun urun : urunManager.sepet)
        {
            System.out.println(urun.getAd() + ": " + urun.getFiyat()+" TL");
        }
        System.out.println("Toplam Tutar: " + urunManager.toplamTutar+" TL");


        urunManager.sayac = UrunManager.getInstanceSayac() + 1;
        System.out.println("Demo Sayacı: " + urunManager.sayac);

        OdemeManager odemeManager = new OdemeManager();
        odemeManager.odemeYap(10);
        odemeManager.odemeYap(urunManager.toplamTutar);


        // Sepet işlemleri
        Sepet sepet = new Sepet();
        sepet.urunEkle(elektronik);
        sepet.urunEkle(kiyafet);
        sepet.urunCikar(elektronik);
        sepet.sepetiBosalt();

        // Bireysel Müşteri
        bireyselMusteriManager.musteriEkle(bireyselMusteri);
        bireyselMusteriManager.musteriGuncelle(bireyselMusteri);
        bireyselMusteriManager.musteriSil(bireyselMusteri);

        //Kurumsal Müşteri
        kurumsalMusteriManager.musteriEkle(kurumsalMusteri);
        kurumsalMusteriManager.musteriGuncelle(kurumsalMusteri);
        kurumsalMusteriManager.musteriSil(kurumsalMusteri);

    }
}
