import java.util.List;

public interface IKurumsalMusteriService
{
    void musteriEkle(KurumsalMusteri kurumsalMusteri);
    void musteriSil(KurumsalMusteri kurumsalMusteri);
    void musteriGuncelle(KurumsalMusteri kurumsalMusteri);
    List<KurumsalMusteri> GetAll();
}
