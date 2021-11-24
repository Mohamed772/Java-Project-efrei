package fr.lsi1.projectalpha;

import fr.lsi1.projectalpha.form.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Image extends Forme implements Tools {
    List<Forme> formeList;

    public Image(List<Forme> formeList) {
        this.formeList = formeList;
    }
    
    public Image(Image image) {
        this(image.formeList.stream().map(Forme::clone).collect(Collectors.toList()));
    }

    @Override
    public void homothetie(final Point origine, final double k) {
        for (Forme f : formeList){
            f.homothetie(origine,k);
        }
    }

    @Override
    public void translation(final double x, final double y) {
        for (Forme f : formeList){
            f.translation(x,y);
        }
    }

    @Override
    public void rotation(final Point origine,final double angle) {
        for (Forme f : formeList){
            f.rotation(origine,angle);
        }
    }

    @Override
    public void symetrieAxiale(final Ligne origine) {
        for (Forme f : formeList){
            f.symetrieAxiale(origine);
        }
    }

    @Override
    public void symetrieCentrale(final Point origine) {
        for (Forme f : formeList){
            f.symetrieCentrale(origine);
        }
    }

    @Override
    public double getSurface() {
        double res=0;
        for (Forme f : formeList){
            res += f.getSurface();
        }
        return ((double)Math.round(res*100)/100);
    }

    @Override
    public double getPerimetre() {
        double res=0;
        for (Forme f : formeList){
            res += f.getPerimetre();
        }
        return ((double)Math.round(res*100)/100);
    }

    @Override
    public Image clone() {
        return new Image(this);
    }

    public List<Forme> sortedImagesByPerimetre(){
        return formeList.stream()
                .sorted(Comparator.comparingDouble(Forme::getPerimetre))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Image{" +
                "formeList=" + formeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return formeList.equals(image.formeList);
    }
}
