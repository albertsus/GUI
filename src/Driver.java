import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Driver {

	//create/load scene from a file and draw it
	public static void main(String[] args) {
		Scanner fileReader = null;
		PrintWriter pw = null;
		try {
			
			fileReader = new Scanner(new FileInputStream("input.txt"));
			Scene scene = new Scene(fileReader);
			System.out.println("scene width: " + scene.getSceneWidth());
			System.out.println("scene height: " + scene.getSceneHeight());
			createWindow window = new createWindow(scene);
			
			//save text description to file
			pw = new PrintWriter("output.txt");
			scene.save(pw);
			for (int i = 0; i < scene.soList.size(); i++) {
				scene.soList.get(i).save(pw);
				pw.println();
			}
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnknownShapeException e) {
			e.printStackTrace();
		} catch (UnknownMaterialException e) {
			e.printStackTrace();
		} catch (UnknownMoverException e) {
			e.printStackTrace();
		} catch (UnknownPadException e) {
			e.printStackTrace();
		}
	}
}
