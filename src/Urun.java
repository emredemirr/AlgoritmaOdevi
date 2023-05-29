import java.time.LocalDate;

public class Urun implements IEntity
{
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
