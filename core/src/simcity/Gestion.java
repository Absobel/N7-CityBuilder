package simcity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gestion {

    private Map<Ressource.ResourceType, Double> ressources;
    private List<Batiment> batiments;

    public Gestion() {
        this.ressources = new HashMap<>();
        for (Ressource.ResourceType type : Ressource.ResourceType.values()) {
            ressources.put(type, 0.0);
        }
        this.batiments = new ArrayList<>();
    }

    public void ajouterRessource(Ressource.ResourceType type, double quantite) {
        double nouvelleQuantite = ressources.get(type) + quantite;
        ressources.put(type, nouvelleQuantite);
    }

    public double getQuantite(Ressource.ResourceType type) {
        return ressources.get(type);
    }

    public void ajouterBatiment(Batiment batiment) {
        batiments.add(batiment);
    }

    public void retirerBatiment(Batiment batiment) {
        batiments.remove(batiment);
    }

    public List<Batiment> getBatiments() {
        return batiments;
    }

}

