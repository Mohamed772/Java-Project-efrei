package fr.lsi1.projectalpha;

import fr.lsi1.projectalpha.form.Ligne;
import fr.lsi1.projectalpha.form.Point;

public interface Tools {

    public void homothetie(final Point origine, final double k);
    public void translation(final double x, final double y);
    public void rotation(final Point origine, final double angle);
    public void symetrieAxiale(final Ligne origine);
    public void symetrieCentrale(final Point origine);
}
