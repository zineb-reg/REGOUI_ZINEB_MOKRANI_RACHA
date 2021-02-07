package package1;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * Une forme r�guli�re dont les sommets sont r�partis de fa�on uniforme sur le
 * cercle o� elle est inscrite.
 *
 */
public abstract class FormeCirculaireReguliere extends FormeCirculaire {

    /**
     * l'objet Path correspondant au contour de la forme r�guli�re, exprim� dans
     * le rep�re dont l'origine est le centre du cercle o� elle est inscrite.
     */
    protected Path2D contour;

    /**
     * Constructeur. Ce constructeur n'effectue que l'�tape 1), le calcul des
     * sommets sur le cercle. L'�tape 2 devra �tre r�alis�e dans les sous-classes
     * concr�tes.
     *
     * @param nbSommets le nombre de sommets du polygone regulier
     * @param x abscisse du centre
     * @param y ordonn�e du centre
     * @param r rayon
     * @param epTrait l'epaisseur du trait de contour
     * @param cTrait couleur du trait de contour
     * @param cRemp couleur remplissage
     */
    protected FormeCirculaireReguliere(int nbSommets, int x, int y, int r,
            float epTrait, Color cTrait, Color cRemp) {
        // appel du constructeur de la super classe
        super(x, y, r, epTrait, cTrait, cRemp);

        // Etape 1
        // calcul des sommets r�partis r�guli�rement sur le cercle
        float deltaAngle = 360f / nbSommets;
        float angle = -90;
        Point2D.Float[] sommets = new Point2D.Float[nbSommets];
        for (int i = 0; i < nbSommets; i++) {
            sommets[i] = new Point2D.Float((float) Math.cos(Math.toRadians(angle)) * r,
                    (float) Math.sin(Math.toRadians(angle)) * r);
            angle += deltaAngle;
        }
        // Etape 2, 
        // construction du chemin reliant les sommets devra a �tre r�alis�e dans 
        // les constructeurs des sous-classes concr�tes. 
        // Pour obliger les sous-classes � effectuer cette construction, 
        // on invoque ici une m�thode abstraite qui devra �tre
        // red�finie dans les sous-classes.
        contour = construireContour(sommets);
        // L'appel d'une m�thode dans un constructeur n'est pas recommand� 
        // du fait des effets ind�sirables pouvant exister en cas de red�finition, 
        // (voir l'exemple de getRectangleEngloabnt dans les transparent du cours.
        // Dans ce cas il est conseill� de d�finir cette m�thode comme �tant finale.
        // mais ici, on peut le faire, car la m�thode est abstraite.
    }

    /**
     * M�thode abstraite appel�e dans le constructeur construit le contour
     * de la forme (Path2D) � partir des sommets calcul�s sur le cercle. 
     *
     * @param tabSommets le tableau des sommets.
     * @return le contour de la forme.
     */
    protected abstract Path2D construireContour(Point2D.Float[] tabSommets);
    
    //@Override
    public void dessiner(Graphics g) {
        // on fait une copie du contexte graphique
        Graphics2D g2 = (Graphics2D) g.create();
        // on applique la transformation de coordonn�es pour placer
        // le centre du cercle en (x, y)
        g2.translate(x, y);

        // Etape 3
        // on dessine le contour de la forme
        // avec la couleur de trait sp�cifi�e ou la couleur courante
        // du contexte graphique sinon
        if (couleurTrait != null) {
            g2.setColor(couleurTrait);

        }
        g2.setStroke(new BasicStroke(epaisseurTrait));
        g2.draw(contour);

        // Etape 4
        // remplissage de l'int�rieur de la forme 
        if (couleurRemplissage != null) {
            g2.setColor(couleurRemplissage);
            g2.fill(contour);
        }
    }
}

