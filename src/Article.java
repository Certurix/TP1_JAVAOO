public class Article {
    private int code;
    private float prix;
    private int qtit_stock;
    private String nomArticle;
    private Fournisseur fournisseur;

    public Article(String nomArticle, int code, float prix, int qtit_stock, Fournisseur fournisseur) {
        this.code = code;
        this.prix = prix;
        this.qtit_stock = qtit_stock;
        this.nomArticle = nomArticle;
        this.fournisseur = fournisseur;
    }

    public Article(Article a) {
        this.code = a.code;
        this.prix = a.prix;
        this.qtit_stock = a.qtit_stock;
        this.nomArticle = a.nomArticle;
        this.fournisseur = a.fournisseur;
    }

    public String GetNomArticle() {
        return this.nomArticle;
    }

    public int GetCode() {
        return this.code;
    }

    public float GetPrix() {
        return this.prix;
    }

    public int GetQtiStock() {
        return this.qtit_stock;
    }

    public Fournisseur GetFournisseur() {
        return this.fournisseur;
    }

    public void SetNomArticle (String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public void SetCode (int code) {
        this.code = code;
    }

    public void SetPrix (float prix) {
        this.prix = prix;
    }

    public void SetQtiStock (int qtit_stock) {
        this.qtit_stock = qtit_stock;
    }

    public void SetFournisseur(Fournisseur f) {
        this.fournisseur = f;
    }

    public boolean Compare(int code) {
        return this.code == code;
    }

    public void Affiche() {
        System.out.println("Nom: " + this.nomArticle + ", Code: " + this.code + ", Prix: " + this.prix + ", Quantité en stock: " + this.qtit_stock + ", Fournisseur" + this.fournisseur);
    }

    @Override
    public String toString() {
        return "Code: " + this.code + ", Nom: " + this.nomArticle + ", Prix: " + this.prix + ", Quantité en stock: " + this.qtit_stock +  ", Fournisseur" + this.fournisseur;    }
}
