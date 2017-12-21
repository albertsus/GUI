import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintWriter;
import java.util.Scanner;

public class DefaultMaterial extends ColorMaterial {
	
	public DefaultMaterial() {
		super(Color.BLACK);
	}
	
	public void save(PrintWriter pw) {
		pw.print("default ");
	}
}
