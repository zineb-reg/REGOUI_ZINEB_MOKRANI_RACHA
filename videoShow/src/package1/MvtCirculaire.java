package package1;

import java.awt.Graphics;

/**
 * Animateur permettant de d�placer une forme avec un mouvement circulaire
 * uniforme.
 * 
 */
public class MvtCirculaire implements IFormeAnimable {

    /**
     * rayon du cercle sur lequel l'animateur d�place la forme
     */
    private final int rayon;
    
    /**
     * abscisse du centre du cercle sur lequel l'animateur d�place la forme
     */
    private final int xc;
    
    /**
     * ordonn�e du centre du cercle sur lequel l'animateur d�place la forme
     */
    private final int yc;
    
    /**
     * angle o� se situe le point de r�f�rence de la forme anim�e.
     */
    private double angle;
    
    /**
     * variation de l'angle de rotation � chaque pas d'animation
     */
    private final double deltaAngle;

    public MvtCirculaire(int xc, int yc, int r, double angle, double deltaAngle) {
        this.deltaAngle = deltaAngle;
        this.angle = angle;
        this.rayon = r;
        this.xc = xc;
        this.yc = yc;
    }

    @Override
    public void deplacer(IEtoilePolygone f) {
        angle += deltaAngle;
        double angleRadians = Math.toRadians(angle);
        f.placerA((int) (xc + rayon * Math.cos(angleRadians)),
                (int) (yc + rayon * Math.sin(angleRadians)));
    }
    


}

