package package1;

import java.awt.Rectangle;

public interface IEtoilePolygone extends IObjetDessinable{
	public int getX();
	public int getY();
	public void placerA(int x, int y);
	public Rectangle getrec();
}
