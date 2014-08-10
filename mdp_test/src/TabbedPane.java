import javax.swing.*;


import java.awt.event.*;
import java.awt.*;  
import java.io.*;
import java.sql.*;
import java.util.*;

public class TabbedPane extends JFrame {
	//and adds the user and pass to the first tab
	JPanel jp1 = new JPanel();//This will create the first tab
    JTextField usernameTxt = new JTextField(25);     
    JPasswordField passwordTxt = new JPasswordField(25);  
    JLabel usernameLbl = new JLabel("Username: ");  
    JLabel passwordLbl = new JLabel("Password: ");  
    JButton loginButton = new JButton("Login");  
    JButton registrationButton= new JButton("Registation");
    JButton cancelButton= new JButton("Cancel");
    
    JPanel jp2 = new JPanel();//This will create the second tab
    JLabel firstnameLbl = new JLabel("First name: ");
    JTextField firstnameTxt = new JTextField(25);
    JLabel lastnameLbl = new JLabel("Last name:");
    JTextField lastnameTxt = new JTextField(26);
    JLabel ageLbl = new JLabel("Age");
    JTextField ageTxt = new JTextField(4);
    JLabel birthdateLbl = new JLabel("Birthdate");
    JTextField birthdateTxt = new JTextField(18);
    JLabel genderLbl = new JLabel("Gender (M,F):");
    JTextField genderTxt = new JTextField(4);
    JLabel emailLbl = new JLabel("Athlete e-mail:");
    JTextField emailTxt = new JTextField(12);
    JLabel heightLbl = new JLabel("Height:" );
    JTextField heightTxt = new JTextField(12);
    JLabel weightLbl = new JLabel("Weight:");
    JTextField weightTxt = new JTextField(12);
    JButton submitButton = new JButton("Submit");
    JButton deleteButton= new JButton("Delete");  
    JButton editButton= new JButton("Edit");
    
    public TabbedPane() {


        //Here we are creating the frame
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       //Here we are creating the object        
        JTabbedPane jtp = new JTabbedPane();
 


       JPanel jp3 = new JPanel();//This will create the third tab       
       JPanel jp4 = new JPanel();//This will create the fourth tab
       JPanel jp5 = new JPanel();//This will create the fifth tab
       JPanel jp6 = new JPanel();//This will create the sixth tab

       
       jp1.add(usernameLbl);  
       jp1.add(usernameTxt);  
       jp1.add(passwordLbl);  
       jp1.add(passwordTxt);
       jp1.add(loginButton);
       jp1.add(registrationButton);
       jp1.add(cancelButton);
       
     //and adds bacis information for athletes to the second tab
       jp2.add(firstnameLbl );
       jp2.add( firstnameTxt );
       jp2.add(lastnameLbl );
       jp2.add( lastnameTxt );
       jp2.add(ageLbl );
       jp2.add( ageTxt );
       jp2.add(birthdateLbl );
       jp2.add( birthdateTxt );
       jp2.add(genderLbl );
       jp2.add( genderTxt );
       jp2.add(emailLbl );
       jp2.add( emailTxt );
       jp2.add(heightLbl );
       jp2.add( heightTxt );
       jp2.add(weightLbl );
       jp2.add( weightTxt );
       
       // add image
       // ImageIcon image = new ImageIcon("C:/Users/Rumito/Desktop/image1.png");
       // picture = new JLabel("Human body 3D", image, JLabel.LEFT);
       //JLabel picture = new JLabel(image);
       //picture.setBounds(300,300,150,60);
       //jp2.add(picture);
       
       
       // Add  Submit button
       submitButton.setBounds(100,150,250,20);
       jp2.add(submitButton);
       ButtonSumbit sumbit = new ButtonSumbit();
       submitButton.addActionListener(sumbit);

       // Add  Delete button
       deleteButton.setBounds(100,150,250,20);
       jp2.add(deleteButton);
       ButtonDelete delete = new ButtonDelete();
       deleteButton.addActionListener(delete);
       
       // Add edit button
       editButton.setBounds(100,150,250,20);
       jp2.add(editButton);
       ButtonEdit edit = new ButtonEdit();
       editButton.addActionListener(edit);
       
       //This adds the all tab to our tabbed pane object and names it

       jtp.addTab("Auth", null, jp1, "This is enable.");
       jtp.addTab("Setup", null, jp2, "This is enable.");
       jtp.addTab("3D live view", null, jp3, "This is enable.");
       jtp.addTab("2D live view - TBD", null, jp4, "This is enable.");
       jtp.addTab("DB - TBD", null, jp5, "This is enable.");
       jtp.addTab("Post analysis - TBD", null, jp6, "This is enable.");
       //jpt.setEnabledAt(1, false); disable tab
       
        //This is an Action Listener which reacts to clicking on

        //the test button called "Login"
        ButtonLogin login = new ButtonLogin();
        loginButton.addActionListener(login);

        //the test button called "Registration"
        ButtonRegistration registration = new ButtonRegistration();
        registrationButton.addActionListener(registration);
        
        //add JTabbedPane into JFrame
        frame.add(jtp);
        
       // set grid layout for the frame
        frame.pack();
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        setResizable(false);
       

    }

    //This is the internal class that defines what the above Action Listener

    //will do event when the login button is pressed.   
    class ButtonLogin implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String puname = usernameTxt.getText();
				String ppaswd = passwordTxt.getText();
				if(puname.equals("test") && ppaswd.equals("12345")) {
					loginForm regFace =new loginForm();
					regFace.setVisible(true);
					dispose();
				} else {

					JOptionPane.showMessageDialog(null,"Wrong Password / Username");
					usernameTxt.setText("");
					passwordTxt.setText("");
					usernameTxt.requestFocus();
				}

			}
	}
	
    //will do event when the registration button is pressed.   
    class ButtonRegistration implements ActionListener{
			public void actionPerformed(ActionEvent e) {				
				registrationForm reg =new registrationForm();
				reg.setVisible(true);
				dispose();				

			}
	}
    
    class ButtonSumbit implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			
			String value1=firstnameTxt.getText();
			String value2=lastnameTxt.getText();
			String value3=ageTxt.getText();
			String value4=birthdateTxt.getText();
			String value5=genderTxt.getText();
			String value6=emailTxt.getText();
			String value7=heightTxt.getText();
			String value8=weightTxt.getText();
			System.out.println(value1);
			System.out.println(value2);
			System.out.println(value3);
			System.out.println(value4);
			System.out.println(value5);
			System.out.println(value6);
			System.out.println(value7);
			System.out.println(value8);
			
			Connection con = null;
			String url = "jdbc:mysql://localhost/";
			String db = "project";
			String driver = "com.mysql.jdbc.Driver";
			String user = "root";
			String pass = "rumi";
			System.out.println(value1+value2+value3+value4+value5+value6+value7+value8);
			try{
				Class.forName(driver);
				con = DriverManager.getConnection(url+db, user, pass);
				PreparedStatement st=con.prepareStatement("insert into setup(firstname,lastname,age,birthdate,gender,email,height,weight) values(?,?,?,?,?,?,?,?)");
				st.setString(1,value1);
				st.setString(2,value2);
				st.setString(3,value3);
				st.setString(4,value4);
				st.setString(5,value5);
				st.setString(6,value6);
				st.setString(7,value7);
				st.setString(8,value8);
				st.executeUpdate();
				JOptionPane.showMessageDialog(jp2,"Data is successfully inserted into database.");
				con.close();
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(jp2,"Error in submitting data!");
			}
		}
	}
    class ButtonDelete implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			firstnameTxt.setText("");
			lastnameTxt.setText("");
			ageTxt.setText("");
			birthdateTxt.setText("");
			genderTxt.setText("");
			emailTxt.setText("");
			heightTxt.setText("");
			weightTxt.setText("");

		}
	}
    class ButtonEdit implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			String value=firstnameTxt.getText();
			Connection con = null;
			String url = "jdbc:mysql://localhost/";
			String db = "project";
			String driver = "com.mysql.jdbc.Driver";
			String user = "root";
			String pass = "rumi";
			try{
				Class.forName(driver);
				con = DriverManager.getConnection(url+db, user, pass);
				PreparedStatement st=con.prepareStatement("select * from setup where firstname=?");
				st.setString(1,value);
				ResultSet res=st.executeQuery();
				res.next();
				firstnameTxt.setText(res.getString(1));
				lastnameTxt.setText(res.getString(2));
				ageTxt.setText(Integer.toString(res.getInt(3)));
				birthdateTxt.setText(Integer.toString(res.getInt(4)));
				genderTxt.setText(res.getString(5));
				emailTxt.setText(res.getString(6));
				heightTxt.setText(Integer.toString(res.getInt(7)));
				weightTxt.setText(Integer.toString(res.getInt(8)));
				con.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(jp2,"Can not edit data");
			}
		}
	}
    public static void main (String []args){

        TabbedPane tab = new TabbedPane();

    }


}


