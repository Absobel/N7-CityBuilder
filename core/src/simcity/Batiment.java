package simcity;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Batiment extends Tile { //batiment le plus classique va faire heriter les autres
    
    private Double prix;

    public Batiment(TextureRegion texture, Double prix) {
        super(texture);
        this.prix = prix;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double Prix) {
        this.prix = prix;
    }

    // public void saveToJson(String filePath) throws IOException {
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     File file = new File(filePath);
    //     objectMapper.writeValue(file, this);
    // }
}
