package Forme;


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

    public Point getCentre() {
        return pCentre;
    }

    public void setpCentre(Point pCentre) {
        this.pCentre = pCentre;
    }


}
