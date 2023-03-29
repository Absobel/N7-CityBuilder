package simcity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Batiment { //batiment le plus classique va faire heriter les autres
    
    private Texture texture;
    private float x;
    private float y;
    private float width;
    private float height;
    private ResourceType resourceType;
    private int resourceProductionRate;


    public Batiment(Texture texture, float x, float y, float width, float height, ResourceType typeresource, int production) {
        this.resourceType = typeresource;
        this.resourceProductionRate = production;
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x, y, width, height);
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    private enum ResourceType {
        EAU,
        ELECTRICITE,
        BONHEUR,
        ARGENT,
        HABITANT
        
        // Ajoutez d'autres types de ressources en fonction de votre jeu
    }
    }
