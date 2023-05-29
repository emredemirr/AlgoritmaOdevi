import java.util.List;

public class BireyselMusteriManager implements IBireyselMusteriService
{
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
