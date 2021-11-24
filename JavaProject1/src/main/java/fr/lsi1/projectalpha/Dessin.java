package fr.lsi1.projectalpha;

import fr.lsi1.projectalpha.form.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Dessin extends Forme implements Tools {
    List<Image> imagesList;

    public Dessin(List<Image> imagesList) {
        this.imagesList = imagesList;
    }
    
    public Dessin(Dessin dessin) {
        this(dessin.imagesList.stream().map(Image::new).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Dessin{" +
                "imagesList=" + imagesList +
                '}';
    }

    @Override
    public void homothetie(final Point origine, final double k) {
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


    public List<Image> sortedImagesBySurface(){
        return imagesList.stream()
                .sorted(Comparator.comparingDouble(Image::getSurface))
                .collect(Collectors.toList());
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

    @Override
    public Dessin clone() {
        return new Dessin(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dessin dessin = (Dessin) o;
        return Objects.equals(imagesList, dessin.imagesList);
    }

}
