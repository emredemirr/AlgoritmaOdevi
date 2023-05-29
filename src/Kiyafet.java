public class Kiyafet extends Urun
{

    private String beden;

    public Kiyafet() {

    }
    public Kiyafet(String ad, double fiyat, String beden)
    {
        super();
        this.beden = beden;
    }



    public String getBeden() {
        return this.beden;
    }
    public void setBeden(String beden) {
        this.beden = beden;
    }
}
