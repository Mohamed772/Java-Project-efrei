package Forme;

import java.util.HashSet;

public class Ellipse extends Forme implements Tools {
    private Ligne grandAxe,petitAxe;


    public Ellipse(Point centre, Ligne grandAxe, Ligne petitAxe) {
        super(centre);
        this.grandAxe = grandAxe;
        this.petitAxe = petitAxe;
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
    public void homothetie(final Point origine, final double k) {
        HashSet<Ligne> setLignes = new HashSet<Ligne>(){{add(grandAxe);add(petitAxe);}};
        for(Ligne l: setLignes){
            l.getPoint1().homothetie(origine,k);l.getPoint2().homothetie(origine,k);
        }
        this.getCentre().homothetie(origine,k);
    }

    @Override
    public void translation(final double x, final double y) {
        HashSet<Ligne> setLignes = new HashSet<Ligne>(){{add(grandAxe);add(petitAxe);}};
        for(Ligne l: setLignes){
            l.getPoint1().translation(x,y);l.getPoint2().translation(x,y);
        }
        this.getCentre().translation(x,y);
    }

    @Override
    public void rotation(final Point origine, final double angle) {
        HashSet<Ligne> setLignes = new HashSet<Ligne>(){{add(grandAxe);add(petitAxe);}};
        for(Ligne l: setLignes){
            l.getPoint1().rotation(origine,angle);l.getPoint2().rotation(origine,angle);
        }
        this.getCentre().rotation(origine,angle);
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        HashSet<Ligne> setLignes = new HashSet<Ligne>(){{add(grandAxe);add(petitAxe);}};
        for(Ligne l: setLignes){
            l.getPoint1().symetrieAxiale(origine);l.getPoint2().symetrieAxiale(origine);
        }
        this.getCentre().symetrieAxiale(origine);
    }

    @Override
    public void symetrieCentrale(final Point origine) {
        HashSet<Ligne> setLignes = new HashSet<Ligne>(){{add(grandAxe);add(petitAxe);}};
        for(Ligne l: setLignes){
            l.getPoint1().symetrieCentrale(origine);l.getPoint2().symetrieCentrale(origine);
        }
        this.getCentre().symetrieCentrale(origine);
    }
}
