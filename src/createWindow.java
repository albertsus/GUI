
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class createWindow extends JFrame {
	
	private JPanel contentPane;
	private int delay;
	Scene scene;
	
	DrawPanel drawPanel;
	BasicCustomPanel basicCustomPanel;
	AdvancedCustomPanel advancedCustomPanel;
	
	public createWindow(Scene scene) {
		super("my window");
		this.scene = scene;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		drawPanel = new DrawPanel(scene);
		contentPane.add(drawPanel);
		
		BasicCustomPanel basicCustomPanel = new BasicCustomPanel(scene, drawPanel);
		contentPane.add(basicCustomPanel);
		
		AdvancedCustomPanel advancedCustomPanel = new AdvancedCustomPanel(scene);
		contentPane.add(advancedCustomPanel);
		
		setBackgroundColor();
		previewBackgroundColor();
		
		update();
		
		setVisible(true);
	
	}
		
	public void update() {
		delay = 10;
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				scene.update();
				drawPanel.repaint();
			}
		};
		new Timer(delay, taskPerformer).start();
	}
	
	public void setBackgroundColor() {
		JButton btnChoose = new JButton("");
		btnChoose.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/colorChoose.png"));
		btnChoose.setBounds(890, 5, 37, 37);
		btnChoose.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
	           Color backgroundColor = JColorChooser.showDialog(null,
	               "Choose shape color", Color.BLACK);
	           if(backgroundColor != null) {
	            	    drawPanel.backgroundColor = backgroundColor;
	           }
	         }
	      });
		add(btnChoose);
	}
	
	public void previewBackgroundColor() {
		JButton btnPreview = new JButton("");
		btnPreview.setIcon(new ImageIcon("/Users/suchaofan/eclipse-workspace/AnimationSystem_Animates/colorPreview.png"));
		btnPreview.setBounds(890, 50, 37, 37);
	    btnPreview.addActionListener(new ActionListener() {
	    	     public void actionPerformed(ActionEvent e) {
	    	  		Window parentWindow = SwingUtilities.windowForComponent(btnPreview);
	    	  		JColorChooser jcc = new JColorChooser();
	    	  		jcc.getSelectionModel().addChangeListener(new ChangeListener() {
	    	  			public void stateChanged(ChangeEvent e) {
	    	  				drawPanel.backgroundColor = jcc.getColor();
	    	  			}
	    	  		});
	    	  		JDialog dialog = new JDialog(parentWindow);
	    	  		dialog.add(jcc);
	    	  		dialog.pack();
	    	  		dialog.setVisible(true);
	    	  	 }
	     });
	     add(btnPreview);
	}
}
