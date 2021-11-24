package fr.lsi1.projectalpha;

import fr.lsi1.projectalpha.form.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DessinTest {
    Point A = new Point(1,1);
    Point B = new Point(3,2);
    Ligne AB = new Ligne(A,B);
    Polygone P = new Polygone(new ArrayList<>(){{add((new Point(1,0)));add((new Point(1,1)));add((new Point(2,1)));add((new Point(2,0)));}});
    Ligne EF = new Ligne(new Point(3,1),new Point(1,3));

    Cercle C = new Cercle(new Point(5,5),new Point(5,7));
    Image I1 = new Image(new ArrayList<>(){{add(EF);add(P);}});
    Image I2 = new Image(new ArrayList<>(){{add(C);}});

    Dessin D1 = new Dessin(new ArrayList<>(){{add(I1);add(I2);}});


    @Test
    public void homothetie() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1.0,-0.5)));
            add((new Point(1.0,1.0)));add((new Point(2.5,1.0)));add((new Point(2.5,-0.5)));}});

        Ligne EF2 = new Ligne(new Point(4.0,1.0),new Point(1.0,4.0));
        Image i2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});
        Dessin D2 = new Dessin(new ArrayList<>(){{add(i2);add(new Image(new ArrayList<>(){{
            add(new Cercle(new Point(7,7),new Point(7,10)));}}));}});

        //System.out.println(I1.equals(I2));
        D1.homothetie(A,1.5);
        //System.out.println(I1.equals(I2));
        Assert.assertEquals(D1,D2);
    }

    @Test
    public void translation() {
        double x = 3,y=2;
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1+x,0+y)));
            add((new Point(1+x,1+y)));add((new Point(2+x,1+y)));add((new Point(2+x,0+y)));}});

        Ligne EF2 = new Ligne(new Point(3.0+x,1.0+y),new Point(1.0+x,3.0+y));
        Image i2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});
        Dessin D2 = new Dessin(new ArrayList<>(){{add(i2);add(new Image(new ArrayList<>(){{
            add(new Cercle(new Point(5+x,5+y),new Point(5+x,7+y)));}}));}});


        //System.out.println(I1);
        D1.translation(x,y);
        //System.out.println(I1);
        Assert.assertEquals(D1,D2);
    }

    @Test
    public void rotation() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(0.0,1.0)));
            add((new Point(1.0,1.0)));
            add((new Point(1.0,0.0)));
            add((new Point(0.0,0.0)));}});
        Ligne EF2 = new Ligne(new Point(1.0,-1.0),new Point(3.0,1.0));
        Image i2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});
        Dessin D2 = new Dessin(new ArrayList<>(){{add(i2);add(new Image(new ArrayList<>(){{
            add(new Cercle(new Point(5,-3),new Point(7,-3)));}}));}});

        D1.rotation(A,90);
        //System.out.println(I1);
        Assert.assertEquals(D1,D2);
    }

    @Test
    public void symetrieAxiale() {
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(0.2,1.6)));
            add((new Point(1.0,1.0)));
            add((new Point(1.6,1.8)));
            add((new Point(0.8,2.4)));}});
        Ligne EF2 = new Ligne(new Point(2.2,2.6),new Point(2.6,-0.2));
        Image i2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});
        Dessin D2 = new Dessin(new ArrayList<>(){{add(i2);add(new Image(new ArrayList<>(){{
            add(new Cercle(new Point(6.6,1.8),new Point(8.2,0.6)));}}));}});


        D1.symetrieAxiale(AB);
        //System.out.println(D1);
        Assert.assertEquals(D1,D2);
    }

    @Test
    public void symetrieCentrale() {
        Ligne EF2 = new Ligne(new Point(-1.0,1.0),new Point(1.0,-1.0));
        Polygone P2 = new Polygone(new ArrayList<Point>(){{add((new Point(1.0,2.0)));
            add((new Point(1.0,1.0)));
            add((new Point(0.0,1.0)));
            add((new Point(0.0,2.0)));}});
        Image i2 = new Image(new ArrayList<Forme>(){{add(EF2);add(P2);}});
        Dessin D2 = new Dessin(new ArrayList<>(){{add(i2);add(new Image(new ArrayList<>(){{
                                                    add(new Cercle(new Point(-3,-3),new Point(-3,-5)));}}));}});


        D1.symetrieCentrale(A);
        //System.out.println(D1);
        Assert.assertEquals(D1,D2);
    }

    @Test
    public void sortImagesBySurface() {
        Dessin D1 = new Dessin(new ArrayList<>(){{add(I2);add(I1);}});
        List<Image> newList = D1.sortedImagesBySurface();

        Assert.assertEquals(newList,new ArrayList<>(){{add(I1);add(I2);}});
        //System.out.println(newList);
    }

    @Test
    public void getSurface() {
        double surfaceTotale = 0;
        for(Image d: D1.imagesList){
            for(Forme f: d.formeList){
                surfaceTotale += f.getSurface();
            }
        }
        //System.out.println(D1.getSurface() +" " + surfaceTotale);

        Assert.assertEquals(D1.getSurface(),surfaceTotale,0.1);
    }

    @Test
    public void getPerimetre() {
        double perimetreTotale = 0;
        for(Image d: D1.imagesList){
            for(Forme f: d.formeList){
                perimetreTotale += f.getPerimetre();
            }
        }
        //System.out.println(D1.getPerimetre() +" " + perimetreTotale);

        Assert.assertEquals(D1.getPerimetre(),perimetreTotale,0.1);
    }

    @Test
    public void test_copy() {
        Dessin clonedDessin = D1.clone();

        Assert.assertEquals(D1, clonedDessin);
        Assert.assertNotSame(D1, clonedDessin);
    }
}