package simcity;

import com.badlogic.gdx.graphics.Texture;

import simcity.Ressource.RessourceType;

import java.util.Map;
import java.util.HashMap;

public class BatRessources extends Batiment { // moyen que ce soit la classe batiment directement 

    private Map<RessourceType, Double> ressources;

    public BatRessources(Texture texture, float x, float y, float width, float height, Double prix, Double eau, Double electricite, double Bonheur, double argent) {
        super(null, 0, 0, 0, 0, 0.0);
        this.ressources = new HashMap<>();
        this.ressources.put(RessourceType.EAU, eau);
        this.ressources.put(RessourceType.ELECTRICITE, electricite);
        this.ressources.put(RessourceType.BONHEUR, Bonheur);
        this.ressources.put(RessourceType.ARGENT, argent);
    }

    public Map<RessourceType, Double> getRessources() {
        return ressources;
    }
}
