package simcity;

import java.util.ArrayList;
import java.util.List;
import com.badlogic.gdx.math.Vector2;

public class Route {
    private List<Vector2> noeuds;   // liste des noeuds de la route

    public Route() {
        noeuds = new ArrayList<>();
    }

    /**
     * Ajoute un noeud à la route
     * @param node le noeud à ajouter
     */
    public void addNoeud(Vector2 noeud) {
        noeuds.add(noeud);
    }

    /**
     * Vérifie si un noeud est relié à la route principale
     * @param col la colonne où on veut placer le batiment
     * @param row la ligne où on veut placer le batiment
     * @return true si le noeud est relié à la route principale, false sinon
     */
    public boolean isConnected(int col, int row) {
        if (noeuds.isEmpty()) { // Cas où l'on pose le premier noeud
            return true;
        } else {
            for (Vector2 voisin : getVoisins(new Vector2(col, row))) {
                if (noeuds.contains(voisin)) {
                    return true;
                }
            }
            return false;
        }
    }
    

    /**
     * Retourne les noeuds voisins d'un noeud donné
     * @param noeud le noeud pour lequel on veut obtenir les voisins
     * @return la liste des voisins du noeud donné
     */
    private List<Vector2> getVoisins(Vector2 noeud) {
        List<Vector2> voisins = new ArrayList<>();

        int[][] directions = {
            { 0, 1 },   // Nord
            { 1, 0 },   // Est
            { 0, -1 },  // Sud
            { -1, 0 }   // Ouest
        };

        for (int[] direction : directions) {
            int voisinX = (int) noeud.x + direction[0];
            int voisinY = (int) noeud.y + direction[1];

            if (voisinX >= 0 && voisinX <= IsometricRenderer.GRID_WIDTH && voisinY >= 0 && voisinY <= IsometricRenderer.GRID_HEIGHT) {
                voisins.add(new Vector2(voisinX, voisinY));
            }
        }
        return voisins;
    }


}
