package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

import java.util.Objects;

public class Ligne extends Forme implements Tools {
    private Point point1;
    private Point point2;

    public Ligne(Point pointA, Point pointB) {
        this.point1 = pointA;
        this.point2 = pointB;
    }
    
    public Ligne(Ligne ligne) {
        this(new Point(ligne.getPoint1()), new Point(ligne.getPoint2()));
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }

    @Override
    public double getSurface() {
        return 0.;
    }

    @Override
    public double getPerimetre() {
        return Point.getDistance(this.point1,this.point2);
    }

    @Override
    public Ligne clone() {
        return new Ligne(this);
    }

    @Override
    public void homothetie(final Point origine, final double k) {
        this.point1.homothetie(origine,k);
        this.point2.homothetie(origine,k);
    }

    @Override
    public void translation(final double x, final double y) {
        this.point1.translation(x,y);
        this.point2.translation(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligne ligne = (Ligne) o;
        return Objects.equals(point1, ligne.point1) && Objects.equals(point2, ligne.point2);
    }


    @Override
    public void symetrieCentrale(final Point origine) {
        this.point1.symetrieCentrale(origine);
        this.point2.symetrieCentrale(origine);
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        this.point1.symetrieAxiale(origine);
        this.point2.symetrieAxiale(origine);
    }

    @Override
    public void rotation(final Point origine, final  double angle) {
        this.point1.rotation(origine,angle);
        this.point2.rotation(origine,angle);
    }
}
