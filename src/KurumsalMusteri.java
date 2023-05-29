public class KurumsalMusteri extends Musteri
{

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
