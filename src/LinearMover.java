import java.awt.geom.AffineTransform;
import java.io.PrintWriter;
import java.util.Scanner;

public class LinearMover implements Mover<LinearMover> {

	AffineTransform at;
	float startX, startY, vx, vy;
	
	public LinearMover(Scanner scanner) {
		startX = scanner.nextFloat();
		startY = scanner.nextFloat();
		vx = scanner.nextFloat();
		vy = scanner.nextFloat();
		at = new AffineTransform();
		at.setToTranslation(startX, startY);
	}
	
	@Override
	public void update() {	
		if (at.getTranslateX() > Scene.sceneWidth + 40) {
			at.setToTranslation(0, at.getTranslateY());
		} 
		
		if (at.getTranslateX() < 0) {
			at.setToTranslation(Scene.sceneWidth + 40, at.getTranslateY());
		}
		
		if (at.getTranslateY() > Scene.sceneHeight + 150) {
			at.setToTranslation(at.getTranslateX(), 0);
		}
		
		if (at.getTranslateY() < 0) {
			at.setToTranslation(at.getTranslateX(), Scene.sceneHeight + 150);
		}
		at.translate(vx, vy);
	}

	@Override
	public AffineTransform getTransform() {
		return at;
	}

	@Override
	public void save(PrintWriter pw) {
		pw.print("linear " + startX + " " + startY + " " + vx + " " + vy + " ");
	}

	
}
