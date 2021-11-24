package fr.lsi1.projectalpha.form;

import junit.framework.TestCase;
import org.junit.Assert;

public class PointTest extends TestCase {
    Point A = new Point(1,1);
    Point B = new Point(3,2);
    Ligne AB = new Ligne(A,B);

    Point P1 = new Point(1,0);

    public void testGetDistance() {
        Point P2 = new Point(0,0);
        Assert.assertEquals(Point.getDistance(P1,P2),1,0.1);
    }

    public void testHomothetie() {
        Point P2 = new Point(1.0,-0.5);
        P1.homothetie(A,1.5);
        Assert.assertEquals(P1,P2);

    }

    public void testTranslation() {
        double x = 2,y=10;
        Point P2 = new Point(1+x,0+y);

        P1.translation(x,y);
        Assert.assertEquals(P1,P2);

    }

    public void testSymetrieCentrale() {
        Point P2 = new Point(1.0,2.0);
         P1.symetrieCentrale(A);

         Assert.assertEquals(P1,P2);
    }

    public void testSymetrieAxiale() {
        Point P2 = new Point(0.2,1.6);

        P1.symetrieAxiale(AB);
        Assert.assertEquals(P1,P2);

    }

    public void testRotation() {
        Point P2 = new Point(0.0,1.0);

        P1.rotation(A,90);

        Assert.assertEquals(P1,P2);
    }
}