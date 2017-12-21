import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.PrintWriter;
import java.util.Scanner;

public class BounceOffMover implements Mover<BounceOffMover> {

	AffineTransform at;
	float startX, startY, vx, vy;
	private Shape shape;
	
	public BounceOffMover(Scanner scanner, Shape shape) {
		this.shape = shape;
		startX = scanner.nextFloat();
		startY = scanner.nextFloat();
		vx = scanner.nextFloat();
		vy = scanner.nextFloat();
		at = new AffineTransform();
		at.setToTranslation(startX, startY);
	}
	
	
	@Override
	public void update() {	
		if ((at.getTranslateX() <= 0) || ((at.getTranslateX() + shape.getBounds2D().getWidth()) >= Scene.sceneWidth + 40)) {
			vx *= -1;
		} 
		if ((at.getTranslateY() <= 0) || ((at.getTranslateY() + shape.getBounds2D().getHeight()) >= Scene.sceneHeight + 150)) {
			vy *= -1;
		}
		at.translate(vx, vy);
	}

	@Override
	public AffineTransform getTransform() {
		return at;
	}

	@Override
	public void save(PrintWriter pw) {
		pw.print("bounce " + startX + " " + startY + " " + vx + " " + vy + " ");
	}
}
