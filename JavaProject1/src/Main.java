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
        Polygone P = new Polygone(new ArrayList<Point>(){{add((new Point(1,0)));add((new Point(1,1)));add((new Point(2,1)));add((new Point(2,0)));}});
        Ligne EF = new Ligne(new Point(3,1),new Point(1,3));

        Image I1 = new Image(new ArrayList<Forme>(){{add(EF);add(P);}});


        System.out.println(EF);
        System.out.println(I1);
        System.out.println("Perimetre EF : " +EF.getPerimetre() +" P : " + P.getPerimetre()+" I1 : "+I1.getPerimetre());
        System.out.println("Surface EF : " +EF.getSurface() +" P : " + P.getSurface()+" I1 : "+I1.getSurface());
        I1.symetrieAxiale(AB);
        System.out.println(EF);
        System.out.println(I1);
        System.out.println("Perimetre EF : " +EF.getPerimetre() +" P : " + P.getPerimetre()+" I1 : "+I1.getPerimetre());
        System.out.println("Surface EF : " +EF.getSurface() +" P : " + P.getSurface()+" I1 : "+I1.getSurface());
        I1.symetrieAxiale(AB);
        System.out.println(EF);
        System.out.println(I1);
        System.out.println("Perimetre EF : " +EF.getPerimetre() +" P : " + P.getPerimetre()+" I1 : "+I1.getPerimetre());
        System.out.println("Surface EF : " +EF.getSurface() +" P : " + P.getSurface()+" I1 : "+I1.getSurface());

    }
}
