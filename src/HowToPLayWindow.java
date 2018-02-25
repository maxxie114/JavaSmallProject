import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
/**
 * This is the how to play documentation of the game
 * 
 * @author Max
 * 
 * @version 4.0
 * 
 * copied: 0%
 * 
 * */
public class HowToPLayWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	// private static final long serialVersionUID = 1L;
	//private static final int width = 760;
	//private static final int height = 500;
	private JTextArea howToPlay;
	private JScrollPane scroll;

	public HowToPLayWindow() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setResizable(true);

		// frame.setLayout(null);

		howToPlay = new JTextArea();

		howToPlay.setText("HOW TO PLAY THE GAME.\n" 
				+ "1. Go to settings, choose \"set Maximum number\"\n"
				+ "2. set maximum number and click \"set\" \n\r"
				+ "3. go back to the game, click restart, type in a NUMBER! And click guess to guess.\n\r"
				+ "4. if you don't want to delete all the number, you can also press F2 to automatically clear screen. \n"
				+ "5. Enjoy the game!\n\n" 
				+ "HOW TO RESTART THE GAME\n"
				+ "When you can't guess the number, you can simply restart the game.\n"
				+ "1. Click the restart button, or press F1, the game will automatically restart.\n"
				+ "2. The number will automatically change. And you will be able to play it again.\n\n"
				+ "HOW TO GIVE UP PLAYING\n"
				+ "To give up playing, you can go to settings and click give up, or press F3\n"
				+ "The game will stop and show you the answer, if you want to play again, click restart.\n\n"
				+ "HOW TO USE GAME KILLER(THE FEATURE THAT HELP YOU AUTOMATICALLY FINISH THE GAME)\n"
				+ "1. To use game killer, go to settings, and select game killer. (or press F5)\n"
				+ "2. Type in 1176392100 as a password in the new textfield, and click the submit button\n"
				+ "4. Wait for it to guess the number, and you will finally get the answer.\n"
				+ "5. If you want to play it again, click restart.\n\n"
				+ "HOW TO SET MAXUMUM NUMBER\n"
				+ "If you think the number(default number : 1000) is not big enough, you can actually set the maximum number yourself.\n"
				+ "1. Go to settings --> set maximum number, a new space will appear in the applet. \n"
				+ "2. Type in a integer number (smaller or equal to 1,000,000,000) and click set.\n"
				+ "3. The panel will disappear, and you will see that the number is reset to your maximum number.\n"
				+ "4. Attention: after the game window is closed, your maximum number will not be save, that means next time, it will set everything to default.");
		howToPlay.setEditable(false);

		scroll = new JScrollPane(howToPlay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scroll);
		panel.setLayout(new GridLayout(1, 0 ,5 ,5));
		
		//frame.setSize(width, height);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setTitle("How to play");
		frame.pack();

	}
}
