import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.util.Scanner;

public class SceneObject {

	private Shape shape;
	int startX;
	private int startY;
	private int radius;
	private int w;
	private int h;
	Scene scene;
	private String materialDes;
	private ColorMaterial colorMaterial;
	private DefaultMaterial defaultMaterial;
	private String padDes;
	private String moverDes;
	private LinearMover linearMover;
	private StaticMover staticMover;
	private BounceOffMover bounceOffMover;
	
	//represents a shape in the scene
	public SceneObject(Scanner scanner) throws UnknownMaterialException, UnknownShapeException, UnknownMoverException, UnknownPadException {
		String shapeDes = scanner.next();
		if (shapeDes.equals("circle")) {
			System.out.println(shapeDes);
			radius = scanner.nextInt();
			startX = scanner.nextInt();
			startY = scanner.nextInt();
			shape = new Ellipse2D.Float(startX, startY, radius, radius);
		} else if (shapeDes.equals("rectangle")) {
			System.out.println(shapeDes);
			w = scanner.nextInt();
			h = scanner.nextInt();
			startX = scanner.nextInt();
			startY = scanner.nextInt();
			shape = new Rectangle2D.Float(startX, startY, w, h);
		} else if (shapeDes.equals("ellipse")) {
			System.out.println(shapeDes);
			w = scanner.nextInt();
			h = scanner.nextInt();
			startX = scanner.nextInt();
			startY = scanner.nextInt();
			shape = new Ellipse2D.Float(startX, startY, w, h);
		} else {
			throw new UnknownShapeException();
		}
		
		materialDes = scanner.next();
		if (materialDes.equals("color")) {
			colorMaterial = new ColorMaterial(scanner);
		} else if (materialDes.equals("default")) {
			defaultMaterial = new DefaultMaterial();
		} else if (materialDes.equals("random")){
			colorMaterial = new ColorMaterial();
		} else if (materialDes.equals("blink")){
			colorMaterial = new ColorMaterial();
		} else {
			throw new UnknownMaterialException();
		}
		
		padDes = scanner.next();
		if (!padDes.equals("outline") && !padDes.equals("fill")) {
			throw new UnknownPadException();
		}
		
		moverDes = scanner.next();
		if (moverDes.equals("linear")) {
			linearMover = new LinearMover(scanner);
		} else if (moverDes.equals("static")) {
			staticMover = new StaticMover(scanner);
		} else if (moverDes.equals("bounce")) {
			bounceOffMover = new BounceOffMover(scanner, shape);
		} else {
			throw new UnknownMoverException();
		}
	} 
	
	
	//put the shape in the right place, set the g2 object's color/stroke properties, and then draw the shape
	public void draw(Graphics2D g2d) {
		if (materialDes.equals("default")) {
			defaultMaterial.setupGraphics(g2d);
		} else if (materialDes.equals("color") || materialDes.equals("random")) {
			colorMaterial.setupGraphics(g2d);
		} else if (materialDes.equals("blink")) {
			colorMaterial = new ColorMaterial();
			colorMaterial.setupGraphics(g2d);
		}
		
		if (moverDes.equals("linear")) {
			g2d.setTransform(linearMover.getTransform());
		} else if (moverDes.equals("static")) {
			g2d.setTransform(staticMover.getTransform());
		} else if (moverDes.equals("bounce")) {
			g2d.setTransform(bounceOffMover.getTransform());
		}
		
		if (padDes.equals("fill")) {
			g2d.fill(shape);
		}
		
		g2d.draw(shape);
 	}
	
	public void update() {
		if (moverDes.equals("linear")) {
			linearMover.update();
		} else if (moverDes.equals("static")) {
			staticMover.update();
		} else if (moverDes.equals("bounce")) {
			bounceOffMover.update();
		}
 	}
	
	//takes a PrintWriter that saves a text-based description of the shape
	public void save(PrintWriter pw) {
		if (shape instanceof Ellipse2D) {
			if (radius != 0) {
				pw.print("circle ");
				pw.print((((Ellipse2D)shape).getBounds2D().getWidth()) + " ");
				pw.print((((Ellipse2D)shape).getBounds2D().getX()) + " ");
				pw.print((((Ellipse2D)shape).getBounds2D().getY()) + " ");	
			} else {
				pw.print("ellipse ");
				pw.print((((Ellipse2D)shape).getBounds2D().getWidth()) + " ");
				pw.print((((Ellipse2D)shape).getBounds2D().getHeight()) + " ");
				pw.print((((Ellipse2D)shape).getBounds2D().getX()) + " ");
				pw.print((((Ellipse2D)shape).getBounds2D().getY()) + " ");
			}
		} else if (shape instanceof Rectangle2D) {
			pw.print("rectangle ");
			pw.print((((Rectangle2D)shape).getBounds2D().getWidth()) + " ");
			pw.print((((Rectangle2D)shape).getBounds2D().getHeight()) + " ");
			pw.print((((Rectangle2D)shape).getBounds2D().getX()) + " ");
			pw.print((((Rectangle2D)shape).getBounds2D().getY()) + " ");
		} 
		
		if (materialDes.equals("default")) {
			defaultMaterial.save(pw);
		} else if (materialDes.equals("color")) {
			colorMaterial.save(pw);
		}
		
		if (padDes.equals("fill")) {
			pw.print("fill ");
		} else if (padDes.equals("outline")) {
			pw.print("outline ");
		}
		
		if (moverDes.equals("linear")) {
			linearMover.save(pw);
		} else if (moverDes.equals("static")) {
			staticMover.save(pw);
		} else if (moverDes.equals("bounce")) {
			bounceOffMover.save(pw);
		}
	}
}
