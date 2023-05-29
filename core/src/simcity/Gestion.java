package simcity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import simcity.Ressource.RessourceType;

public class Gestion {

    private Double monnaie;
    private Map<RessourceType, Double> finances;
    private List<BatRessources> batimentsConstruits;
    private Textures texture;


    public Gestion(double monnaie ,double eau, double electricite, double bonheur, double habitants, double argent) {
        this.monnaie = monnaie;
        this.finances = new HashMap<>();
        //for (RessourceType type : RessourceType.values()) {
         //   finances.put(type, );
        //}
        finances.put(RessourceType.EAU, eau);
        finances.put(RessourceType.ELECTRICITE, electricite);
        finances.put(RessourceType.BONHEUR, bonheur);
        finances.put(RessourceType.HABITANTS, habitants);
        finances.put(RessourceType.ARGENT, argent);
        this.batimentsConstruits = new ArrayList<BatRessources>();
        //this.batimentsConstruits.add(new BatRessources(new TextureRegion(Textures.publics.get(0)), (double) 0, (double) 0,(double) 0,(double) 0,(double) 0,(double) 0));
    }

    public void ajouterRessource(RessourceType type, double quantite) {
        double nouvelleQuantite = finances.get(type) + quantite;
        finances.put(type, nouvelleQuantite);
    }

    public double getQuantite(RessourceType type) {
        return finances.get(type);
    }

    public void miseAJour() {
        //for (RessourceType type : RessourceType.values()) {
        //    finances.put(type, 0.0);
        //}
        for (BatRessources batiments : this.batimentsConstruits) {
            for (RessourceType ressource : batiments.getRessources().keySet()) {
                Double count = finances.get(ressource);
                finances.put(ressource, count + batiments.getRessources().get(ressource));
                System.out.println("ressource : " + ressource + " count : " + count + " batiments.getRessources().get(ressource) : " + batiments.getRessources().get(ressource));
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
        return ((monnaie >= 200) && (finances.get(RessourceType.BONHEUR) > 5) ) ;
    }

    public BatRessources centrale() {
        BatRessources batiment = new BatRessources(Textures.publics.get(3), (double) 200, (double)0, (double) 50, -5, 0, -5);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean pompeEauAchetable() {
        return ((monnaie >= 200) && (finances.get(RessourceType.BONHEUR) > 5) && (finances.get(RessourceType.HABITANTS) > 5)) ;
    }

    public BatRessources pompeEau() {
        BatRessources batiment = new BatRessources(Textures.publics.get(4), 200, 50, 0, -5, 0, -5);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean ecoleAchetable() {
        return (monnaie >= 300) ;
    }

    public BatRessources ecole() {
        BatRessources batiment = new BatRessources(Textures.publics.get(7), 300, 0, 0, 50, -10, 10);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean maisonAchetable() {
        return (monnaie >= 300);
    }

    public BatRessources maison() {
        BatRessources batiment = new BatRessources(Textures.habitats.get(0), 300, 0, 0, 0, 20, 10);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean immeubleAchetable() {
        return ((monnaie >= 500) && (finances.get(RessourceType.ELECTRICITE) > 5) && (finances.get(RessourceType.EAU) > 5)) ;
    }

    public BatRessources immeuble() {
        BatRessources batiment = new BatRessources(Textures.habitats.get(1), 1000, -15, -15, 0, 100, 100);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Boolean dkoAchetable() {
        return ((monnaie >= 10)) ;
    }

    public BatRessources dko() {
        BatRessources batiment = new BatRessources(Textures.deco.get(0), 0, 0, 0, 5, 10, 0);
        this.payer(batiment.getPrix());
        this.ajouterBatiment(batiment);
        return batiment;
    }

    public Gestion getgest() {
        return this;
    }

    public String getRessourceValue(RessourceType ressource) {
        return String.valueOf(finances.get(ressource));
    }


}

