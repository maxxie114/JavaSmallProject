//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class SetMaximumWindow extends JFrame {
//	private static final long serialVersionUID = 1L;
//	// private int a;
//	JLabel maxi, enter, enter1;
//	JTextField inputTextField;
//	JButton confirm;
//	ButtonListener b1;
//
//	public SetMaximumWindow() {
//		JFrame frame = new JFrame();
//		// initial JFrame components
//		maxi = new JLabel();
//		maxi.setText("SET MAXIMUM");
//		maxi.setForeground(Color.BLUE);
//		maxi.setFont(new Font("Rockwell", Font.BOLD, 25));
//		maxi.setSize(300,20);
//		maxi.setLocation(140,0);
//
//		enter = new JLabel();
//		enter.setText("please enter the maximum number.");
//		enter.setForeground(Color.RED);
//		enter.setFont(new Font("Rockwell", Font.BOLD, 20));
//		enter.setSize(400,20);
//		enter.setLocation(90,20);
//		
//		enter1 = new JLabel();
//		enter1.setText("");
//		enter1.setForeground(Color.RED);
//		enter1.setFont(new Font("Rockwell", Font.BOLD, 20));
//		enter1.setSize(500,20);
//		enter1.setLocation(10,90);
//		
//		inputTextField = new JTextField(10);
//		inputTextField.setFont(new Font("Rockwell", Font.BOLD, 15));
//		inputTextField.setEditable(true);
//		inputTextField.setSize(300,40);
//		inputTextField.setLocation(100,40);
//
//		confirm = new JButton("confirm");
//		confirm.setForeground(Color.BLACK);
//		confirm.setFont(new Font("Rockwell", Font.BOLD, 30));
//		b1 = new ButtonListener();
//		confirm.addActionListener(b1);
//		confirm.setSize(300,60);
//		confirm.setLocation(100,150);
//
//		// add all components into frame
//		frame.add(maxi);
//		frame.add(enter);
//		frame.add(enter1);
//		frame.add(inputTextField);
//		frame.add(confirm);
//		// initial JFrame detail
//		frame.setSize(500, 300);
//		frame.setLayout(null);
//		frame.setLocationRelativeTo(null);
//		frame.setResizable(false);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
//		//frame.pack();
//	}
//
//	public class ButtonListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			try {
//				int a = Integer.parseInt(inputTextField.getText());
//				enter1.setText("you have set the maximum number");
//				inputTextField.setEditable(false);
//			} catch (Exception e1) {
//				enter1.setText("please enter a number( smaller than 10,000,000).");
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		new SetMaximumWindow();
//	}
//
//}
