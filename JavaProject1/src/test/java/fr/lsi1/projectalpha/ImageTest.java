package fr.lsi1.projectalpha;

import fr.lsi1.projectalpha.form.*;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ImageTest extends TestCase {
    Point A = new Point(1,1);
    Point B = new Point(3,2);
    Ligne AB = new Ligne(A,B);
    Polygone P = new Polygone(new ArrayList<Point>(){{add((new Point(1,0)));add((new Point(1,1)));add((new Point(2,1)));add((new Point(2,0)));}});
    Ligne EF = new Ligne(new Point(3,1),new Point(1,3));

    Image I1 = new Image(new ArrayList<Forme>(){{add(EF);add(P);}});

    public void testHomothetie() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1.0,-0.5)));
            add((new Point(1.0,1.0)));add((new Point(2.5,1.0)));add((new Point(2.5,-0.5)));}});

        Ligne EF2 = new Ligne(new Point(4.0,1.0),new Point(1.0,4.0));
        Image I2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});

        //System.out.println(I1.equals(I2));
        I1.homothetie(A,1.5);
        //System.out.println(I1.equals(I2));
        Assert.assertEquals(I1,I2);

    }

    public void testTranslation() {
        double x = 3,y=2;
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1+x,0+y)));
            add((new Point(1+x,1+y)));add((new Point(2+x,1+y)));add((new Point(2+x,0+y)));}});

        Ligne EF2 = new Ligne(new Point(3.0+x,1.0+y),new Point(1.0+x,3.0+y));
        Image I2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});


        //System.out.println(I1);
        I1.translation(x,y);
        //System.out.println(I1);
        Assert.assertEquals(I1,I2);


    }

    public void testRotation() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(0.0,1.0)));
            add((new Point(1.0,1.0)));
            add((new Point(1.0,0.0)));
            add((new Point(0.0,0.0)));}});
        Ligne EF2 = new Ligne(new Point(1.0,-1.0),new Point(3.0,1.0));
        Image I2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});

        I1.rotation(A,90);
        //System.out.println(I1);
        Assert.assertEquals(I1,I2);
    }

    public void testSymetrieAxiale() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(0.2,1.6)));
                                                            add((new Point(1.0,1.0)));
                                                            add((new Point(1.6,1.8)));
                                                            add((new Point(0.8,2.4)));}});
        Ligne EF2 = new Ligne(new Point(2.2,2.6),new Point(2.6,-0.2));
        Image I2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});

        I1.symetrieAxiale(AB);
        //System.out.println(I1);
        Assert.assertEquals(I1,I2);
    }

    public void testSymetrieCentrale() {
        Ligne EF2 = new Ligne(new Point(-1.0,1.0),new Point(1.0,-1.0));
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1.0,2.0)));
            add((new Point(1.0,1.0)));
            add((new Point(0.0,1.0)));
            add((new Point(0.0,2.0)));}});
        Image I2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});

        I1.symetrieCentrale(A);
        //System.out.println(I1);
        Assert.assertEquals(I1,I2);
    }

    public void testGetSurface() {
        double surfaceTotale = 0;
        for(Forme f: I1.formeList){
            surfaceTotale += f.getSurface();
        }
        //System.out.println(I1.getSurface() +" " + surfaceTotale);

        Assert.assertEquals(I1.getSurface(),surfaceTotale,0.1);

    }

    public void testGetPerimetre() {
        double perimetreTotale = 0;
        for(Forme f: I1.formeList){
            perimetreTotale += f.getPerimetre();
        }
        //System.out.println(I1.getPerimetre() +" " + perimetreTotale);

        Assert.assertEquals(I1.getPerimetre(),perimetreTotale,0.1);
    }

    public void testSortFormesPerimetre() {
        Image I1 = new Image(new ArrayList<Forme>(){{add(EF);add(P);add(AB);}});

        List<Forme> newList = I1.sortedImagesByPerimetre();
        //System.out.println(I1);
        //System.out.println(I1.sortedImagesByPerimetre());
        Assert.assertEquals(newList,new ArrayList<Forme>(){{add(AB);add(EF);add(P);}});
    }
}