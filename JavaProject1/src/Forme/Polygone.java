package Forme;

import java.util.List;

public class Polygone extends Forme implements Tools{
    private List<Point> points;

    public Polygone(List<Point> points) {
        this.points = points;
    }

    @Override
    public double getSurface() {
        double res = 0;
        int i;
        for (i = 0; i <= points.size() - 2; i++)
            res += points.get(i).getX() * points.get(i + 1).getY() - points.get(i + 1).getX() * points.get(i).getY();
        res += points.get(i).getX() * points.get(0).getY() - points.get(0).getX() * points.get(i).getY();
        res /= 2;
        return ((double)Math.round(Math.abs(res)*100)/100);
    }

    @Override
    public double getPerimetre() {
        double res = 0.;
        int i;
        for(i = 0;i < this.points.size()-1;++i){
            res +=Point.getDistance(this.points.get(i),this.points.get(i+1));
        }
        res +=Point.getDistance(this.points.get(this.points.size()-1),this.points.get(0));
        return ((double)Math.round(res*100)/100);
    }

    @Override
    public void homothetie(final Point origine, final double k) {
        for(Point p:points){
            p.homothetie(origine,k);
        }
    }

    @Override
    public void translation(final double x, final double y) {
        for(Point p:points){
            p.translation(x,y);
        }
    }

    @Override
    public String toString() {
        return "Polygone{" +
                "points=" + points +
                '}';
    }

    @Override
    public void symetrieCentrale(final Point origine) {
        for(Point p:points){
            p.symetrieCentrale(origine);
        }
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        for(Point p:points){
            p.symetrieAxiale(origine);
        }
    }

    @Override
    public void rotation(final Point origine, double angle) {
        for(Point p:points){
            p.rotation(origine,angle);
        }
    }
}
