import java.util.List;

public interface IBireyselMusteriService
{
    void musteriEkle(BireyselMusteri bireyselMusteri);
    void musteriSil(BireyselMusteri bireyselMusteri);
    void musteriGuncelle(BireyselMusteri bireyselMusteri);
    List<BireyselMusteri> GetAll();

}
