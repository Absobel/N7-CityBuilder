package simcity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Batiment extends Tile { //batiment le plus classique va faire heriter les autres
    
    private float x;
    private float y;
    private float width;
    private float height;
    private Double prix;


    public Batiment(TextureRegion texture, float x, float y, float width, float height, Double prix) {
        super(texture);
        this.prix = prix;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

}
