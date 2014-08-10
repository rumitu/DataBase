import javax.swing.*;

import java.awt.event.*;
import java.sql.*;


public class registrationForm extends JFrame{

	public static void main(String[] args) {
		registrationForm frameTabel = new registrationForm();

	}
	JTextField firstnameTxt = new JTextField(25);     
	JTextField secondnameTxt = new JTextField(25); 
	JTextField titleTxt = new JTextField(25); 
	JTextField userNameTxt = new JTextField(25); 
	JPasswordField passTxt = new JPasswordField(25);  
    JLabel firstnameLbl = new JLabel("First name: ");  
    JLabel secondnameLbl = new JLabel("Second name: ");  
    JLabel titleLbl = new JLabel("Title: ");
    JLabel userNameLbl = new JLabel("Username: ");
    JLabel passLbl = new JLabel("Password: "); 
    JButton bsubmit= new JButton("Submit");
	JPanel panel = new JPanel();

    
	registrationForm(){
		super("Registration");
		setSize(500,280);
		setLocation(500,280);
		panel.setLayout (null); 

		firstnameLbl.setBounds(70,30,150,20);
		firstnameTxt.setBounds(155,30,230,20);
		secondnameLbl.setBounds(70,65,150,20);
		secondnameTxt.setBounds(155,65,230,20);
		titleLbl.setBounds(70,100,150,20);
		titleTxt.setBounds(155,100,230,20);		
		userNameLbl.setBounds(70,135,150,20);
		userNameTxt.setBounds(155,135,230,20);
		passLbl.setBounds(70,170,150,20);
		passTxt.setBounds(155,170,230,20);
		bsubmit.setBounds(240,200,80,20);

		
		panel.add(firstnameLbl);  
	    panel.add(firstnameTxt);  
	    panel.add(secondnameLbl);  
	    panel.add(secondnameTxt); 
	    panel.add(titleLbl);  
	    panel.add(titleTxt);
	    panel.add(userNameLbl);  
	    panel.add(userNameTxt);
	    panel.add(passLbl);  
	    panel.add(passTxt);
	    panel.add(bsubmit);
	    
	    // Summit button
	    ButtonSumbit sumbit = new ButtonSumbit();
	    bsubmit.addActionListener(sumbit);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	class ButtonSumbit implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			String value1=firstnameTxt.getText();
			String value2=secondnameTxt.getText();
			String value3=titleTxt.getText();
			String value4=userNameTxt.getText();
			String value5=passTxt.getText();
			
			Connection con = null;
			String url = "jdbc:mysql://localhost/";
			String db = "project";
			String driver = "com.mysql.jdbc.Driver";
			String user = "root";
			String pass = "rumi";
			System.out.println(value1+value2+value3+value4+value5);
			try{
				Class.forName(driver);
				con = DriverManager.getConnection(url+db, user, pass);
				PreparedStatement st=con.prepareStatement("insert into users(firstname,lastname,title,username, password) values(?,?,?,?,?)");
				st.setString(1,value1);
				st.setString(2,value2);
				st.setString(3,value3);
				st.setString(4,value4);
				st.setString(5,value5);
				st.executeUpdate();
				JOptionPane.showMessageDialog(panel,"Data is successfully inserted into database.");
				con.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(panel,"Error in submitting data!");
			}
		}
	}

}
