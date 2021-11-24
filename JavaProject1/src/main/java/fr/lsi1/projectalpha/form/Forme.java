package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

public abstract class Forme implements Tools {
    protected Point pCentre;

    public abstract double getSurface();
    public abstract double getPerimetre();

    public Forme(Point centre) {
        this.pCentre = centre;
    }

    public Forme() {
        this.pCentre = new Point(0,0);
    }

    public abstract Forme clone ();

    public Point getCentre() {
        return pCentre;
    }


}
