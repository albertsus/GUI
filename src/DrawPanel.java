import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawPanel extends JPanel {

	private Scene scene;
	Color backgroundColor;
	public DrawPanel(Scene scene) {
		this.scene = scene;
		setLayout(null);
		setBounds(242, 5, scene.getSceneWidth() + 50, scene.getSceneHeight() + 147);
		
		backgroundColor = Color.LIGHT_GRAY;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(backgroundColor);
		g2d.fillRect(0, 0, scene.getSceneWidth() + 50, scene.getSceneHeight() + 147);
		scene.draw(g2d);

	}
}
