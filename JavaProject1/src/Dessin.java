import Forme.*;

import java.util.Collections;
import java.util.List;

public class Dessin extends Forme implements Tools {
    List<Image> imagesList;

    public Dessin(List<Image> imagesList) {
        this.imagesList = imagesList;
    }

    @Override
    public String toString() {
        return "Dessin{" +
                "imagesList=" + imagesList +
                '}';
    }

    @Override
    public void homothetie(final Point origine,final double k) {
        for (Image f : imagesList){
            f.homothetie(origine,k);
        }
    }

    @Override
    public void translation(final double x, final double y) {
        for (Image f : imagesList){
            f.translation(x,y);
        }
    }

    @Override
    public void rotation(final Point origine,final double angle) {
        for (Image f : imagesList){
            f.rotation(origine,angle);
        }
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        for (Image f : imagesList){
            f.symetrieAxiale(origine);
        }
    }

    @Override
    public void symetrieCentrale(final Point origine) {
        for (Image f : imagesList){
            f.symetrieCentrale(origine);
        }
    }


    public void sortImagesBySurface(){
        Collections.sort(imagesList, (a,b) -> (int) (a.getSurface() - b.getSurface()));
    }

    @Override
    public double getSurface() {
        double res=0;
        for (Image f : imagesList){
            res += f.getSurface();
        }
        return res;
    }

    @Override
    public double getPerimetre() {
        double res=0;
        for (Image f : imagesList){
            res += f.getPerimetre();
        }
        return res;
    }
}
