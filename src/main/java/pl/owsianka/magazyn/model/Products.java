package pl.owsianka.magazyn.model;

public class Products {
    private int id;
    private String nazwa;
    private String kod;
    private int ilosc;

    public Products(int id, String nazwa, String kod, int ilosc) {
        this.id = id;
        this.nazwa = nazwa;
        this.kod = kod;
        this.ilosc = ilosc;
    }

    public Products() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
