import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class register implements ActionListener
{
	JLabel l1, l2, l3, l4;
    JTextField tf1, tf2, tf3;
    JButton b1, b2;
    JPasswordField p1;
	register()
	{
		JFrame f=new JFrame("REGISTRATION FORM");
		l1 = new JLabel("Name:");
        l2 = new JLabel("Email-Id:");
        l3 = new JLabel("Create Passowrd:");
		l4=new JLabel("Pone number");
		tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        tf3 = new JTextField();
		b1 = new JButton("Submit");
        b2 = new JButton("Clear");
		l1.setBounds(80, 70, 200, 30);
       l2.setBounds(80, 110, 200, 30);
      l3.setBounds(80, 150, 200, 30);
       l4.setBounds(80, 190, 200, 30);
      tf1.setBounds(300, 70, 200, 30);
      tf2.setBounds(300, 110, 200, 30);
      p1.setBounds(300, 150, 200, 30);
      tf3.setBounds(300, 190, 200, 30);
	  b1.setBounds(50, 350, 100, 30);
	  b1.addActionListener(this);
      b2.setBounds(170, 350, 100, 30);
	  b2.addActionListener(this);
	  f.add(l1);
	  f.add(l2);
	  f.add(l3);
	  f.add(l4);
	  f.add(tf1);
	  f.add(tf2);
	  f.add(p1);
	    f.add(tf3);
	
	  f.add(b1);
	  f.add(b2);
	
	   f.setSize(500,500);    
       f.setLayout(null);    
        f.setVisible(true);    


	}
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==b1)
			{
				String username;
				String pass;
				String phone;
			   String email;
				username=tf1.getText();
				pass=p1.getText();
				email=tf2.getText();
				phone=tf3.getText();
					try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","girish9440");
					Statement st= con.createStatement();
					PreparedStatement pst=con.prepareStatement("insert into register values(?,?,?,?)");
						pst.setString(1,username);
					     pst.setString(2,pass);
					     pst.setString(3,phone);
					     pst.setString(4,email);
						 pst.executeUpdate();
						 JOptionPane.showMessageDialog(b1,"SUCCESFULLY REGISTERED");
				}
				 catch(SQLException|ClassNotFoundException ez)
					{
							 System.out.println(ez);
					}
					}
					}

	public static void main(String args[])
		{
			new register();
		}
}