import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CustomColorPanel extends JPanel{

	private Color color;
	private String colorDes;
	
	public CustomColorPanel() {
		setBounds(12, 257, 199, 146);
		setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 1, true), "Color Custom", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		
		addDefaultColorBtn();
		addRandomColorBtn();
		addColorPickerBtn();
		addBlinkingColorBtn();
		
		colorDes = "";
	}
	
	public void addDefaultColorBtn() {
		
		JLabel defaultLabel = new JLabel("Default");
		defaultLabel.setBounds(38, 63, 57, 15);
		add(defaultLabel);
		
		JButton defaultBtn = new JButton("");
		defaultBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorDes = "default ";
			}
		});
		defaultBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/color_default.png"));
		defaultBtn.setBounds(38, 20, 38, 38);
		add(defaultBtn);
	}
	
	public void addBlinkingColorBtn() {
		
		JLabel blinkingLabl = new JLabel("Blink");
		blinkingLabl.setBounds(122, 63, 57, 15);
		add(blinkingLabl);
		
		JButton blinkingBtn = new JButton("");
		blinkingBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/color_random.png"));
		blinkingBtn.setBounds(122, 20, 38, 38);
		blinkingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				colorDes = "blink ";
			}
		});
		add(blinkingBtn);
	}
	
	public void addColorPickerBtn() {
		
		JLabel pickerLabel = new JLabel("Picker");
		pickerLabel.setBounds(38, 126, 57, 15);
		add(pickerLabel);
		
		JButton colorPickerBtn = new JButton("");
		colorPickerBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/color_picker.png"));
		colorPickerBtn.setBounds(38, 87, 38, 38);
	    colorPickerBtn.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
	           Color shapeColor = JColorChooser.showDialog(null,
	               "Choose shape color", Color.BLACK);
	           if(shapeColor != null) {
	            	    colorDes = "color ";
	                color = shapeColor;
	           }
	         }
	      });
		add(colorPickerBtn);
	}
	
	public void addRandomColorBtn() {
		
		JLabel randomLabel = new JLabel("Random");
		randomLabel.setBounds(122, 126, 57, 15);
		add(randomLabel);
		
		JButton randomBtn = new JButton("");
		randomBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/color_preview.png"));
		randomBtn.setBounds(122, 87, 38, 38);
		randomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				colorDes = "random ";
			}
		});
		add(randomBtn);
	}
	
	public String getCustomColorDes() {
		String customColorDes = "";
		if (colorDes.equals("color ")) {
			customColorDes = colorDes + (color.getRed() * 1.0 / 255.0)  + " " + (color.getGreen() * 1.0 / 255.0) + " " + (color.getBlue() * 1.0 / 255.0) + " ";
		} else if (colorDes.equals("default ") || colorDes.equals("blink ") || colorDes.equals("random ")) {
			customColorDes = colorDes;
		} 
		System.out.println(customColorDes);
		return customColorDes;
	}
}
