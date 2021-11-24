package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

import java.util.List;
import java.util.Objects;

public class Ellipse extends Forme implements Tools {
    private final Ligne grandAxe;
    private final Ligne petitAxe;

    /**
     * Constructeur
     * @param centre Centre le l'ellipse
     * @param grandAxe Gande axe
     * @param petitAxe Petite axe
     */
    public Ellipse(Point centre, Ligne grandAxe, Ligne petitAxe) {
        super(centre);
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
    }

    /**
     * Constructeur avec objet Ellipse pour clonage
     * @param ellipse
     */
    public Ellipse(Ellipse ellipse) {
        this(new Point(ellipse.getCentre()), new Ligne(ellipse.grandAxe) , new Ligne(ellipse.petitAxe));
    }

    @Override
    public double getSurface() {
        return Math.PI * (petitAxe.getPerimetre()/2) * (grandAxe.getPerimetre()/2);
    }

    @Override
    public double getPerimetre() {
        return 2 * Math.PI * Math.sqrt((Math.pow(this.grandAxe.getPerimetre()/2,2) + Math.pow(this.petitAxe.getPerimetre()/2, 2))/2);
    }

    @Override
    public Ellipse clone() {
        return new Ellipse(this);
    }

    @Override
    public void homothetie(final Point origine, final double k) {
        List.of(grandAxe, petitAxe).forEach(ligne -> {
            ligne.getPoint1().homothetie(origine,k);
            ligne.getPoint2().homothetie(origine,k);
        });
        this.getCentre().homothetie(origine,k);
    }

    @Override
    public void translation(final double x, final double y) {
        List.of(grandAxe, petitAxe).forEach(ligne -> {
            ligne.getPoint1().translation(x,y);
            ligne.getPoint2().translation(x,y);
        });
        this.getCentre().translation(x,y);
    }

    @Override
    public void rotation(final Point origine, final double angle) {
        List.of(grandAxe, petitAxe).forEach(ligne -> {
            ligne.getPoint1().rotation(origine,angle);
            ligne.getPoint2().rotation(origine,angle);
        });
        this.getCentre().rotation(origine,angle);
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        List.of(grandAxe, petitAxe).forEach(ligne -> {
            ligne.getPoint1().symetrieAxiale(origine);
            ligne.getPoint2().symetrieAxiale(origine);
        });
        this.getCentre().symetrieAxiale(origine);
    }

    @Override
    public void symetrieCentrale(final Point origine) {
        List.of(grandAxe, petitAxe).forEach(ligne -> {
            ligne.getPoint1().symetrieCentrale(origine);
            ligne.getPoint2().symetrieCentrale(origine);
        });
        this.getCentre().symetrieCentrale(origine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return Objects.equals(grandAxe, ellipse.grandAxe) && Objects.equals(petitAxe, ellipse.petitAxe);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "grandAxe=" + grandAxe +
                ", petitAxe=" + petitAxe +
                ", pCentre=" + pCentre +
                '}';
    }
}
