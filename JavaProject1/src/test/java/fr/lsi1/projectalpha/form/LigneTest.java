package fr.lsi1.projectalpha.form;

import junit.framework.TestCase;
import org.junit.Assert;

public class LigneTest extends TestCase {
    Point A = new Point(1,1);
    Point B = new Point(3,2);
    Ligne AB = new Ligne(A,B);
    Ligne L1 = new Ligne(new Point(3,1),new Point(1,3));


    public void testGetSurface() {
        Assert.assertEquals(L1.getSurface(),0,0.1);
    }

    public void testGetPerimetre() {
        Assert.assertEquals(L1.getPerimetre(),Point.getDistance(L1.getPoint1(),L1.getPoint2()),0.1);
    }

    public void testHomothetie() {
        Ligne L2 = new Ligne(new Point(4.0,1.0),new Point(1.0,4.0));

        L1.homothetie(A,1.5);
        Assert.assertEquals(L1,L2);

    }

    public void testTranslation() {
        double x = 25,y=9;
        Ligne L2 = new Ligne(new Point(3.0+x,1.0+y),new Point(1.0+x,3.0+y));

        L1.translation(x,y);
        Assert.assertEquals(L1,L2);
    }

    public void testSymetrieCentrale() {
        Ligne L2 = new Ligne(new Point(-1.0,1.0),new Point(1.0,-1.0));

        L1.symetrieCentrale(A);
        Assert.assertEquals(L1,L2);
    }

    public void testSymetrieAxiale() {
        Ligne L2 = new Ligne(new Point(2.2,2.6),new Point(2.6,-0.2));

        L1.symetrieAxiale(AB);
        Assert.assertEquals(L1,L2);
    }

    public void testRotation() {
        Ligne L2 = new Ligne(new Point(1.0,-1.0),new Point(3.0,1.0));

        L1.rotation(A,90);
        Assert.assertEquals(L1,L2);
    }
}