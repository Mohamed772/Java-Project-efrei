import Forme.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
    }

    @Test
    public void translation() {
    }

    @Test
    public void rotation() {
    }

    @Test
    public void symetrieAxiale() {
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
                                                    add(new Cercle(new Point(5,5),new Point(5,7)));}}));}});


        D1.symetrieCentrale(A);
        //System.out.println(I1);
        Assert.assertEquals(I1,I2);
    }

    @Test
    public void sortImagesBySurface() {
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
}