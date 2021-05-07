import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class login implements ActionListener 
{
	JFrame f;
	JTextField tf1;
	JPasswordField pf1;
	JButton b1,b2;
	JLabel l1,l2;
	login()
	{
		f=new JFrame("LOGIN PAGE");
		l1=new JLabel("USERNAME");
		l2=new JLabel("PASSWORD");
		tf1=new JTextField();
		pf1=new JPasswordField();
		b1=new JButton("submit");
		b2=new JButton("register");
		l1.setBounds(50, 150, 100, 30);
        l2.setBounds(50, 220, 100, 30);
        tf1.setBounds(150, 150, 150, 30);
       pf1.setBounds(150, 220, 150, 30);
        b1.setBounds(50, 300, 100, 30);
        b2.setBounds(200, 300, 100, 30);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.add(l1);
		f.add(l2);
		f.add(tf1);
		f.add(pf1);
		f.add(b1);
		f.add(b2);
        f.setSize(500,500);    
        f.setLayout(null);    
         f.setVisible(true);     
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		if (e.getSource() == b1) 
			{
			

            String uname;
            String password;
            uname = tf1.getText();
            password = pf1.getText();
			        Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","girish9440");
					Statement st= con.createStatement();
					PreparedStatement pst=con.prepareStatement("insert into login values(?,?)");
				         pst.setString(1,uname);
					     pst.setString(2,password);
						 pst.executeUpdate();
						 
						 if (uname.equalsIgnoreCase("kaankshi") && password.equalsIgnoreCase("vishal")) 
			{
			   JOptionPane.showMessageDialog(f, "Login Successful");
			   menu m=new menu();
			   
				 }
		   else
				{
                JOptionPane.showMessageDialog(f, "Invalid Username or Password");
				}
				}
			}
			catch(SQLException|ClassNotFoundException cn)
		{
				System.out.println(cn);
		}
	     if (e.getSource() == b2) 
	{
			register r=new register();
	}
	
	

	}
		public static void main(String args[])
		{
			login l=new login();
		}

}