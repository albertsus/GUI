import java.awt.geom.AffineTransform;
import java.io.PrintWriter;

public interface Mover<T> {

	public void update();
	
	public AffineTransform getTransform();
	
	public void save(PrintWriter pw);
	
}
