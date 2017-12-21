import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ColorMaterial implements Material<ColorMaterial> {

	//have a member variable storing the object's color and draw the object the appropriate color
	float r, g, b;
	Color color;
	public ColorMaterial(Scanner scanner) {
		r = scanner.nextFloat();
		g = scanner.nextFloat();
		b = scanner.nextFloat();
		color = new Color(r, g, b);
	}
	
	public ColorMaterial() {
		Random rand = new Random();
		r = rand.nextFloat();
		g = rand.nextFloat();
		b = rand.nextFloat();
		color = new Color(r,g, b);
	}
	
	public ColorMaterial(Color color) {
		this.color = color;
	}
	
	@Override
	public void setupGraphics(Graphics2D g2d) {
		g2d.setColor(color);
	}
	
	public void save(PrintWriter pw) {
		pw.print("color " + r + " " + g + " " + b + " ");
	}
}
