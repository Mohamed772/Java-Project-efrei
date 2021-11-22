package Forme;

import javax.tools.Tool;
import java.util.Objects;

public abstract class Forme implements Tools {
    protected Point pCentre;

    public Forme(Point centre) {
        this.pCentre = centre;
    }

    public Forme() {
        this.pCentre = new Point(0,0);
    }


    public abstract double getSurface();
    public abstract double getPerimetre();

    public Point getCentre() {
        return pCentre;
    }

    public void setpCentre(Point pCentre) {
        this.pCentre = pCentre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forme forme = (Forme) o;
        return Objects.equals(pCentre, forme.pCentre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pCentre);
    }
}
