import java.util.List;

public class KurumsalMusteriManager implements IKurumsalMusteriService
{

    @Override
    public void musteriEkle(KurumsalMusteri kurumsalMusteri)
    {
        System.out.println("Kurumsal Musteri Eklendi: "+ kurumsalMusteri.getKurumAd());
    }

    @Override
    public void musteriSil(KurumsalMusteri kurumsalMusteri)
    {
        System.out.println("Kurumsal Müşteri Silindi: "+kurumsalMusteri.getKurumAd());
    }

    @Override
    public void musteriGuncelle(KurumsalMusteri kurumsalMusteri)
    {
        System.out.println("Kurumsal Müşteri Silindi: "+kurumsalMusteri.getKurumAd());
    }

    @Override
    public List<KurumsalMusteri> GetAll()
    {
        return null;
    }
}
