package simcity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import simcity.Ressource.RessourceType;

import java.util.Map;
import java.util.HashMap;

public class BatRessources extends Batiment { // moyen que ce soit la classe batiment directement 

    private Map<RessourceType, Double> ressources;

    public BatRessources(TextureRegion texture, Double prix, Double eau, Double electricite, double Bonheur, double argent, int habitants) {
        super(texture, prix);
        this.ressources = new HashMap<>();
        this.ressources.put(RessourceType.EAU, eau);
        this.ressources.put(RessourceType.ELECTRICITE, electricite);
        this.ressources.put(RessourceType.BONHEUR, Bonheur);
        this.ressources.put(RessourceType.ARGENT, argent);
        this.ressources.put(RessourceType.HABITANTS, habitants);
    }

    public Map<RessourceType, Double> getRessources() {
        return ressources;
    }
}
