public class Magasin {
    private String nomMagasin;
    private String proprietaire;
    private String description;
    private Stock stock;

    public Magasin(String nomMagasin, String proprietaire, String description, Stock stock) {
        this.nomMagasin = nomMagasin;
        this.proprietaire = proprietaire;
        this.description = description;
        this.stock = new Stock(stock);
    }

    public String GetNomMagasin() {
        return this.nomMagasin;
    }

    public String GetProprietaire() {
        return this.proprietaire;
    }

    public String GetDescription() {
        return this.description;
    }

    public Stock GetStock() {
        return new Stock(this.stock);
    }

    public void SetNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }

    public void SetProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public void SetDescription(String description) {
        this.description = description;
    }

    public void SetStock(Stock stock) {
        this.stock = new Stock(stock);
    }
}
