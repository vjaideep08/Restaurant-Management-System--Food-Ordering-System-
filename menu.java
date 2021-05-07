import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class menu implements ActionListener
{
	JCheckBox cb1,cb2,cb3,cb4,cb5,cb6;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
	JButton b1;
	JLabel l1,l2,l3;
	menu()
	{
		JFrame f=new JFrame();
		l1=new JLabel("MENU");
		l2=new JLabel("QUANTITY");
		l3=new JLabel("PRICE");
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		tf6=new JTextField();
		tf7=new JTextField("120");
		tf8=new JTextField("100");
		tf9=new JTextField("20");
		tf10=new JTextField("50");
		tf11=new JTextField("35");
		tf12=new JTextField("50");
		cb1=new JCheckBox("Pizza ");  
         cb2=new JCheckBox("Burger");  
           cb3=new JCheckBox("Tea");  
          cb4=new JCheckBox("Coffee");
		cb5=new JCheckBox("Pepsi");
		cb6=new JCheckBox("Maggie");
		b1=new JButton("ORDER");
		cb1.setBounds(80, 70, 200, 30);
        cb2.setBounds(80, 110, 200, 30);
        cb3.setBounds(80, 150, 200, 30);
       cb4.setBounds(80, 190, 200, 30);
       cb5.setBounds(80, 230, 200, 30);
        cb6.setBounds(80, 270, 200, 30);
		l1.setBounds(80,30,200,30);
		l2.setBounds(300,30,200,30);
		l3.setBounds(500,30,200,30);
		
		tf1.setBounds(300,70,200,30);
		tf2.setBounds(300,110,200,30);
		tf3.setBounds(300,150,200,30);
		tf4.setBounds(300,190,200,30);
		tf5.setBounds(300,230,200,30);
		tf6.setBounds(300,270,200,30);
		tf7.setBounds(500,70,200,30);
		tf8.setBounds(500,110,200,30);
		tf9.setBounds(500,150,200,30);
		tf10.setBounds(500,190,200,30);
		tf11.setBounds(500,230,200,30);
		tf12.setBounds(500,270,200,30);
		b1.setBounds(170,340,150,20);
		b1.addActionListener(this);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		
		f.add(tf1);
		   f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);f.add(tf6);
		   f.add(tf7); f.add(tf8); f.add(tf9); f.add(tf10); f.add(tf11); f.add(tf12);f.add(b1);
		    f.add(cb1);
		   f.add(cb2); f.add(cb3); f.add(cb4); f.add(cb5); f.add(cb6);
		f.setSize(1000,1000);
		f.setLayout(null);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		if(ae.getSource()==b1)
		{
	    int n;
		int amt=0;
		String msg="";
		String pizza=cb1.getText();
	     String burger=cb2.getText();
		String tea=cb3.getText();
		String coffee=cb4.getText();
		String pepsi=cb5.getText();
		String maggie=cb6.getText();
	     String s1=tf1.getText();
		String s2=tf2.getText();
		String s3=tf3.getText();
		String s4=tf4.getText();
		String s5=tf5.getText();
		String s6=tf6.getText();
		String s7=tf7.getText();
		String s8=tf8.getText();
		String s9=tf9.getText();
		String s10=tf10.getText();
		String s11=tf11.getText();
		String s12=tf12.getText();
		int a=Integer.parseInt(s1);  
        int b=Integer.parseInt(s2);
		int c=Integer.parseInt(s3);
		int d=Integer.parseInt(s4);  
		int e=Integer.parseInt(s5);
		int f=Integer.parseInt(s6);  
		int g=Integer.parseInt(s7);  
		int h=Integer.parseInt(s8);  
		int i=Integer.parseInt(s9);  
		int j=Integer.parseInt(s10);  
		int k=Integer.parseInt(s11);  
		int l=Integer.parseInt(s12);  
			   Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","girish9440");
					Statement st= con.createStatement();
					PreparedStatement pst=con.prepareStatement("insert into orderdetails values(?,?)");

					if(cb1.isSelected())
			{
                 amt+=(g*a);
                  msg="Pizza:"+amt;
				  }
				  if(cb2.isSelected())
					  {
					  amt+=(h*b);
					  msg+="Burger:"+amt;
					  }
					  if(cb3.isSelected())
						  {
						  amt+=(i*c);
						  msg+="Tea:"+amt;
						  }
						  if (cb4.isSelected())
						  {
							  amt+=(j*d);
							  msg+="Coffee:"+amt;
						  }
						  if(cb5.isSelected())
		                     {
							     amt+=(k*e);
								 msg+="pepsi:"+amt;
		                     }
							 if(cb6.isSelected())
		                         {
								    amt+=(l*f);
									msg+="Maggie:"+amt;
		                         }
								 pst.setString(1,msg);
								 pst.setInt(2,amt);
								 
									
									pst.executeUpdate();
								 msg+="\n";
									
	JOptionPane.showMessageDialog(b1,msg+"Total: "+amt);
	payment p=new payment();
		}
	}
	catch(SQLException|ClassNotFoundException fe)
		{
		System.out.println(fe);
		}
	}
	public static void main(String args[])
	{
		new menu();
	}
}