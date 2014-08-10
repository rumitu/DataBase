import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class loginForm extends JFrame {

	public static void main(String[] args) {
		loginForm frameTabel = new loginForm();
	}

	JLabel welcome = new JLabel("Welcome to database!");
	JPanel panel = new JPanel();

	loginForm(){
		super("Welcome");
		setSize(300,200);
		setLocation(500,280);
		panel.setLayout (null); 

		welcome.setBounds(70,50,150,60);

		panel.add(welcome);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}

}
