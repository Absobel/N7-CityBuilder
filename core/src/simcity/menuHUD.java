package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

public class menuHUD extends Stage {

    private Stage sousmenu;
    private TextButton menu;
    private Table table;
    private Table sousmenuTable;  // Nouvelle table pour les boutons du sous-menu
    private Label titleLabel;
    private BitmapFont font;
    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

    public menuHUD(Viewport viewport, SpriteBatch batch) {
        Gdx.input.setInputProcessor(this);  // Active la scène pour récupérer les événements d'entrée

        // Création de la table qui contiendra les boutons du menu principal
        table = new Table();
        table.setFillParent(true);
        table.bottom();
        table.left();
        this.addActor(table);

        // Création de la table qui contiendra les boutons du sous-menu
        sousmenuTable = new Table();
        sousmenuTable.setFillParent(true);
        sousmenuTable.left();  // Alignement des boutons au centre de l'écran
        sousmenuTable.bottom();
        sousmenuTable.setVisible(false);  // Les boutons ne sont pas visibles au début
        this.addActor(sousmenuTable);

        // Ajout du titre
        menu = new TextButton("Menu", skin);
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                show();  // Afficher les boutons du sous-menu
            }
        });

        // Ajout des boutons du sous-menu
        TextButton stage1Button = new TextButton("batiments", skin);
        TextButton stage2Button = new TextButton("decoration", skin);
        TextButton stage3Button = new TextButton("sauvegarde", skin);
        TextButton stage4Button = new TextButton("quitter", skin);

        TextButton backButton = new TextButton("Back", skin);

        // Ajout d'un listener pour chaque bouton du sous-menu
        stage1Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Code pour commencer le stage 1
            }
        });

        stage2Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Code pour commencer le stage 2
            }
        });

        stage3Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Sauvegarde");
            }
        });

        stage4Button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                InputEvent escape = new InputEvent();
                escape.setType(InputEvent.Type.keyDown);
                escape.setKeyCode(Input.Keys.ESCAPE);
                fire(escape);  // Simuler l'appui sur la touche ECHAP (pour quitter le jeu)


            }
        });
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hide();  // Cacher les boutons du sous-menu
            }
        });

        // Ajout des boutons à la table du sous-menu
        sousmenuTable.add(stage1Button).padTop(50f).row();
        sousmenuTable.add(stage2Button).padTop(20f).row();
        sousmenuTable.add(stage3Button).padTop(20f).row();
        sousmenuTable.add(stage4Button).padTop(20f).row();
        sousmenuTable.add(backButton).padTop(20f).row();

        // Ajout du bouton menu à la table du menu principal
        table.add(menu).padTop(20f).row();
    }

    public void show() {
        sousmenuTable.setVisible(true);  // Rendre les boutons du sous-menu visibles
        table.setVisible(false);  // Cacher les boutons du menu principal
    }

    public void hide() {
        sousmenuTable.setVisible(false);  // Cacher les boutons du sous-menu
        table.setVisible(true); 
    }

    public void dispose() {
        sousmenu.dispose();
        this.dispose();
    }


}
