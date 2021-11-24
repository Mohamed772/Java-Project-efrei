import Forme.Forme;
import Forme.Ligne;
import Forme.Point;
import Forme.Polygone;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Ligne AB = new Ligne(new Point(1,1),new Point(3,2));
        Polygone P = new Polygone(new ArrayList<>(){{add((new Point(1,0)));add((new Point(1,1)));add((new Point(2,1)));add((new Point(2,0)));}});
        Ligne EF = new Ligne(new Point(3,1),new Point(1,3));

        Image I1 = new Image(new ArrayList<>(){{add(EF);add(P);}});

        Polygone P2 = new Polygone(new ArrayList<>(){{add((new Point(0.2,1.6)));
            add((new Point(1.0,1.0)));
            add((new Point(1.6,1.8)));
            add((new Point(0.8,2.4)));}});
        Ligne EF2 = new Ligne(new Point(2.2,2.6),new Point(2.6,-0.2));
        Image I2 = new Image(new ArrayList<>(){{add(EF2);add(P2);}});

        System.out.println(EF);
        System.out.println(I1);
        System.out.println("Perimetre EF : " +EF.getPerimetre() +" P : " + P.getPerimetre()+" I1 : "+I1.getPerimetre());
        System.out.println("Surface EF : " +EF.getSurface() +" P : " + P.getSurface()+" I1 : "+I1.getSurface());
        System.out.println(I1.equals(I2));
        I1.symetrieAxiale(AB);
        System.out.println(I1.equals(I2));


    }
}
