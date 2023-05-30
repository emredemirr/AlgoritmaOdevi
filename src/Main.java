import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    //Main metodu programın başlayacağı noktadır.
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

        //Main.Elektronik
        Elektronik elektronik = new Elektronik();
        elektronik.setId(1);
        elektronik.setAd("MSI Leopard GX Serisi");
        elektronik.setAciklama("Main.Elektronik Açıklama");
        elektronik.setBarkod("B-1234");
        elektronik.setFiyat(35000);
        elektronik.setStokMiktari(17);
        elektronik.setKategori("Main.Elektronik");
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
            System.out.println("Main.Hata: " + e.getMessage());
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


        // Main.Sepet işlemleri
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


    // Müşteri temel sınıfı
    public static class Musteri implements IEntity {

        private int Id;
        private  String Email;
        private String Sifre;


        // Parametreli ve parametresiz kurucu metotlar (Constructor)
        public Musteri() {}
        public Musteri(int id, String email, String sifre) {Id = id; Email = email; Sifre = sifre;}


        // Özelliklere ait getter ve setter
        public int getId() {
            return Id;
        }
        public void setId(int id) {
            Id = id;
        }
        public String getEmail() {
            return Email;
        }
        public void setEmail(String email) {
            Email = email;
        }
        public String getSifre() {
            return Sifre;
        }
        public void setSifre(String sifre) {
            Sifre = sifre;
        }
    }
    public interface IBireyselMusteriService {
        void musteriEkle(BireyselMusteri bireyselMusteri);
        void musteriSil(BireyselMusteri bireyselMusteri);
        void musteriGuncelle(BireyselMusteri bireyselMusteri);
        List<BireyselMusteri> GetAll();

    }
    public static class BireyselMusteri extends Musteri {


        // Bireysel Müsteri Özellikleri
        private String ad;
        private String soyad;
        private String tcKimlikNumarasi;


        //Kurucu Metod
        public BireyselMusteri() {
            super();
        }
        public BireyselMusteri(int id, String email, String sifre)
        {
            super(id, email, sifre);
        }



        // getter ve setter
        public String getAd() {
            return ad;
        }
        public void setAd(String ad) {
            this.ad = ad;
        }
        public String getSoyad() {
            return soyad;
        }
        public void setSoyad(String soyad) {
            this.soyad = soyad;
        }
        public String getTcKimlikNumarasi() {
            return tcKimlikNumarasi;
        }
        public void setTcKimlikNumarasi(String tcKimlikNumarasi) {
            this.tcKimlikNumarasi = tcKimlikNumarasi;
        }
    }
    public static class BireyselMusteriManager implements IBireyselMusteriService {
        @Override
        public void musteriEkle(BireyselMusteri bireyselMusteri) {
            System.out.println("Bireysel Musteri Eklendi: "+ bireyselMusteri.getAd());
        }
        @Override
        public void musteriSil(BireyselMusteri bireyselMusteri)
        {
            System.out.println("Bireysel Musteri Silindi: "+ bireyselMusteri.getAd());
        }
        @Override
        public void musteriGuncelle(BireyselMusteri bireyselMusteri)
        {
            System.out.println("Bireysel Musteri Güncellendi: "+ bireyselMusteri.getAd());
        }
        @Override
        public List<BireyselMusteri> GetAll()
        {
            return null;
        }
    }
    public interface IKurumsalMusteriService {
        void musteriEkle(KurumsalMusteri kurumsalMusteri);
        void musteriSil(KurumsalMusteri kurumsalMusteri);
        void musteriGuncelle(KurumsalMusteri kurumsalMusteri);
        List<KurumsalMusteri> GetAll();
    }
    public static class KurumsalMusteri extends Musteri {

        private String kurumAd;
        private String vergiKimlikNumarasi;


        public KurumsalMusteri(int id, String email, String sifre) {super(id, email, sifre);}
        public KurumsalMusteri() {}



        public String getKurumAd() {
            return kurumAd;
        }
        public void setKurumAd(String kurumAd) {
            this.kurumAd = kurumAd;
        }
        public String getVergiKimlikNumarasi() {
            return vergiKimlikNumarasi;
        }
        public void setVergiKimlikNumarasi(String vergiKimlikNumarasi) {
            this.vergiKimlikNumarasi = vergiKimlikNumarasi;
        }
    }
    public static class KurumsalMusteriManager implements IKurumsalMusteriService {

        @Override
        public void musteriEkle(KurumsalMusteri kurumsalMusteri)
        {
            System.out.println("Kurumsal Musteri Eklendi: "+ kurumsalMusteri.getKurumAd());
        }

        @Override
        public void musteriSil(KurumsalMusteri kurumsalMusteri)
        {
            System.out.println("Kurumsal Müşteri Silindi: "+kurumsalMusteri.getKurumAd());
        }

        @Override
        public void musteriGuncelle(KurumsalMusteri kurumsalMusteri)
        {
            System.out.println("Kurumsal Müşteri Silindi: "+kurumsalMusteri.getKurumAd());
        }

        @Override
        public List<KurumsalMusteri> GetAll()
        {
            return null;
        }
    }


    public static class Elektronik extends Urun {
        private String marka;
        private String model;


        public Elektronik(String marka, String model) {
            this.marka = marka;
            this.model = model;
        }

        public Elektronik(int id, String ad, String aciklama, String barkod, double fiyat, int stokMiktari, String kategori, String uretici, LocalDate uretimTarihi, LocalDate sonKullanmaTarihi, String marka, String model) {
            super(id, ad, aciklama, barkod, fiyat, stokMiktari, kategori, uretici, uretimTarihi, sonKullanmaTarihi);
            this.marka = marka;
            this.model = model;
        }

        public Elektronik(String ad, double fiyat, String marka)
        {
            this.marka = marka;
        }

        public Elektronik() {

        }

        public String getMarka() {
            return this.marka;
        }
        public void setMarka(String marka) {
            this.marka = marka;
        }
    }
    public static class Hata extends Exception {
        public Hata(String message)
        {
            super(message);
        }
    }
    public static interface IEntity {}
    public interface ISepetIslemleri {
        void urunEkle(Urun var1);
        void urunCikar(Urun var1);
        void sepetiBosalt();
    }
    public interface IUrunService {
        void urunEkle(Urun urun);
        void UrunSil(Urun urun);
        void urunGuncelle(Urun urun);
        void fiyatGuncelle(Urun urun) throws Hata;
        List<Urun> GetAll();
    }
    public static class Kiyafet extends Urun {

        private String beden;

        public Kiyafet() {

        }
        public Kiyafet(String ad, double fiyat, String beden)
        {
            super();
            this.beden = beden;
        }



        public String getBeden() {
            return this.beden;
        }
        public void setBeden(String beden) {
            this.beden = beden;
        }
    }
    abstract static class Odeme {
        public abstract void odemeYap(double tutar);
    }
    public static class OdemeManager extends Odeme {
        @Override
        public void odemeYap(double tutar)
        {
            System.out.println("Ödeme yapılıyor: " + tutar + " TL");
        }
    }
    public static class Sepet implements ISepetIslemleri {
        private List<Urun> urunler = new ArrayList();

        public Sepet() {}

        public List<Urun> getUrunler()
        {
            return this.urunler;
        }

        public void setUrunler(List<Urun> urunler)
        {
            this.urunler = urunler;
        }


        public void urunEkle(Urun urun)
        {
            this.urunler.add(urun);
        }

        public void urunCikar(Urun urun)
        {
            this.urunler.remove(urun);
        }

        public void sepetiBosalt()
        {
            this.urunler.clear();
        }
    }
    public static class Urun implements IEntity {
        private int id;
        private String ad;
        private String aciklama;
        private String barkod;
        private double fiyat;
        private int stokMiktari;
        private String kategori;
        private String uretici;
        private LocalDate uretimTarihi;
        private LocalDate sonKullanmaTarihi;


        public Urun() {}

        public Urun(int id, String ad, String aciklama, String barkod, double fiyat, int stokMiktari, String kategori, String uretici, LocalDate uretimTarihi, LocalDate sonKullanmaTarihi)
        {
            this.id = id;
            this.ad = ad;
            this.aciklama = aciklama;
            this.barkod = barkod;
            this.fiyat = fiyat;
            this.stokMiktari = stokMiktari;
            this.kategori = kategori;
            this.uretici = uretici;
            this.uretimTarihi = uretimTarihi;
            this.sonKullanmaTarihi = sonKullanmaTarihi;
        }


        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getAd() {
            return ad;
        }
        public void setAd(String ad) {
            this.ad = ad;
        }
        public String getAciklama() {
            return aciklama;
        }
        public void setAciklama(String aciklama) {
            this.aciklama = aciklama;
        }
        public String getBarkod() {
            return barkod;
        }
        public void setBarkod(String barkod) {
            this.barkod = barkod;
        }
        public double getFiyat() {
            return fiyat;
        }
        public void setFiyat(double fiyat) {
            this.fiyat = fiyat;
        }
        public int getStokMiktari() {
            return stokMiktari;
        }
        public void setStokMiktari(int stokMiktari) {
            this.stokMiktari = stokMiktari;
        }
        public String getKategori() {
            return kategori;
        }
        public void setKategori(String kategori) {
            this.kategori = kategori;
        }
        public String getUretici() {
            return uretici;
        }
        public void setUretici(String uretici) {
            this.uretici = uretici;
        }
        public LocalDate getUretimTarihi() {
            return uretimTarihi;
        }
        public void setUretimTarihi(LocalDate uretimTarihi) {
            this.uretimTarihi = uretimTarihi;
        }
        public LocalDate getSonKullanmaTarihi() {
            return sonKullanmaTarihi;
        }
        public void setSonKullanmaTarihi(LocalDate sonKullanmaTarihi) {
            this.sonKullanmaTarihi = sonKullanmaTarihi;
        }


    }
    public static class UrunManager implements IUrunService {
        public List<Urun> sepet = new ArrayList();
        public double toplamTutar = 0.0;
        public static int sayac;
        @Override
        public void urunEkle(Urun urun)
        {
            this.sepet.add(urun);
            if (urun.getFiyat()<0)
                this.toplamTutar += urun.getFiyat()*(-1);
            else
                this.toplamTutar += urun.getFiyat();
        }
        @Override
        public void UrunSil(Urun urun)
        {
            System.out.println("Ürün Silindi");
        }
        @Override
        public void urunGuncelle(Urun urun)
        {
            System.out.println("Ürün Güncellendi.");
        }

        public void fiyatGuncelle(Urun urun) throws Hata
        {
            if (urun.getFiyat() < 0.0)
                throw new Hata("Ürün fiyatı negatif olamaz.");
            else
                urun.setFiyat(urun.getFiyat());

        }

        public static int getInstanceSayac() {
            return sayac;
        }
        @Override
        public List<Urun> GetAll() {
            return null;
        }
    }
}


