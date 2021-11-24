package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

import java.util.List;
import java.util.stream.Collectors;

public class Polygone extends Forme implements Tools {
    private final List<Point> points;

    /**
     * Contructeur d'un polygone
     * @param points List de points triés dans l'ordre trigonométrique.
     */
    public Polygone(List<Point> points) {
        this.points = points;
    }

    /**
     * Constructeur pour la copie profonde, pour chaque points dans la liste points un nouvel object Point est créé.
     * @param polygone copié
     */
    public Polygone(Polygone polygone) {
        this(polygone.points.stream().map(Point::new).collect(Collectors.toList()));
    }

    /**
     *
     * @return
     */
    @Override
    public double getSurface() {
        double res = 0;
        int i;
        for (i = 0; i <= points.size() - 2; i++)
            res += points.get(i).getX() * points.get(i + 1).getY() - points.get(i + 1).getX() * points.get(i).getY();
        res += points.get(i).getX() * points.get(0).getY() - points.get(0).getX() * points.get(i).getY();
        res /= 2;
        return ((double) Math.round(Math.abs(res) * 100) / 100);
    }

    /**
     *  Retourne le périmetre du polygone en calculant la distance entre chaque points en 1 en 1.
     * @return le périmetre du polygone
     */
    @Override
    public double getPerimetre() {
        double res = 0.;
        int i;
        for (i = 0; i < this.points.size() - 1; ++i) {
            res += Point.getDistance(this.points.get(i), this.points.get(i + 1));
        }
        res += Point.getDistance(this.points.get(this.points.size() - 1), this.points.get(0));
        return ((double) Math.round(res * 100) / 100);
    }

    /**
     * Retourne une copie du polygone this.
     * @return
     */
    @Override
    public Polygone clone() {
        return new Polygone(this);
    }

    /**
     * Appliquee l'homothetie pour chaque point du polygone.
     * @param origine
     * @param k
     */
    @Override
    public void homothetie(final Point origine, final double k) {
        for (Point p : points) {
            p.homothetie(origine, k);
        }
    }

    /**
     * Applique la translation pour chaque point du polygone.
     * @param x
     * @param y
     */
    @Override
    public void translation(final double x, final double y) {
        for (Point p : points) {
            p.translation(x, y);
        }
    }

    /**
     * Affichage
     * @return String
     */
    @Override
    public String toString() {
        return "Polygone{" +
                "points=" + points +
                '}';
    }

    /**
     * Applique la symétrie centrale pour chaque point du polygone avec pour orgine le point Origne en parametre.
     * @param origine L'origine de la symétrie centrale.
     */
    @Override
    public void symetrieCentrale(final Point origine) {
        for (Point p : points) {
            p.symetrieCentrale(origine);
        }
    }

    /**
     * Applique la symétrie axiale pour chaque point du polygone avec pour orgine l'axe Origne en parametre.
     * @param origine Orgine de la symétrie Axiale.
     */
    @Override
    public void symetrieAxiale(final Ligne origine) {
        for (Point p : points) {
            p.symetrieAxiale(origine);
        }
    }

    /**
     * Applique la rotation d'un angle "angle" avec pour origine le point "origine" à tous les points du polygone.
     * @param origine Point d'origine de la rotation.
     * @param angle angle de la rotation.
     */
    @Override
    public void rotation(final Point origine, double angle) {
        for (Point p : points) {
            p.rotation(origine, angle);
        }
    }

    /**
     * Equals
     * @param o
     * @return true/false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygone polygone = (Polygone) o;
        return points.equals(polygone.points);
    }
}
