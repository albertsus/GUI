import java.awt.Graphics2D;

public interface Material<T> {
	
	//takes a Graphics2D object and set the stroke, fill, color, etc properties of it
	public void setupGraphics(Graphics2D g2d);
}
