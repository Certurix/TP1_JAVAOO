public class Fournisseur {
    private int id;
    private String raison_sociale;
    private String adresse;
    private int matricule_fiscal;
    private double chiffre_affaires;
    private String groupe;

    public Fournisseur() {
        this.id = 0;
        this.raison_sociale = null;
        this.adresse = null;
        this.chiffre_affaires = 0;
        this.groupe = null;
    }

    public Fournisseur(int id, String raison_sociale, String adresse, int matricule_fiscal, double chiffre_affaires, String groupe) {
        if (id < 0 || chiffre_affaires < 1000) {
            throw new IllegalArgumentException("L'ID doit être positif et le chiffre d'affaires doit être au moins à 1000 €");
        }
        this.id = id;
        this.raison_sociale = raison_sociale;
        this.adresse = adresse;
        this.matricule_fiscal = matricule_fiscal;
        this.chiffre_affaires = chiffre_affaires;
        this.groupe = groupe;
    }

    public Fournisseur(Fournisseur f) {
        this.id = f.id;
        this.raison_sociale = f.raison_sociale;
        this.adresse = f.adresse;
        this.matricule_fiscal = f.matricule_fiscal;
        this.chiffre_affaires = f.chiffre_affaires;
        this.groupe = f.groupe;
    }

    public int GetId() {
        return this.id;
    }

    public String GetRaisonSociale() {
        return this.raison_sociale;
    }

    public String GetAdresse() {
        return this.adresse;
    }

    public int GetMatriculeFiscal() {
        return this.matricule_fiscal;
    }

    public double GetChiffreAffaires() {
        return this.chiffre_affaires;
    }

    public String GetGroupe() {
        return this.groupe;
    }

    public void SetId(int id) {
        // Gestion des exceptions et de la validation en vérifiant que l'id est positif
        if (id < 0) {
            throw new IllegalArgumentException("L'ID doit être positif");
        }
        this.id = id;
    }

    public void SetRaisonSociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }

    public void SetAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void SetMatriculeFiscal(int matricule_fiscal) {
        this.matricule_fiscal = matricule_fiscal;
    }

    public void SetChiffreAffaires(float chiffre_affaires) {
        // Gestion des exceptions et de la validation en vérifiant que le chiffre d'affaires est au moins à 1000 €
        if (chiffre_affaires < 1000) {
            throw new IllegalArgumentException("Le chiffre d'affaires doit être au moins à 1000 €");
        }
        this.chiffre_affaires = chiffre_affaires;
    }

    public void SetGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void Affiche() {
        System.out.println("ID: " + this.id + ", Raison Sociale: " + this.raison_sociale + ", Adresse: " + this.adresse + ", Matricule Fiscal: " + this.matricule_fiscal + ", Chiffre d'Affaires: " + this.chiffre_affaires + ", Groupe: " + this.groupe);
    }

    public Fournisseur Fusion(Fournisseur f) {
        if (this.matricule_fiscal != f.matricule_fiscal) {
            throw new IllegalArgumentException("Les fournisseurs doivent avoir le même matricule fiscal pour être fusionnés");
        }
        if (!this.groupe.equals(f.groupe)) {
            throw new IllegalArgumentException("Les fournisseurs doivent appartenir au même groupe pour être fusionnés");
        }
        Fournisseur fusion = new Fournisseur();
        fusion.SetId(this.id+1000+f.id);
        fusion.SetRaisonSociale(this.groupe);
        fusion.chiffre_affaires = this.chiffre_affaires + f.chiffre_affaires;
        fusion.SetAdresse(this.adresse);
        fusion.SetMatriculeFiscal(this.matricule_fiscal);
        fusion.SetGroupe(this.groupe);
        return fusion;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Raison Sociale: " + this.raison_sociale + ", Adresse: " + this.adresse + ", Matricule Fiscal: " + this.matricule_fiscal + ", Chiffre d'Affaires: " + this.chiffre_affaires + ", Groupe: " + this.groupe;
    }


}
