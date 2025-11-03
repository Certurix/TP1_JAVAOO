import java.util.TreeMap;
import java.util.Map;

public class Stock {
    private TreeMap<Integer, Article> articles;

    public Stock() {
        this.articles = new TreeMap<>();
    }

    public Stock(Stock s) {
        this.articles = new TreeMap<>();
        for (Map.Entry<Integer, Article> entry : s.articles.entrySet()) {
            this.articles.put(entry.getKey(), new Article(entry.getValue()));
        }
    }

    public boolean Insertion(Article article) {
        if (article == null) {
            throw new IllegalArgumentException("L'article ne peut pas être null");
        }
        int code = article.GetCode();
        if (this.articles.containsKey(code)) {
            System.out.println("Un article avec le code " + code + " existe déjà dans le stock.");
            return false;
        }
        this.articles.put(code, article);
        return true;
    }

    public float Prix(int code) {
        Article article = this.articles.get(code);
        if (article == null) {
            throw new IllegalArgumentException("Aucun article trouvé avec le code " + code);
        }
        return article.GetPrix();
    }

    public float Vendre(int code, int nbArt) {
        if (nbArt <= 0) {
            throw new IllegalArgumentException("La quantité à vendre doit être positive");
        }
        Article article = this.articles.get(code);
        if (article == null) {
            throw new IllegalArgumentException("Aucun article trouvé avec le code " + code);
        }
        int stockActuel = article.GetQtiStock();
        if (stockActuel < nbArt) {
            throw new IllegalArgumentException("Stock insuffisant. Stock disponible: " + stockActuel + ", demandé: " + nbArt);
        }
        article.SetQtiStock(stockActuel - nbArt);
        return article.GetPrix() * nbArt;
    }

    public void Achat(int code, int nbArt) {
        if (nbArt <= 0) {
            throw new IllegalArgumentException("La quantité d'achat doit être positive");
        }
        Article article = this.articles.get(code);
        if (article == null) {
            throw new IllegalArgumentException("L'article avec le code " + code + " n'existe pas. Utilisez Insertion() pour ajouter un nouvel article.");
        }
        article.SetQtiStock(article.GetQtiStock() + nbArt);
    }

    public boolean Supprime(int code) {
        Article article = this.articles.get(code);
        if (article == null) {
            System.out.println("Aucun article trouvé avec le code " + code);
            return false;
        }
        if (article.GetQtiStock() != 0) {
            System.out.println("Impossible de supprimer l'article. La quantité en stock doit être 0. Stock actuel: " + article.GetQtiStock());
            return false;
        }
        this.articles.remove(code);
        return true;
    }

    public void Affiche() {
        if (this.articles.isEmpty()) {
            System.out.println("Le stock est vide.");
            return;
        }
        System.out.println("===== STOCK =====");
        for (Article article : this.articles.values()) {
            System.out.println("Code: " + article.GetCode() + ", Prix: " + article.GetPrix() + " €, Quantité en stock: " + article.GetQtiStock());
        }
        System.out.println("=================");
    }

    @Override
    public String toString() {
        if (this.articles.isEmpty()) {
            return "Stock vide";
        }
        return "Stock{" +
                "articles=" + articles.values() +
                '}';
    }
}
