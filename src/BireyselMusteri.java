
public class BireyselMusteri extends Musteri
{


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
