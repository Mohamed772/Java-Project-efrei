package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

import java.util.Objects;

public class Ligne extends Forme implements Tools {
    private final Point point1;
    private final Point point2;

    /**
     * Contructeur d'une ligne a partir de deux points
     * @param pointA
     * @param pointB
     */
    public Ligne(Point pointA, Point pointB) {
        this.point1 = pointA;
        this.point2 = pointB;
    }

    /**
     * Constructeur pour la copie profonde, pour chaque points un nouvel object Point est créé.
     * @param ligne
     */
    public Ligne(Ligne ligne) {
        this(new Point(ligne.getPoint1()), new Point(ligne.getPoint2()));
    }

    /**
     * Getter point 1
     * @return
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Getter point 2
     * @return
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Retourne la surface d'une ligne = 0
     * @return = 0
     */
    @Override
    public double getSurface() {
        return 0.;
    }

    /**
     * Retourne la valeur du périmetre = la distance entre les deux points
     * @return
     */
    @Override
    public double getPerimetre() {
        return Point.getDistance(this.point1,this.point2);
    }


    @Override
    public Ligne clone() {
        return new Ligne(this);
    }

    /**
     * Applique L'homthétie aux deux points de la ligne avec pour origine le point "origine" et le paramettre "k"
     * @param origine
     * @param k
     */
    @Override
    public void homothetie(final Point origine, final double k) {
        this.point1.homothetie(origine,k);
        this.point2.homothetie(origine,k);
    }

    /**
     * Applique la translation sur les deux points de la ligne avec les parametre x et y
     * @param x double
     * @param y double
     */
    @Override
    public void translation(final double x, final double y) {
        this.point1.translation(x,y);
        this.point2.translation(x,y);
    }

    /**
     * Equals
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligne ligne = (Ligne) o;
        return Objects.equals(point1, ligne.point1) && Objects.equals(point2, ligne.point2);
    }

    /**
     * Appliq ela symétire centrale sur les deux points de la ligne avec comme origine le point "origine".
     * @param origine
     */
    @Override
    public void symetrieCentrale(final Point origine) {
        this.point1.symetrieCentrale(origine);
        this.point2.symetrieCentrale(origine);
    }

    /**
     * Applique la symétrie axiale aux deux points de la ligne avec pour parametres le l'axe d'origine "origine".
     * @param origine
     */
    @Override
    public void symetrieAxiale(final Ligne origine) {
        this.point1.symetrieAxiale(origine);
        this.point2.symetrieAxiale(origine);
    }

    /**
     * Applioque La rotation aux deux points de la lignes à partir du point d'origine "origine" et un angle "angle"
     * @param origine
     * @param angle
     */
    @Override
    public void rotation(final Point origine, final  double angle) {
        this.point1.rotation(origine,angle);
        this.point2.rotation(origine,angle);
    }

    /**
     * Affichage
     * @return
     */
    @Override
    public String toString() {
        return "Ligne{" +
                "point1=" + point1 +
                ", point2=" + point2 +
                '}';
    }
}
