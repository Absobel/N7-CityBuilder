package simcity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import simcity.Ressource.RessourceType;

import java.util.Map;
import java.util.HashMap;

public class BatRessources extends Batiment { // moyen que ce soit la classe batiment directement 

    private Map<RessourceType, Double> ressources;
    private TextureRegion texture;

    public BatRessources(TextureRegion texture, double i, double j, double k, double Bonheur, double argent, double habitants) {
        super(texture, i);
        this.ressources = new HashMap<>();
        this.ressources.put(RessourceType.EAU, j);
        this.ressources.put(RessourceType.ELECTRICITE, k);
        this.ressources.put(RessourceType.BONHEUR, Bonheur);
        this.ressources.put(RessourceType.ARGENT, argent);
        this.ressources.put(RessourceType.HABITANTS, habitants);
    }

    public Map<RessourceType, Double> getRessources() {
        return ressources;
    }

    public TextureRegion getTexture() {
        return this.texture;
    }
}
