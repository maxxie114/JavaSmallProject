import javax.swing.*;
/**
 * This is the about window of the game
 * 
 * @author Max
 * 
 * @version 4.0
 * 
 * */
public class HelpWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	JLabel developer;
	JLabel date;
	JLabel version;
	JLabel checkForUpdate;

	public HelpWindow() {
		JFrame frame = new JFrame();
		frame.setResizable(false);

		frame.setLayout(null);

		developer = new JLabel();
		developer.setText("<html>Developer: Max X</html>");
		developer.setLocation(0,10);
		developer.setSize(300,15);

		date = new JLabel();
		date.setText("<html>release date: 7.27.2016</html>");
		date.setLocation(0,30);
		date.setSize(300,15);

		version = new JLabel();
		version.setText("<html>Version: V4.0.0</html>");
		version.setLocation(0,50);
		version.setSize(300,15);
		
		checkForUpdate = new JLabel();
		checkForUpdate.setText("<html>Check for update: You already have the newest version</html>");
		checkForUpdate.setLocation(0,70);
		checkForUpdate.setSize(400,15);
		
		frame.add(developer);
		frame.add(date);
		frame.add(version);
		frame.add(checkForUpdate);

		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.setSize(400, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setTitle("about");

	}
}
