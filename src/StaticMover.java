import java.awt.geom.AffineTransform;
import java.io.PrintWriter;
import java.util.Scanner;

public class StaticMover implements Mover<StaticMover> {

	
	AffineTransform at;
	float startX, startY;
	
	public StaticMover(Scanner scanner) {
		startX = scanner.nextFloat();
		startY = scanner.nextFloat();
		at = new AffineTransform();
		at.setToTranslation(startX, startY);
	}
	
	@Override
	public void update() {	
		at.translate(0, 0);
	}

	@Override
	public AffineTransform getTransform() {
		return at;
	}

	@Override
	public void save(PrintWriter pw) {
		pw.print("static " + startX + " " + startY + " ");
	}
}
