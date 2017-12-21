import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CustomShapePanel extends JPanel {
	
	JComboBox comboBox;
	JSpinner spinnerX;
	JSpinner spinnerY;
	JSpinner spinnerW;
	JSpinner spinnerH;
	
	private String shapeDes;
	private String positionDes;
	private String dimensionDes;

	public CustomShapePanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 1, true), "Shpae Custom", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(12, 32, 199, 129);
		setLayout(null);
		
		setShape();
		setInitPosition();
		setDimension();
		setSelectBtn();
		
		shapeDes = "";
		positionDes = "";
		dimensionDes = "";
	}
	
	public void setShape() {
		
		comboBox = new JComboBox();
		comboBox.setBounds(15, 25, 90, 25);
		add(comboBox);
		
		comboBox.addItem("circle");
		comboBox.addItem("rectangle");
		comboBox.addItem("ellipse");
		comboBox.setSelectedItem(null);
		
	}
	
	
	public void setInitPosition() {
		
		JLabel label_x = new JLabel("x :");
		label_x.setBounds(43, 64, 57, 15);
		add(label_x);
		
		spinnerX = new JSpinner();
		spinnerX.setBounds(60, 58, 40, 26);
		add(spinnerX);
		
		JLabel label_y = new JLabel("y :");
		label_y.setBounds(136, 64, 57, 15);
		add(label_y);
		
		spinnerY = new JSpinner();
		spinnerY.setBounds(153, 58, 40, 26);
		add(spinnerY);
	}
	
	public void setDimension() {
		
		JLabel label_width = new JLabel("width :");
		label_width.setBounds(17, 102, 57, 15);
		add(label_width);
		
		spinnerW = new JSpinner();
		spinnerW.setBounds(60, 96, 40, 26);
		add(spinnerW);
		
		JLabel label_height = new JLabel("height :");
		label_height.setBounds(107, 102, 57, 15);
		add(label_height);
		
		spinnerH = new JSpinner();
		spinnerH.setBounds(153, 96, 40, 26);
		add(spinnerH);
	}
	
	public void setSelectBtn() {
		JButton shapeBtn = new JButton("Select");
		shapeBtn.setBounds(132, 24, 61, 27);
		shapeBtn.setToolTipText("select ");
		shapeBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		shapeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				shapeDes = (String)comboBox.getSelectedItem() + " ";
				if (shapeDes.equals("circle ")) {
					dimensionDes = spinnerH.getValue() + " ";
				} else {
					dimensionDes = spinnerW.getValue() + " " + spinnerH.getValue() + " ";
				}
				positionDes = spinnerX.getValue() + " " + spinnerY.getValue() + " ";
				System.out.println(shapeDes + dimensionDes + positionDes);
			}
		});
		add(shapeBtn);
	}
	
	public String getCustomShapeDes() {
		return (shapeDes + dimensionDes + positionDes);
	}
	
}
