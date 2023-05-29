import java.util.List;

public interface IUrunService
{
    void urunEkle(Urun urun);
    void UrunSil(Urun urun);
    void urunGuncelle(Urun urun);
    void fiyatGuncelle(Urun urun) throws UrunFiyatiNegatifHata;
    List<Urun> GetAll();
}
