package simcity;

import com.badlogic.gdx.graphics.Texture;

public class BatRessources extends Batiment { // moyen que ce soit la classe batiment directement 

    private enum ResourceType {
        EAU,
        ELECTRICITE,
        Bonheur
        // Ajoutez d'autres types de ressources en fonction de votre jeu
    }
    private ResourceType resourceType;
    private int resourceProductionRate;

    public BatRessources(Texture texture, float x, float y, float width, float height, ResourceType typeresource, int production) {
        super(texture, x, y, width, height);
        this.resourceType = typeresource;
        this.resourceProductionRate = production;
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
