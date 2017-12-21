import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Scene {
	
	public static int sceneWidth;
	public static int sceneHeight;
	
	public ArrayList<SceneObject> soList;
		
	//constructor that takes a Scanner a parameter 
	public Scene(Scanner scanner) throws UnknownMaterialException, UnknownShapeException, UnknownMoverException, UnknownPadException {
		sceneWidth = scanner.nextInt();
		sceneHeight = scanner.nextInt();
		soList = new ArrayList<SceneObject>();
		while (scanner.hasNextLine()) {
			SceneObject so = new SceneObject(scanner);
			soList.add(so);
		}
	}
	
	//draw the shape object stored in arrayList
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < soList.size(); i++) {
			soList.get(i).draw(g2d);
		}
	}
	
	public void update() {
		for (int i = 0; i < soList.size(); i++) {
			soList.get(i).update();
		}
	}
	
	//takes a PrintWriter that saves a text-based description of the scene
	public void save(PrintWriter pw) throws FileNotFoundException {
		pw.println(sceneWidth + " " + sceneHeight);
	}
	
	public int getSceneWidth() {
		return sceneWidth;
	}
	
	public int getSceneHeight() {
		return sceneHeight;
	}
	
}
