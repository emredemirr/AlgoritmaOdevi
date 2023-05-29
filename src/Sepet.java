import java.util.ArrayList;
import java.util.List;

public class Sepet implements ISepetIslemleri
{
    private List<Urun> urunler = new ArrayList();

    public Sepet() {}

    public List<Urun> getUrunler()
    {
        return this.urunler;
    }

    public void setUrunler(List<Urun> urunler)
    {
        this.urunler = urunler;
    }


    public void urunEkle(Urun urun)
    {
        this.urunler.add(urun);
    }

    public void urunCikar(Urun urun)
    {
        this.urunler.remove(urun);
    }

    public void sepetiBosalt()
    {
        this.urunler.clear();
    }
}
