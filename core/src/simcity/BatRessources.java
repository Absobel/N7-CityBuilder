package simcity;

import com.badlogic.gdx.graphics.Texture;

import simcity.Ressource.RessourceType;

import java.util.Map;
import java.util.HashMap;

public class BatRessources extends Batiment { // moyen que ce soit la classe batiment directement 

    private Map<RessourceType, Double> ressources;

    public BatRessources(Texture texture, float x, float y, float width, float height, Double prix, Double eau, Double electricite, double Bonheur, double argent) {
        super(null, 0, 0, 0, 0, 0.0);
        this.ressources = new HashMap<>();
        this.ressources.put(RessourceType.EAU, eau);
        this.ressources.put(RessourceType.ELECTRICITE, electricite);
        this.ressources.put(RessourceType.BONHEUR, Bonheur);
        this.ressources.put(RessourceType.ARGENT, argent);
    }



//    public void produireDansTemps(float temps, float intervalle, gestionResource maitresupreme ) { //reussire à recup le temps en cours
//        int produit = this.resourceProductionRate;
//        float timeElapsed = 0;
//        while (timeElapsed < temps) {
//            timeElapsed += intervalle;
//           maitresupreme.addResource(this.resourceType, produit); // ajouter directement à la super classe responsable de l'affichage et des gestions
//            try {
//                Thread.sleep((long) (intervalle * 1000)); // trouver le délai qu'on veut
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    
}
