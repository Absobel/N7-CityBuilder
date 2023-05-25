package simcity;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Batiment { //batiment le plus classique va faire heriter les autres
    // extends tile
    private double prix;
    private TextureRegion texture;

    public Batiment(TextureRegion texture, double prix ) {
        this.texture = texture;
        this.prix = prix;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double Prix) {
        this.prix = prix;
    }



    // public void saveToJson(String filePath) throws IOException {
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     File file = new File(filePath);
    //     objectMapper.writeValue(file, this);
    // }

}
