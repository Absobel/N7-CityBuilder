package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class menuHUD {
    private Stage stage;
    private SpriteBatch batch;
    private Skin skin;
    private Table table;
    private ButtonGroup<Button> buttonGroup;
    
    public menuHUD(SpriteBatch batch, Stage stage) {
        this.batch = batch;
        this.stage = stage;
        
        // Chargement de la skin
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        // Création de la table qui contiendra les boutons
        table = new Table();
        table.setFillParent(true);  // Remplir tout l'écran
        stage.addActor(table);

        // Création des boutons
        Button button1 = new Button(skin);
        Button button2 = new Button(skin);
        Button button3 = new Button(skin);
        button1.add(new Image(new Texture("button1.png")));  // Ajout de l'image pour chaque bouton
        button2.add(new Image(new Texture("button2.png")));
        button3.add(new Image(new Texture("button3.png")));

        // Création du groupe de boutons pour n'avoir qu'un seul bouton sélectionné à la fois
        buttonGroup = new ButtonGroup<>(button1, button2, button3);
        buttonGroup.setMaxCheckCount(1);   // On ne peut sélectionner qu'un bouton à la fois
        buttonGroup.setMinCheckCount(0);   // On peut désélectionner les boutons

        // Ajout des boutons à la table
        table.add(button1);
        table.add(button2);
        table.add(button3);

        // Ajout d'un listener pour chaque bouton pour récupérer le bouton sélectionné
        button1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Bouton 1 sélectionné");
            }
        });
        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Bouton 2 sélectionné");
            }
        });
        button3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                System.out.println("Bouton 3 sélectionné");
            }
        });
    }
}
