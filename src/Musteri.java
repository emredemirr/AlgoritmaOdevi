// Müşteri temel sınıfı
public class Musteri implements IEntity
{

    private int Id;
    private  String Email;
    private String Sifre;


   // Parametreli ve parametresiz kurucu metotlar (Constructor)
    public Musteri() {}
    public Musteri(int id, String email, String sifre) {Id = id; Email = email; Sifre = sifre;}


    // Özelliklere ait getter ve setter
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getSifre() {
        return Sifre;
    }
    public void setSifre(String sifre) {
        Sifre = sifre;
    }
}
