package fr.lsi1.projectalpha.form;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CercleTest {
    Point A = new Point(1,1);
    Point B = new Point(3,2);
    Ligne AB = new Ligne(A,B);

    Cercle C1 = new Cercle(new Point(5,5),new Point(5,7));

    @Test
    public void getSurface() {
        Assert.assertEquals(C1.getSurface(),12.6,0.1);
    }

    @Test
    public void getPerimetre() {
        Assert.assertEquals(C1.getPerimetre(),12.6,0.1);

    }

    @Test
    public void homothetie() {
        Cercle C2 = new Cercle(new Point(7,7),new Point(7,10));

        C1.homothetie(A,1.5);
        Assert.assertEquals(C1,C2);
    }

    @Test
    public void translation() {
        double x = 10,y=-1;
        Cercle C2 =new Cercle(new Point(5+x,5+y),new Point(5+x,7+y));

        C1.translation(x,y);
        Assert.assertEquals(C1,C2);
    }

    @Test
    public void rotation() {
        Cercle C2 = new Cercle(new Point(5,-3),new Point(7,-3));
        C1.rotation(A,90);
        Assert.assertEquals(C1,C2);
    }

    @Test
    public void symetrieAxiale() {
        Cercle C2 = new Cercle(new Point(6.6,1.8),new Point(8.2,0.6));

        C1.symetrieAxiale(AB);
        Assert.assertEquals(C1,C2);
    }

    @Test
    public void symetrieCentrale() {
        Cercle C2 =new Cercle(new Point(-3,-3),new Point(-3,-5));

        C1.symetrieCentrale(A);
        Assert.assertEquals(C1,C2);
    }
}