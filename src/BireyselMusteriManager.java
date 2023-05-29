import java.util.List;

public class BireyselMusteriManager implements IMusteriService
{

    @Override
    public void musteriEkle(Musteri musteri) {
        System.out.println("Bireysel Musteri Eklendi: ");
    }

    @Override
    public void musteriSil(Musteri musteri) {

    }

    @Override
    public void musteriGuncelle(Musteri musteri) {

    }

    @Override
    public List<Musteri> GetAll() {
        return null;
    }
}
