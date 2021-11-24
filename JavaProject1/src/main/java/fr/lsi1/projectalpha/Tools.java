package fr.lsi1.projectalpha;

import fr.lsi1.projectalpha.form.Ligne;
import fr.lsi1.projectalpha.form.Point;

public interface Tools {
    /**
     * Homothetie a partie d'un point d'origine et du parametre k
     * @param origine
     * @param k
     */
    void homothetie(final Point origine, final double k);

    /**
     * Translation sur laxe x et y
     * @param x
     * @param y
     */
    void translation(final double x, final double y);

    /**
     * Rotation a partir du point d'origine et de l'angle en parametre
     * @param origine
     * @param angle
     */
    void rotation(final Point origine, final double angle);

    /**
     * Symetrie axiale à partie de la Ligne d'origine
     * @param origine
     */
    void symetrieAxiale(final Ligne origine);

    /**
     * Symetrie Centrale à partir d'un point d'origine
     * @param origine
     */
    void symetrieCentrale(final Point origine);
}
