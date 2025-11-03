public class Fournisseur_Etranger extends Fournisseur {
    private String pays;
    private String devise;
    private double taux_change;

    public Fournisseur_Etranger(int id, String raison_sociale, String adresse, int matricule_fiscal, double chiffre_affaires, String groupe, String pays, String devise, double taux_change) {
        super(id, raison_sociale, adresse, matricule_fiscal, chiffre_affaires, groupe);
        this.pays = pays;
        this.devise = devise;
        this.taux_change = taux_change;
    }

    @Override
    public double GetChiffreAffaires() {
        return super.GetChiffreAffaires() * this.taux_change;
    }
}
