package simcity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import simcity.Ressource.RessourceType;

public class Gestion {

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


}

