public class Item {
    private double cena;
    private String nazov;
    private int mnozstvo;

    public Item() {
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public double getCena() {
        return cena;
        
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(int mnozstvo) {
        this.mnozstvo = mnozstvo;
    }
    
}
