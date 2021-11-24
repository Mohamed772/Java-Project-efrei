package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

public abstract class Forme implements Tools {
    protected Point pCentre;

    /**
     * Retourne l'aire de la forme géométrique
     * @return
     */
    public abstract double getSurface();

    /**
     * Retourne la perimetre de la forme géométrique
     * @return
     */
    public abstract double getPerimetre();

    /**
     * Contructeur avec un point centrale comme parametre.
     * @param centre
     */
    public Forme(Point centre) {
        this.pCentre = centre;
    }

    /**
     * Constructeur Vide
     */
    public Forme() {
        this.pCentre = new Point(0,0);
    }

    /**
     * Retourne une copie d'une forme.
     * @return
     */
    public abstract Forme clone ();

    public Point getCentre() {
        return pCentre;
    }


}
