import java.util.Scanner;

public class Main {

    private static Stock stock = new Stock();
    private static Magasin magasin = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialiser avec quelques données
        Fournisseur f1 = new Fournisseur(1, "TechSupply", "10 Rue Commerce", 123456, 50000.0, "GroupeTech");
        stock.Insertion(new Article("Ordinateur", 101, 899.99f, 10, f1));
        stock.Insertion(new Article("Souris", 102, 25.50f, 50, f1));
        stock.Insertion(new Article("Clavier", 103, 45.00f, 30, f1));
        magasin = new Magasin("TechStore", "Jean Dupont", "Magasin informatique", stock);

        menuPrincipal();
    }

    private static void menuPrincipal() {
        while (true) {
            System.out.println("\n-------------------------------------");
            System.out.println("Interface principale");
            System.out.println("-------------------------------------");
            System.out.println("Choisir une fonctionnalité :");
            System.out.println("1- Gestion article");
            System.out.println("2- Gestion magasin");
            System.out.println("3- Quitter");
            System.out.println("-------------------------------------");
            System.out.print("Votre choix : ");

            int choix = lireEntier();

            if (choix == 1) {
                menuGestionArticle();
            } else if (choix == 2) {
                menuGestionMagasin();
            } else if (choix == 3) {
                System.out.println("Au revoir!");
                scanner.close();
                return;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }

    private static void menuGestionArticle() {
        while (true) {
            System.out.println("\n-----------------------------------------------");
            System.out.println("1- Ajouter un nouvel article");
            System.out.println("2- Modifier article");
            System.out.println("3- Supprimer article");
            System.out.println("4- Retour au menu principal");
            System.out.println("-----------------------------------------------");
            System.out.print("Votre choix : ");

            int choix = lireEntier();

            if (choix == 1) {
                ajouterArticle();
            } else if (choix == 2) {
                modifierArticle();
            } else if (choix == 3) {
                supprimerArticle();
            } else if (choix == 4) {
                return;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }

    private static void menuGestionMagasin() {
        while (true) {
            System.out.println("\n-----------------------------------------------");
            System.out.println("1- Afficher informations du magasin");
            System.out.println("2- Modifier nom du magasin");
            System.out.println("3- Afficher stock");
            System.out.println("4- Vendre article");
            System.out.println("5- Approvisionner");
            System.out.println("6- Retour au menu principal");
            System.out.println("-----------------------------------------------");
            System.out.print("Votre choix : ");

            int choix = lireEntier();

            if (choix == 1) {
                System.out.println("\nNom: " + magasin.GetNomMagasin());
                System.out.println("Propriétaire: " + magasin.GetProprietaire());
                System.out.println("Description: " + magasin.GetDescription());
            } else if (choix == 2) {
                System.out.print("Nouveau nom : ");
                magasin.SetNomMagasin(scanner.nextLine());
                System.out.println("Modifié!");
            } else if (choix == 3) {
                stock.Affiche();
            } else if (choix == 4) {
                vendreArticle();
            } else if (choix == 5) {
                approvisionner();
            } else if (choix == 6) {
                return;
            } else {
                System.out.println("Choix invalide.");
            }
        }
    }

    private static void ajouterArticle() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Code : ");
        int code = lireEntier();
        System.out.print("Prix : ");
        float prix = lireFloat();
        System.out.print("Quantité : ");
        int qte = lireEntier();

        Fournisseur f = new Fournisseur(1, "Fournisseur", "Adresse", 111111, 10000.0, "Groupe1");
        if (stock.Insertion(new Article(nom, code, prix, qte, f))) {
            System.out.println("Article ajouté!");
        }
    }

    private static void modifierArticle() {
        System.out.print("Code de l'article : ");
        int code = lireEntier();
        try {
            System.out.println("Prix actuel : " + stock.Prix(code) + " €");
            System.out.println("(Modification nécessite accès direct à l'article)");
        } catch (Exception e) {
            System.out.println("Article non trouvé.");
        }
    }

    private static void supprimerArticle() {
        System.out.print("Code : ");
        int code = lireEntier();
        if (stock.Supprime(code)) {
            System.out.println("Article supprimé!");
        }
    }

    private static void vendreArticle() {
        System.out.print("Code : ");
        int code = lireEntier();
        System.out.print("Quantité : ");
        int qte = lireEntier();
        try {
            float montant = stock.Vendre(code, qte);
            System.out.println("Vente: " + montant + " €");
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private static void approvisionner() {
        System.out.print("Code : ");
        int code = lireEntier();
        System.out.print("Quantité : ");
        int qte = lireEntier();
        try {
            stock.Achat(code, qte);
            System.out.println("Approvisionnement réussi!");
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }

    private static int lireEntier() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Nombre invalide : ");
            }
        }
    }

    private static float lireFloat() {
        while (true) {
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Nombre invalide : ");
            }
        }
    }
}

