package simcity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import simcity.Ressource.RessourceType;

public class Gestion {

    private Double monnaie;
    private Map<RessourceType, Double> finances;
    private List<BatRessources> batimentsConstruits;

    public Gestion() {
        this.finances = new HashMap<>();
        for (RessourceType type : RessourceType.values()) {
            finances.put(type, 0.0);
        }
        this.batimentsConstruits = new ArrayList<>();
    }

    public void ajouterRessource(RessourceType type, double quantite) {
        double nouvelleQuantite = finances.get(type) + quantite;
        finances.put(type, nouvelleQuantite);
    }

    public double getQuantite(RessourceType type) {
        return finances.get(type);
    }

    public void miseAJour() {
        for (RessourceType type : RessourceType.values()) {
            finances.put(type, 0.0);
        }
        for (BatRessources batiments : this.batimentsConstruits) {
            for (RessourceType ressource : batiments.getRessources().keySet()) {
                Double count = finances.get(ressource);
                finances.put(ressource, count + batiments.getRessources().get(ressource));
            }
        }
    }

    public void ajouterBatiment(BatRessources batiment) {
        batimentsConstruits.add(batiment);
        miseAJour();
    }

    public void retirerBatiment(BatRessources batiment) {
        batimentsConstruits.remove(batiment);
        miseAJour();
    }

    public void impots() {
        this.monnaie = this.monnaie + finances.get(RessourceType.ARGENT);
    }

    /*payer un batiment
     * 
     */
    public void payer(double prix) {
        this.monnaie = this.monnaie - prix; // on retire le prix du batiment de la monnaie
    }

    public double getMonnaie() {
        return monnaie;
    }   

    public void setMonnaie(double monnaie) {
        this.monnaie = monnaie;
    }

    public Map<RessourceType, Double> getFinances() {
        return finances;
    }

    public void setFinances(Map<RessourceType, Double> finances) {
        this.finances = finances;
    }

    public List<BatRessources> getBatimentsConstruits() {
        return batimentsConstruits;
    }

    public void setBatimentsConstruits(List<BatRessources> batimentsConstruits) {
        this.batimentsConstruits = batimentsConstruits;
    }

    public Boolean centraleAchetable() {
        return ((monnaie >= 200) && (finances.get(RessourceType.BONHEUR) > 5) && (finances.get(RessourceType.HABITANTS) > 5)) ;
    }

    public BatRessources centrale() {
        BatRessources batiment = new BatRessources(texture, 200, 0, 50, -5, 0, -5);
        this.payer(batiment.getPrix);
        this.ajouterBatiment(batiment);
    }

    public Boolean pompeEauAchetable() {
        return ((monnaie >= 200) && (finances.get(RessourceType.BONHEUR) > 5) && (finances.get(RessourceType.HABITANTS) > 5)) ;
    }

    public BatRessources pompeEau() {
        BatRessources batiment = new BatRessources(texture, 200, 50, 0, -5, 0, -5);
        this.payer(batiment.getPrix);
        this.ajouterBatiment(batiment);
    }

    public Boolean ecoleAchetable() {
        return (monnaie >= 300) ;
    }

    public BatRessources ecole() {
        BatRessources batiment = new BatRessources(texture, 300, 0, 0, 50, -10, 10);
        this.payer(batiment.getPrix);
        this.ajouterBatiment(batiment);
    }

    public Boolean maisonAchetable() {
        return (monnaie >= 300);
    }

    public BatRessources maison() {
        BatRessources batiment = new BatRessources(texture, 300, 0, 0, 0, 20, 10);
        this.payer(batiment.getPrix);
        this.ajouterBatiment(batiment);
    }

    public Boolean immeubleAchetable() {
        return ((monnaie >= 500) && (finances.get(RessourceType.ELECTRICITE) > 5) && (finances.get(RessourceType.EAU) > 5)) ;
    }

    public BatRessources immeuble() {
        BatRessources batiment = new BatRessources(texture, 1000, -15, -15, 0, 100, 100);
        this.payer(batiment.getPrix);
        this.ajouterBatiment(batiment);
    }
}

