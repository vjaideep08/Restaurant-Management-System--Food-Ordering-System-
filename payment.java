import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class payment implements ActionListener 
{
	JRadioButton rb1,rb2,rb3;
	JLabel l1;

	JButton b1;
	payment()
	{
		JFrame f=new JFrame("payment ");
		l1=new JLabel("PAYMENT GATEWAY");
		rb1=new JRadioButton("CASH");
        rb2=new JRadioButton("CARD");
	   b1=new JButton("PROCCED TO PAY");
		l1.setBounds(120,10,200,30);
		rb1.setBounds(50,40,200,30);
        rb2.setBounds(50,70,200,30);
	   b1.setBounds(80,140,200,30);
		b1.addActionListener(this);
        f.setSize(500,500);
		f.setVisible(true);
		f.setLayout(null);
		f.add(rb1);
		f.add(rb2);
		f.add(b1);
		f.add(l1);
		}
		public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==b1)
		{
				if(rb1.isSelected())
					{    
                            JOptionPane.showMessageDialog(b1,"Payment Succesful and Order Received");    
							}    
                 else if(rb2.isSelected())
					 {    
					 JOptionPane.showMessageDialog(b1,"Payment Succesful and Order Received");    
					 }    
					 else
			{
						 JOptionPane.showMessageDialog(b1,"Select Any One Payment Method"); 

			}

			}
					
		
		}
			
		public static void main(String args[])
	{
			payment p=new payment();
	}
}