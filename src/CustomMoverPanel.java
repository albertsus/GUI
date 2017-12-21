import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CustomMoverPanel extends JPanel {
	
	private String moverDes;
	private String positionDes;
	private String velocityDes;
	
	JSpinner spinner_x;
	JSpinner spinner_y;
	JSpinner spinner_vx;
	JSpinner spinner_vy;
	
	public CustomMoverPanel() {
		setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 1, true), "Mover Custom", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setBounds(12, 415, 199, 153);
		setLayout(null);
		
		setInitPosition();
		setVelocity();
		setStaticBtn();
		setLinearBtn();
		setBounceBtn();
		
		moverDes = "";
		positionDes= "";
		velocityDes = "";
	}
	
	public void setInitPosition() {
		
		JLabel start_x = new JLabel("x :");
		start_x.setBounds(30, 31, 57, 15);
		add(start_x);
		
		spinner_x = new JSpinner();
		spinner_x.setBounds(47, 25, 40, 26);
		add(spinner_x);
		
		JLabel start_y = new JLabel("y :");
		start_y.setBounds(120, 31, 57, 15);
		add(start_y);
		
		spinner_y = new JSpinner();
		spinner_y.setBounds(137, 25, 40, 26);
		add(spinner_y);
	}
	
	public void setVelocity() {
		
		JLabel vx = new JLabel("vx :");
		vx.setBounds(19, 69, 57, 15);
		add(vx);
		
		spinner_vx = new JSpinner();
		spinner_vx.setBounds(47, 63, 40, 26);
		add(spinner_vx);
		
		JLabel vy = new JLabel("vy :");
		vy.setBounds(109, 69, 57, 15);
		add(vy);
		
		spinner_vy = new JSpinner();
		spinner_vy.setBounds(137, 63, 40, 26);
		add(spinner_vy);
	}
	
	public void setStaticBtn() {
		
		JLabel staticLabel = new JLabel("Static");
		staticLabel.setBounds(30, 131, 46, 15);
		add(staticLabel);
		
		JButton staticBtn = new JButton("");
		staticBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/StaticIcon.png"));
		staticBtn.setBounds(29, 96, 40, 36);
		staticBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				moverDes = "static ";
				positionDes = spinner_x.getValue() + " " + spinner_y.getValue() + " ";
				System.out.println(moverDes + positionDes + velocityDes);			}
		});
		add(staticBtn);
	}
	
	public void setLinearBtn() {
		JLabel linearLabel = new JLabel("Linear");
		linearLabel.setBounds(79, 131, 46, 15);
		add(linearLabel);
		
		JButton linearBtn = new JButton("");
		linearBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/linear.png"));
		linearBtn.setBounds(81, 96, 40, 36);
		linearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				moverDes = "linear ";
				positionDes = spinner_x.getValue() + " " + spinner_y.getValue() + " ";
				velocityDes = spinner_vx.getValue() + " " + spinner_vy.getValue() + " ";
				System.out.println(moverDes + positionDes + velocityDes);
			}
		});
		add(linearBtn);
	}
	
	public void setBounceBtn() {
		
		JLabel bounceLabel = new JLabel("Bounce");
		bounceLabel.setBounds(137, 131, 46, 15);
		add(bounceLabel);
		
		JButton bounceBtn = new JButton("");
		bounceBtn.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/bounce.png"));
		bounceBtn.setBounds(137, 96, 40, 36);
		bounceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				moverDes = "bounce ";
				positionDes = spinner_x.getValue() + " " + spinner_y.getValue() + " ";
				velocityDes = spinner_vx.getValue() + " " + spinner_vy.getValue() + " ";
				System.out.println(moverDes + positionDes + velocityDes);
			}
		});
		add(bounceBtn);
	}
	
	public String getCustomMoverDes() {
		System.out.println(moverDes + positionDes + velocityDes);
		return (moverDes + positionDes + velocityDes);
	}
}
