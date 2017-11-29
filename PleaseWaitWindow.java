import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * This is the please wait window of the game
 * 
 * @author Max
 * 
 * @version 4.0
 * 
 * 
 */
public class PleaseWaitWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	JLabel title;
	

	public PleaseWaitWindow() {
		JFrame frame = new JFrame();
		frame.setResizable(false);

		frame.setLayout(null);

		title = new JLabel();
		title.setText("Finished ! so long,finally!");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		title.setLocation(0,10);
		title.setSize(500,30);

		
		
		frame.add(title);
		
		frame.setTitle("Please Wait(it might take a little bit long.)");
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.setSize(600, 300);
		//frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//frame.setTitle("Please wait.");

	}
}
