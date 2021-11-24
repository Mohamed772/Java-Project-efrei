package fr.lsi1.projectalpha;

import fr.lsi1.projectalpha.*;
import fr.lsi1.projectalpha.form.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Dessin> fresque = new ArrayList<>();

        Ligne AB = new Ligne(new Point(1,1),new Point(3,2));
        Polygone P1 = new Polygone(new ArrayList<>(){{add((new Point(1,0)));add((new Point(1,1)));add((new Point(2,1)));add((new Point(2,0)));}});
        Ligne EF = new Ligne(new Point(3,1),new Point(1,3));

        Image I1 = new Image(new ArrayList<>(){{add(EF);add(P1);}});

        Polygone P2 = new Polygone(new ArrayList<>(){{add((new Point(0.2,1.6)));
            add((new Point(1.0,1.0)));
            add((new Point(1.6,1.8)));
            add((new Point(0.8,2.4)));}});
        Ligne EF2 = new Ligne(new Point(2.2,2.6),new Point(2.6,-0.2));
        Image I2 = new Image(new ArrayList<>(){{add(EF2);add(P2);}});

        Dessin D1 = new Dessin(new ArrayList<>(){{add(I1);add(I2);}});

        Ellipse E1 = new Ellipse(new Point(21, 17),
                new Ligne(new Point(15.5, 17), new Point(26, 17.1)),
                new Ligne(new Point(20, 19.5), new Point(20, 14.6)));
        Cercle C1 = new Cercle(new Point(5,5),new Point(5,7));
        Image I3 = new Image(new ArrayList<>(){{add(E1);add(C1);}});
        Image I4 = new Image(new ArrayList<>(){{add(new Ligne(new Point(20,10),new  Point(5,5)));}});

        Dessin D2 = new Dessin(new ArrayList<>(){{add(I3);add(I4);}});

        fresque.add(D1);
        fresque.add(D2);

        System.out.println("Perimetre D1 : " +D1.getPerimetre());
        System.out.println("Surface D1 : " +D1.getSurface());
        System.out.println("Perimetre D2 : " +D2.getPerimetre());
        System.out.println("Surface D2 : " +D2.getSurface());

        System.out.println(toString(fresque));
        // symétrie Axiale

        System.out.println(D1);
        D1.symetrieAxiale(AB);
        System.out.println(D1);
        D1.symetrieAxiale(AB);
        System.out.println(D1);



    }

    public static String toString(ArrayList<Dessin> Fresque){
        String res = "Fresque :  ";
        for (Dessin d:Fresque){
            res += d.toString()+" \n";
        }
        return res;
    }
}
