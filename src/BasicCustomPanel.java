import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class BasicCustomPanel extends JPanel {
	
	Scene scene;
	Scanner scanner;
	DrawPanel drawPanel;
	
	public BasicCustomPanel(Scene scene, DrawPanel drawPanel) {
		this.scene = scene;
		this.drawPanel = drawPanel;
		setBorder(new LineBorder(Color.GRAY, 1, true));
		setBounds(8, 6, 230, 117);
		setLayout(null);
		
		addTitle();
		addShape();
		addSavedImage();
	}
	
	public void addTitle() {
		JLabel basicLabel = new JLabel("BASIC CUSTOMIZATION");
		basicLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		basicLabel.setBounds(28, 0, 182, 38);
		add(basicLabel);
	}
	
	public void addSavedImage() {
		JLabel saveImgLabel = new JLabel("Save Image : ");
		saveImgLabel.setBounds(16, 45, 96, 16);
		add(saveImgLabel);
		addSavedBtn();
	}
	
	public void addSavedBtn() {
		JButton saveBtn = new JButton("");
		saveBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/save.png"));
		saveBtn.setToolTipText("save image");
		saveBtn.setBounds(93, 38, 52, 30);
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				BufferedImage image = new BufferedImage(scene.getSceneWidth(), scene.getSceneHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D g2d = image.createGraphics();
				drawPanel.paint(g2d);
				try {
					ImageIO.write(image, "png", new File("SavedImage"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		add(saveBtn);
	}
	
	public void addShape() {
		JLabel addLabel = new JLabel("Add Shape :");
		addLabel.setBounds(16, 87, 80, 16);
		add(addLabel);
		
		JTextField shapeTextField = new JTextField();
		shapeTextField.setBounds(93, 80, 86, 30);
		add(shapeTextField);
		shapeTextField.setColumns(10);
		
		addShapeBtn(shapeTextField);
	}
	
	public void addShapeBtn(JTextField shapeTextField) {
		JButton shapeButton = new JButton("");
		shapeButton.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/addingImage.png"));
		shapeButton.setToolTipText("add shape");
		shapeButton.setBounds(180, 80, 40, 32);
		shapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Scanner scanner = new Scanner(shapeTextField.getText());
				try {
					SceneObject sceneObject = new SceneObject(scanner);
					scene.soList.add(sceneObject);
				} catch (UnknownMaterialException | UnknownShapeException | UnknownMoverException
						| UnknownPadException e) {
					JOptionPane.showMessageDialog(null,"Invalid Shape Description");
					e.printStackTrace();
				}
			}
		});
		add(shapeButton);
	}
	
}
