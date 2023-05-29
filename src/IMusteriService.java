import java.util.List;

public interface IMusteriService
{
    void musteriEkle(Musteri musteri);
    void musteriSil(Musteri musteri);
    void musteriGuncelle(Musteri musteri);
    List<Musteri> GetAll();

}
