import java.time.LocalDate;

public class Elektronik extends Urun
{
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
