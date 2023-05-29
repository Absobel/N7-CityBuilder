package simcity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

import simcity.Ressource.RessourceType;

public class Afficher extends Stage{
    private Gestion gestion;
    private BitmapFont font;
    private Table donnee;
    private Array<Label> ressour = new Array<>(5);

    public Afficher(Gestion gestion) {
        this.gestion = gestion;
        this.font = new BitmapFont();
        this.donnee = new Table();
        donnee.setFillParent(true);
        donnee.top();
        donnee.right();
        this.addActor(donnee);
        font.setColor(Color.RED);
        font.getData().setScale(1);
        ressour.add( new Label("Monnaie : " + gestion.getRessourceValue(RessourceType.ARGENT), new Label.LabelStyle(font, font.getColor())));
        ressour.get(0).setAlignment(Align.right);
        ressour.add( new Label("    électricité : " + gestion.getRessourceValue(RessourceType.ELECTRICITE), new Label.LabelStyle(font, font.getColor())));
        ressour.get(1).setAlignment(Align.right);
        ressour.add( new Label("    eau : " + gestion.getRessourceValue(RessourceType.EAU), new Label.LabelStyle(font, font.getColor())));
        ressour.get(2).setAlignment(Align.right);
        ressour.add( new Label("    bonheur : " + gestion.getRessourceValue(RessourceType.BONHEUR), new Label.LabelStyle(font, font.getColor())));
        ressour.get(3).setAlignment(Align.right);
        ressour.add( new Label("    habitants : " + gestion.getRessourceValue(RessourceType.HABITANTS), new Label.LabelStyle(font, font.getColor())));
        ressour.get(4).setAlignment(Align.right);

        for (Label ress : ressour) {
            donnee.add(ress).pad(1);
        }
    }


}