package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// création de la fenêtre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// création de la zône de dessin dans la fenêtre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fenêtre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesDessins= new TrainCercle[10];
		
		lesDessins[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesDessins[0]);
		lesDessins[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesDessins[1]);
		for (int i = 2; i < 10; i++) {
			lesDessins[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		    d.ajouterObjet(lesDessins[i]);
		}
		////////////////////////////question 10/////////////////////////////////
		Visage V = new Visage (d, 100, 100, 100, 100); d.ajouterObjet(V);
		
		//////////////////////////////question 13///////////////////////
		Etoile E = new Etoile(200, 300, 40, 7, Color.GREEN, Color.GREEN);
		d.ajouterObjet(E);
		PolygoneRegulier P = new PolygoneRegulier(200,300, 40, 7, 7, Color.BLACK, Color.BLACK);
		d.ajouterObjet(P);
		
		///////////////////////question 18//////////////////////////////
		MvtCirculaire Mvt = new MvtCirculaire(250, 250, 180, 0, 5);
		MvtCirculaire Mvt1 = new MvtCirculaire(100, 100, 50, 0, 5);
		
		Etoile E1 = new Etoile(200, 300, 40, 7, Color.YELLOW, Color.YELLOW);
		AnimationForme E2 = new AnimationForme(E1,Mvt); 
		d.ajouterObjet( E2);
		
		PolygoneRegulier P1 = new PolygoneRegulier(200,300, 40, 7, 7, Color.GRAY, Color.GRAY);
		AnimationForme  P2 = new AnimationForme (P1, Mvt1);
		d.ajouterObjet(P2);
		
		
		while(true) {
		// la zone de dessin se réaffiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//réaliser à tous les trains un déplacement élémentaire
		d.animer();
		
		////////////////////////////////////question 10/////////////////////////////
		V.deplacer();
		
		////////////////////////////////////////question 18///////////////////
		E.deplacer();
		P.deplacer();
		
		
		}

	}

}
