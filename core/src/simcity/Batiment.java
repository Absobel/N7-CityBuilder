package simcity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Batiment extends Tile { //batiment le plus classique va faire heriter les autres
    
    private Double prix;

    public Batiment(TextureRegion texture, Double prix) {
        super(texture);
        this.prix = prix;
    }
}
