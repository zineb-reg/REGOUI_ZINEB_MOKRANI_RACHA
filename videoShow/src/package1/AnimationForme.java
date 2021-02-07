/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 */
public class AnimationForme implements IObjetAnimable, IEtoilePolygone {
    
    private IEtoilePolygone forme;
    private IFormeAnimable formeAnimable;

    public AnimationForme(IEtoilePolygone forme, IFormeAnimable formeAnimable) {
        this.forme = forme;
        this.formeAnimable = formeAnimable;
    }

    @Override
    public void deplacer() {
        this.formeAnimable.deplacer(this.forme);
    }

    @Override
    public void dessiner(Graphics g) {
        this.forme.dessiner(g);
    }

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void placerA(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getrec() {
		// TODO Auto-generated method stub
		return null;
	}  
    
}
