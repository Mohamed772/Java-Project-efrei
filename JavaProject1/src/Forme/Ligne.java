package Forme;


public class Ligne extends Forme implements Tools {
    private Point point1;
    private Point point2;

    public Ligne(Point pointA, Point pointB) {
        this.point1 = pointA;
        this.point2 = pointB;
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
