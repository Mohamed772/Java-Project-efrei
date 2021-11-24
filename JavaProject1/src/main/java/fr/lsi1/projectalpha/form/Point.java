package fr.lsi1.projectalpha.form;

import fr.lsi1.projectalpha.Tools;

import java.util.Objects;

public class Point implements Tools {
    private double x, y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public Point(Point point) {
        this(point.getX(), point.getY());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = round(x);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = round(y);
    }

    public static double getDistance(Point a, Point b) {
        return Math.floor(Math.sqrt(Math.pow(b.getY() - a.getY(), 2) + (Math.pow(b.getX() - a.getX(), 2))) * 100) / 100;
    }

    @Override
    public void homothetie(final Point origine, final double k) {
        double y = k * (this.getY() - origine.getY()) + origine.getY();
        double x = k * (this.getX() - origine.getX()) + origine.getX();
        this.setY(y);
        this.setX(x);
    }

    @Override
    public void translation(final double x, final double y) {
        this.setY(this.getY() + y);
        this.setX(this.getX() + x);
    }

    @Override
    public void symetrieCentrale(final Point origine) {
        this.setX(2 * origine.getX() - this.getX());
        this.setY(2 * origine.getY() - this.getY());
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        Point v = new Point(origine.getPoint2().getX() - origine.getPoint1().getX(), origine.getPoint2().getY() - origine.getPoint1().getY());
        Point u = new Point(this.getX() - origine.getPoint1().getX(), this.getY() - origine.getPoint1().getY());
        if (!(u.getX() == 0 && u.getY() == 0)) {
            double normeU = Math.sqrt(u.getX() * u.getX() + u.getY() * u.getY());
            Point unitaireU = new Point(u.getX() / normeU, u.getY() / normeU);
            double normeV = Math.sqrt(v.getX() * v.getX() + v.getY() * v.getY());
            Point unitaireV = new Point(v.getX() / normeV, v.getY() / normeV);

            double cosT = unitaireU.getX() * unitaireV.getX() + unitaireU.getY() * unitaireV.getY();
            double sinT = unitaireU.getX() * unitaireV.getY() - unitaireU.getY() * unitaireV.getX();
            double cos2T = cosT * cosT - sinT * sinT;
            double sin2T = 2 * sinT * cosT;

            this.setX((double) Math.round((cos2T * u.getX() - sin2T * u.getY() + origine.getPoint1().getX()) * 100d) / 100d);
            this.setY((double) Math.round((sin2T * u.getX() + cos2T * u.getY() + origine.getPoint1().getY()) * 100d) / 100d);
        }
    }

    @Override
    public void rotation(final Point origine, final double angle) {
        double angleRadian = angle * (Math.PI / 180);
        double yO = (this.getY() - origine.getY());
        double xO = (this.getX() - origine.getX());
        this.setX((double) Math.round((xO * Math.cos(angleRadian)) + (yO * Math.sin(angleRadian)) + origine.getX() * 1d) / 1d);
        this.setY((double) Math.round(-(xO * Math.sin(angleRadian)) + (yO * Math.cos(angleRadian)) + origine.getY() * 1d) / 1d);
    }

    private double round(double value) {
        return Math.round(value * 100) / 100d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }


}
