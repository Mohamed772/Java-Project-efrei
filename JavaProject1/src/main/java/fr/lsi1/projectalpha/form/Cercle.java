package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

import java.util.Objects;

public class Cercle extends Forme implements Tools {
    private Point pCercle;

    public Cercle(Point centre, Point pCercle) {
        super(centre);
        this.pCercle = pCercle;
    }
    
    public Cercle(Cercle cercle) {
        this(new Point(cercle.pCentre), new Point(cercle.pCercle));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cercle cercle = (Cercle) o;
        return pCercle.equals(cercle.pCercle)&& pCentre.equals(cercle.pCentre);
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "pCercle=" + pCercle +
                ", pCentre=" + pCentre +
                '}';
    }



    @Override
    public double getSurface() {
        return Math.PI * Math.pow(this.getRayon(),2);
    }

    public double getRayon(){
        return Point.getDistance(this.pCercle,this.pCentre);
    }

    @Override
    public double getPerimetre() {
        return Math.PI*2*this.getRayon();
    }

    @Override
    public Cercle clone() {
        return new Cercle(this);
    }

    @Override
    public void homothetie(Point origine, double k) {
        this.pCercle.homothetie(origine,k);
        this.pCentre.homothetie(origine,k);
    }

    @Override
    public void translation(final double x, final double y) {
        this.pCercle.translation(x,y);
        this.pCentre.translation(x,y);
    }

    @Override
    public void rotation(final Point origine, final double angle) {
        this.pCentre.rotation(origine,angle);
        this.pCercle.rotation(origine,angle);
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        this.pCentre.symetrieAxiale(origine);
        this.pCercle.symetrieAxiale(origine);
    }

    @Override
    public void symetrieCentrale(final Point origine) {
        this.pCentre.symetrieCentrale(origine);
        this.pCercle.symetrieCentrale(origine);
    }
}
