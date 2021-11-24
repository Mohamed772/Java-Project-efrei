package fr.lsi1.projectalpha.form;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;

public class PolygoneTest extends TestCase {
    Point A = new Point(1,1);
    Point B = new Point(3,2);
    Ligne AB = new Ligne(A,B);
    Polygone P1 = new Polygone(new ArrayList<Point>(){{add((new Point(1,0)));add((new Point(1,1)));add((new Point(2,1)));add((new Point(2,0)));}});

    public void testGetSurface() {
        Assert.assertEquals(P1.getSurface(),1,0.1);
    }

    public void testGetPerimetre() {
        Assert.assertEquals(P1.getPerimetre(),4,0.1);
    }

    public void testHomothetie() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1.0,-0.5)));
            add((new Point(1.0,1.0)));add((new Point(2.5,1.0)));add((new Point(2.5,-0.5)));}});

        P1.homothetie(A,1.5);
        Assert.assertEquals(P1,P2);
    }

    public void testTranslation() {
        double x = 12,y=6;
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1+x,0+y)));
            add((new Point(1+x,1+y)));add((new Point(2+x,1+y)));add((new Point(2+x,0+y)));}});

        P1.translation(x,y);
        Assert.assertEquals(P1,P2);
    }


    public void testSymetrieCentrale() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1.0,2.0)));
            add((new Point(1.0,1.0)));
            add((new Point(0.0,1.0)));
            add((new Point(0.0,2.0)));}});

        P1.symetrieCentrale(A);
        Assert.assertEquals(P1,P2);

    }

    public void testSymetrieAxiale() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(0.2,1.6)));
            add((new Point(1.0,1.0)));
            add((new Point(1.6,1.8)));
            add((new Point(0.8,2.4)));}});

        P1.symetrieAxiale(AB);
        Assert.assertEquals(P1,P2);
    }

    public void testRotation() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(0.0,1.0)));
            add((new Point(1.0,1.0)));
            add((new Point(1.0,0.0)));
            add((new Point(0.0,0.0)));}});
        P1.rotation(A,90);

        Assert.assertEquals(P1,P2);
    }
}