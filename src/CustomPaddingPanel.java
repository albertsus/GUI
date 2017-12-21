import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CustomPaddingPanel extends JPanel {

	private final ButtonGroup buttonGroup;
	private String paddingDes;
	
	public CustomPaddingPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 1, true), "Padding Custom", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(12, 173, 199, 72);
		setLayout(null);
		
		buttonGroup = new ButtonGroup();
		setPaddingBtn();
		setSelectBtn();
		
		paddingDes = "";
	}
	
	public void setPaddingBtn() {
		
		JRadioButton outlineRadioBtn = new JRadioButton("Outline");
		outlineRadioBtn.setBounds(26, 20, 82, 18);
		add(outlineRadioBtn);
		buttonGroup.add(outlineRadioBtn);
		
		JRadioButton fillRadioBtn = new JRadioButton("Fill");
		fillRadioBtn.setBounds(26, 41, 62, 18);
		add(fillRadioBtn);
		buttonGroup.add(fillRadioBtn);
	}
	
	public void setSelectBtn() {
		
		JButton selectBtn = new JButton("Select");
		selectBtn.setBounds(132, 37, 61, 27);
		selectBtn.setToolTipText("select");
		selectBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while (bg.hasMoreElements()) {
					JRadioButton jrd = (JRadioButton) bg.nextElement();
					if (jrd.isSelected()) {
						paddingDes = jrd.getLabel();
					}
				}
		    }
		});
		add(selectBtn);
	}
	
	public String getCustomPaddingDes() {
		
		if (paddingDes.equals("Outline")) {
			System.out.println(paddingDes);
			return "outline ";
		} 
		System.out.println(paddingDes);
		return "fill ";
	}
}
