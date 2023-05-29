import java.util.ArrayList;
import java.util.List;

public class UrunManager implements IUrunService
{
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

    public void fiyatGuncelle(Urun urun) throws UrunFiyatiNegatifHata
    {
        if (urun.getFiyat() < 0.0)
            throw new UrunFiyatiNegatifHata("Ürün fiyatı negatif olamaz.");
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
