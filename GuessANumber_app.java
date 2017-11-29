import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * This is the main class of the whole application
 * 
 * @author Max
 * @version 4.0
 * 
 *          copied : 20% main code copied from:
 *          http://codereview.stackexchange.com/questions/48856/guess-my-number-game-in-java-swing
 */
public class GuessANumber_app extends JFrame implements KeyListener {

	JFrame frame = new JFrame();

	private static final long serialVersionUID = 1L;

	// Declare
	private int maxi;
	private int num;
	private int count;
	private String score;

	private static final int ROWS = 5;
	private static final int COLS = 0;
	private static final int V_GAP = 20;
	private static final int H_GAP = 0;
	Random rnd;
	JTextField textfieldInput, password, setMaximumTextfield, scoreTextfield, countTextfield;
	JLabel headLine, gameTitle, outputLabel, killerLabel, setMaximumLabel;
	Button1Listener bl1;
	Button2Listener bl2;
	Button3Listener bl3;
	Button4Listener bl4;
	KillerKeyListener key;
	MaximumKeyListener maxKey;
	JButton inputButton, resetButton, killerButton, setMaximumButton;
	JMenuItem close, giveUp, shortcuts, howToPlay, about, killer, setMaxi;
	JPanel left, right;
	ScoreCalculater s;

	// constructor
	public GuessANumber_app() {
		maxi = 1000;
		num = 0;
		count = 0;
		score = "";
	}

	// set random numbers
	public void toGuessANumber() {
		rnd = new Random();
		//num = 1 + rnd.nextInt(maxi);
		 num = 315;
		// This is only for testing
		// initialize JFrane component
		s = new ScoreCalculater();
		JPanel area = new JPanel();
		JPanel buttonArea = new JPanel();
		left = new JPanel();
		right = new JPanel();
		Dimension buttonAreaDimension = new Dimension(700, 50);
		// Create label "guess the number"
		headLine = new JLabel("<html><font color = blue>GUESS THE NUMBER<color></html>", SwingConstants.CENTER);
		// headLine.setForeground(Color.BLUE);
		headLine.setFont(new Font("Rockwell", Font.BOLD, 40));

		// Create label "please enter a number..."
		gameTitle = new JLabel("<html>Guess a number,bigger than 1,\nsmaller than " + maxi + "</html>",
				SwingConstants.CENTER);
		gameTitle.setForeground(Color.RED);
		gameTitle.setFont(new Font("tunga", Font.BOLD, 30));

		// create label"too big, or too small"
		outputLabel = new JLabel(" ", SwingConstants.CENTER);
		outputLabel.setForeground(Color.BLACK);
		outputLabel.setFont(new Font("tunga", Font.BOLD, 30));
		// outputLabel.setLayout(new FlowLayout(FlowLayout.LEADING));
		// create textField for input
		textfieldInput = new JTextField();
		textfieldInput.setFont(new Font("tunga", Font.BOLD, 30));

		textfieldInput.setEditable(true);
		textfieldInput.addKeyListener(this);
		textfieldInput.addKeyListener(this);
		// textfieldInput.setBackground();

		// create textField for showing the score
		scoreTextfield = new JTextField(SwingConstants.LEFT);
		scoreTextfield.setForeground(Color.RED);
		scoreTextfield.setBackground(Color.WHITE);
		scoreTextfield.setText("your score: " + score);
		scoreTextfield.setEditable(false);
		// create textField for showing the count
		countTextfield = new JTextField(SwingConstants.RIGHT);
		countTextfield.setForeground(Color.RED);
		countTextfield.setBackground(Color.WHITE);
		countTextfield.setText("time of guess: " + "0");
		countTextfield.setEditable(false);

		// create label for killer operation
		killerLabel = new JLabel();
		killerLabel.setVisible(false);

		// add a textField to enter password
		password = new JTextField(10);
		password.setVisible(false);
		key = new KillerKeyListener();
		password.addKeyListener(key);
		// set button 1
		inputButton = new JButton("<html>guess it</html>");
		inputButton.setForeground(Color.BLACK);
		inputButton.setFont(new Font("tunga", Font.BOLD, 30));
		bl1 = new Button1Listener();
		inputButton.addActionListener(bl1);
		// set button 2
		resetButton = new JButton("<html>restart game</html>");
		resetButton.setForeground(Color.BLACK);
		resetButton.setFont(new Font("tunga", Font.BOLD, 30));
		bl2 = new Button2Listener();
		resetButton.addActionListener(bl2);

		// set button 3
		killerButton = new JButton("submit");
		killerButton.setForeground(Color.BLACK);
		killerButton.setFont(new Font("tunga", Font.BOLD, 20));
		killerButton.setVisible(false);
		bl3 = new Button3Listener();
		killerButton.addActionListener(bl3);

		// add a label for the setMaximum operation
		setMaximumLabel = new JLabel();
		setMaximumLabel.setText(
				"<html><b><font color = red><font size = 3><b>Please type in the maximum number here.</font></font></b></html>");
		setMaximumLabel.setVisible(false);

		// add a button for the setMaximum operation
		setMaximumButton = new JButton("<html><font size = 5><b>set</b></font></html>");
		setMaximumButton.setVisible(false);
		bl4 = new Button4Listener();
		setMaximumButton.addActionListener(bl4);

		// add a textField for the setMaximum operation
		setMaximumTextfield = new JTextField(10);
		setMaximumTextfield.setVisible(false);
		maxKey = new MaximumKeyListener();
		setMaximumTextfield.addKeyListener(maxKey);

		// add components into the JPanel

		area.add(countTextfield);
		area.add(scoreTextfield);
		area.add(gameTitle);
		area.add(textfieldInput);
		area.add(outputLabel);
		area.setLayout(new GridLayout(ROWS, COLS, H_GAP, V_GAP));
		area.setBackground(Color.WHITE);
		area.setBorder(new LineBorder(Color.BLACK, 2));
		buttonArea.setLayout(new GridLayout(1, 2, 8, 8));
		buttonArea.setPreferredSize(buttonAreaDimension);
		buttonArea.setMaximumSize(buttonAreaDimension);
		buttonArea.setMinimumSize(buttonAreaDimension);
		buttonArea.add(resetButton);
		buttonArea.add(inputButton);
		left.add(killerLabel);
		left.add(password);
		left.add(killerButton);
		right.add(setMaximumLabel);
		right.add(setMaximumTextfield);
		right.add(setMaximumButton);
		// create a box
		// This is the main code for keeping middle
		// add components into the box
		frame.add(area, BorderLayout.CENTER);
		frame.add(buttonArea, BorderLayout.SOUTH);
		frame.add(left, BorderLayout.WEST);
		frame.add(right, BorderLayout.EAST);
		// place components into the pane
		// set up some JMenu
		JMenuBar menu = new JMenuBar();
		// set up some MenuBars
		JMenu menuList1 = new JMenu("settings");
		JMenu menuList2 = new JMenu("help");
		// set up Menu Item in each of them
		// Exit the application
		close = new JMenuItem("close");
		close.addActionListener(new CloseListener());
		// show the answer in outputLabel
		giveUp = new JMenuItem("give up");
		giveUp.addActionListener(new GiveUpListener());
		/*
		 * // open a window that show all key shortcut in a form shortcuts = new
		 * JMenuItem("change difficulty"); shortcuts.addActionListener(new
		 * ShortcutListener());
		 */
		// open a window that prompt the user for maximum number
		setMaxi = new JMenuItem("set maximum number");
		setMaxi.addActionListener(new MaxListener());
		// open a window that show the information of how to play
		howToPlay = new JMenuItem("how to play");
		howToPlay.addActionListener(new HowToListener());
		// open a window that show the version and developer detail in a form
		about = new JMenuItem("about");
		about.addActionListener(new AboutListener());
		// run a program that automatically play the game
		killer = new JMenuItem("game killer");
		killer.addActionListener(new KillerListener());

		// add everything into the MenuList1
		menuList1.add(giveUp);
		menuList1.add(close);
		menuList1.add(setMaxi);
		menuList1.add(killer);
		// menuList1.add(shortcuts);
		// add everything into the MenuList2
		menuList2.add(howToPlay);
		menuList2.add(about);
		// add everything into the menuBar
		menu.add(menuList1);
		menu.add(menuList2);
		// set size, title,center the frame
		frame.setJMenuBar(menu);
		frame.setTitle("GUESS A NUMBER V3.0");
		frame.setSize(1000, 600);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.pack();
	}

	// details of b1, bl1
	public class Button1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Long a = Long.parseLong(textfieldInput.getText());

				// please do not change all the if statement anymore.

				if (a > num + 500 && a <= maxi) {
					outputLabel.setText(
							"<html>Wow, that" + " " + a + " " + "is toooooooo big,  Put a smaller one!</html>");
				} else if (a >= maxi) {
					outputLabel.setText("<html>hey, do you know that the number is smaller than" + maxi + "?</html>");
				} else if (a <= num - 500 && a > 0) {
					outputLabel.setText(
							"<html>Oh, that" + " " + a + " " + "is toooooooo small,  Put a bigger one!</html>");
				} else if (a > num - 100 && a < num - 10) {
					outputLabel.setText("<html>wow, keep going, you are almost there ! just make it bigger ! </html>");
				} else if (a < num + 100 && a > num + 10) {
					outputLabel.setText("<html>wow, keep going, you are almost there ! just make it smaller !</html>");
				} else if (a >= num - 10 && a < num) {
					outputLabel.setText("<html>So close! ten more ! Make it bigger! </html>");
				} else if (a <= num + 10 && a > num) {
					outputLabel.setText("<html>So close! ten more ! Make it smaller! </html>");
				} else if (a > num - 500 && a > 0 && a < num) {
					outputLabel.setText("<html>" + a + " " + "is still very small!</html>");
				} else if (a < num + 500 && a > num) {
					outputLabel.setText("<html>" + a + " " + "is still very BIG!</html>");
				} else if (a <= 0) {
					outputLabel.setText("<html>Oh, come on, don't give a negative number! </html>");

				} else if (a == num) {
					int c1 = count / 2 ;
					s.setScore(c1 , num);
					score = s.scoreCalculation();
					outputLabel.setText("<html>Oh! You got it! Congradulation!</html>");
					scoreTextfield.setText("your score: " + score + "");
					textfieldInput.setEditable(false);

				}
				// System.out.println(num);
				
				count++;
				countTextfield.setText("time of guess: " + (count / 2) + "");
				
				//System.out.println(count);

			} catch (

			Exception e1) {
				outputLabel.setText("<html>You should have type a number (smaller than " + maxi + " ) !</html>");
			}

		}
	}

	// details of b2, bl2
	private class Button2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textfieldInput.setEditable(true);
			num = 1 + rnd.nextInt(maxi);
			outputLabel.setText("");
			textfieldInput.setText("");
			gameTitle.setText("<html>Guess a number,bigger than 1,\nsmaller than  " + maxi + "</html>");
			count = 0;
			score = " N / A";
			countTextfield.setText("time of guess: " + count + "");
			scoreTextfield.setText("your score: " + score + "");
		}

	}

	// the submit listener
	class Button3Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				int i = 0;
				String b = password.getText();
				if (b.equals("1176392100")) {
					new PleaseWaitWindow();
					if (num < 100000) { // This if statement prevent the out of
										// memory exception to happen
						while (i != num) {
							i++;
							textfieldInput.setText(i + "");
							// System.out.println(i);
							// Only for testing
						}
					} else {
						textfieldInput.setText(num + "");
					}
					inputButton.doClick();
					password.setText(null);
					killerButton.setVisible(false);
					password.setVisible(false);
					killerLabel.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Password.", "Attention", 1);
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Invalid input.", "Attention", 1);
			}
			left.setLayout(null);
		}
	}

	class Button4Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				int max = Integer.parseInt(setMaximumTextfield.getText());
				setMaximum(max);
				JOptionPane.showMessageDialog(null, "you have alredy set the maximum number");
				setMaximumTextfield.setVisible(false);
				setMaximumButton.setVisible(false);
				setMaximumLabel.setVisible(false);
				setMaximumTextfield.setText(null);
				right.setLayout(null);
				resetButton.doClick();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"<html><b><font color = red>Invalid Input</font></b><br>There are two possibility:<br><font color = blue>1. You did not enter a number.</font><br><font color = green> 2. The number you entered is too long.</font></br></br></br></html>",
						"Attention", 1);
			}

		}
	}

	// add key shortcuts for the game killer
	private class KillerKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				killerButton.doClick();
			} else if (e.getKeyCode() == KeyEvent.VK_F6) {
				password.setText(null);
				killerButton.setVisible(false);
				password.setVisible(false);
				killerLabel.setVisible(false);
				left.setLayout(null);
			}
		}

		public void keyTyped(KeyEvent e) {

		}
	}

	// add key shortcuts for the set maximum operation
	private class MaximumKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				setMaximumButton.doClick();
			}
		}

		public void keyTyped(KeyEvent e) {

		}
	}

	private class CloseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class AboutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new HelpWindow();
		}
	}

	private class GiveUpListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			gameTitle.setText("you lose.");
			outputLabel.setText("The answer is:" + num);
			textfieldInput.setEditable(false);
			textfieldInput.setText("");

		}
	}

	private class HowToListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new HowToPLayWindow();

		}
	}

	private class MaxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setMaximumTextfield.setVisible(true);
			setMaximumButton.setVisible(true);
			setMaximumLabel.setVisible(true);
			right.setLayout(new GridLayout(10, 0, 0, 0));
		}
	}

	/*
	 * private class ShortcutListener implements ActionListener { public void
	 * actionPerformed(ActionEvent e) {
	 * 
	 * }
	 * 
	 * }
	 */

	private class KillerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			killerLabel.setText(
					"<html><font color = Red ><font size = 3><b>to use this feature, you have to <br>enter a password.(press F6 to<br>quit)</b></font></font></br></html>");
			killerButton.setVisible(true);
			password.setVisible(true);
			killerLabel.setVisible(true);
			left.setLayout(new GridLayout(9, 0, 3, 3));
		}
	}

	// set keyListener guess, restart(F1) , clear screen(F2)
	public void keyPressed(KeyEvent e) {
		//if (e.getKeyChar() == KeyEvent.KEY_PRESSED) {
			
		//}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			inputButton.doClick();

		} else if (e.getKeyCode() == KeyEvent.VK_F1) {
			resetButton.doClick();

		} else if (e.getKeyCode() == KeyEvent.VK_F2) {
			textfieldInput.setText("");
		} else if (e.getKeyCode() == KeyEvent.VK_F3) {
			 //new HowToPLayWindow();
		} else if (e.getKeyCode() == KeyEvent.VK_F5) {
			killer.doClick();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	// methods
	/**
	 * methods that change the maximum number to the user input number
	 *
	 * @param maximum
	 *            the maximum number the user put in
	 */
	public void setMaximum(int max) {
		maxi = max;
	}

}
