package fr.lsi1.projectalpha.form;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EllipseTest {
    Point A = new Point(1, 1);
    Point B = new Point(3, 2);
    Ligne AB = new Ligne(A, B);
    Ellipse E1 = new Ellipse(new Point(21, 17),
            new Ligne(new Point(15.5, 17), new Point(26, 17.1)),
            new Ligne(new Point(20, 19.5), new Point(20, 14.6)));

    @Test
    public void getSurface() {
        Assert.assertEquals(E1.getSurface(), 40.5, 0.1);
    }

    @Test
    public void getPerimetre() {
        Assert.assertEquals(E1.getPerimetre(), 25.7, 0.1);

    }

    @Test
    public void homothetie() {
        Ellipse E2 = new Ellipse(new Point(31, 25),
                new Ligne(new Point(22.75, 25), new Point(38.5, 25.15)),
                new Ligne(new Point(29.5, 28.75), new Point(29.5, 21.4)));
        E1.homothetie(A, 1.5);
        Assert.assertEquals(E1, E2);
    }

    @Test
    public void translation() {
        double x=10,y=5;
        Ellipse E2 = new Ellipse(new Point(21+x, 17+y),
                new Ligne(new Point(15.5+x, 17+y), new Point(26+x, 17.1+y)),
                new Ligne(new Point(20+x, 19.5+y), new Point(20+x, 14.6+y)));

        E1.translation(x,y);
        Assert.assertEquals(E1,E2);
    }

    @Test
    public void rotation() {
        Ellipse E2 = new Ellipse(new Point(26, -2),
                new Ligne(new Point(23, 2), new Point(30, -5)),
                new Ligne(new Point(28, 1), new Point(24, -3)));

        E1.rotation(A,45);
        Assert.assertEquals(E1,E2);
    }

    @Test
    public void symetrieAxiale() {
        Ellipse E2 = new Ellipse(new Point(25.8, 7.4),
                new Ligne(new Point(22.5, 3.0), new Point(28.88, 11.34)),
                new Ligne(new Point(27.2, 5.1), new Point(23.28, 8.04)));

        E1.symetrieAxiale(AB);
       Assert.assertEquals(E1,E2);
    }

    @Test
    public void symetrieCentrale() {
        Ellipse E2 = new Ellipse(new Point(-19.0,-15.0),
                new Ligne(new Point(-13.5, -15.0), new Point(-24.0, -15.1)),
                new Ligne(new Point(-18.0, -17.5), new Point(-18.0, -12.6)));

        E1.symetrieCentrale(A);
        Assert.assertEquals(E1,E2);
    }
}