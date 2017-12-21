import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AdvancedCustomPanel extends JPanel {
	
	Scene scene;
	CustomShapePanel customShapePanel;
	CustomPaddingPanel customPaddingPanel;
	CustomColorPanel customColorPanel;
	CustomMoverPanel customMoverPanel;
	
	public AdvancedCustomPanel(Scene scene) {
		this.scene = scene;
		setBorder(new LineBorder(Color.GRAY, 1, true));
		setBounds(8, 129, 230, 622);
		setLayout(null);
		
		setTitle();
		setLaunchBtn();
		
		customShapePanel = new CustomShapePanel();
		add(customShapePanel);
		
		customPaddingPanel = new CustomPaddingPanel();
		add(customPaddingPanel);
		
		customColorPanel = new CustomColorPanel();
		add(customColorPanel);
		
		customMoverPanel = new CustomMoverPanel();
		add(customMoverPanel);

	}

	public void setTitle() {
		JLabel advancedLabel = new JLabel("ADVANCED CUSTOMIZATION");
		advancedLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		advancedLabel.setBounds(12, 0, 212, 34);
		add(advancedLabel);
	}
	
	public void setLaunchBtn() {
		JButton launchBtn = new JButton("");
		launchBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/launchImg.png"));
		launchBtn.setBounds(86, 572, 50, 44);
		launchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String CustomDes = customShapePanel.getCustomShapeDes() + customColorPanel.getCustomColorDes() +
						customPaddingPanel.getCustomPaddingDes() + customMoverPanel.getCustomMoverDes();
				System.out.println(CustomDes);
				Scanner scanner = new Scanner(CustomDes);
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
		add(launchBtn);
	}
	
}
