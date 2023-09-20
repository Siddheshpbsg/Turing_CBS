package com.cbs.pages;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

class Branch
{
	private JFrame frame = new JFrame("Branch");
	public Branch()
	{
		frame=new JFrame("Branch");
        frame.setSize(400,200);
        frame.setLocation(400,200);
        JButton button1 = new JButton("Branch_User");
        button1.setBounds(100,50,150,40);
        frame.add(button1); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        frame.setVisible(true);
        button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//frame.dispose();
				new CRM();
			}
		});  
	}
}

class Customer_creation
{
	private JFrame frame = new JFrame("Customer");
	public Customer_creation()
	{
		frame=new JFrame("Customer Creation");
		frame.setSize(450,300);
        frame.setLocation(400,200);
		String[] TestCases = {"Select","Create New Individual Customer", "Edit New Individual Customer", "View New Individual Customer", 
							  "Edit Migrated Individual Customer","View Migrated Individual Customer"};
		final JComboBox<String> jComboBox = new JComboBox<String>(TestCases);
        jComboBox.setBounds(80,50,250,30);
        frame.add(jComboBox);
        JButton jButton = new JButton("Run TestCase");
        jButton.setBounds(100,100,120,20);
        frame.add(jButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        frame.setVisible(true);
        
        jButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String TestCaseSelection = jComboBox.getItemAt(jComboBox.getSelectedIndex());
                //  String TestCaseSelection = "You selected " +  jComboBox.getItemAt(jComboBox.getSelectedIndex());
                //jLabel.setText(selectedFruit);
            }
        });
	}
}

class CRM  
{
	private JFrame frame = new JFrame("CRM");
	public CRM()
	{
		frame=new JFrame("Customer Creation");
        frame.setSize(400,200);
        frame.setLocation(400,200);
        JButton button1 = new JButton("Create Customer");
        button1.setBounds(100,50,150,30);
        frame.add(button1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        frame.setVisible(true);
        button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//frame.dispose();
				new Customer_creation();
			}
		}); 
        
        /*JButton button2 = new JButton("Non-Indv Customer");
        button2.setBounds(150,20,130,40);
        frame.add(button1); 
        frame.add(button2); */
        
	}
}

public class Turing_CBS extends javax.swing.JFrame
{
	JFrame frame;
	Image img = Toolkit.getDefaultToolkit().getImage("C:\\Siddhesh Training Document\\Signature\\img.jpg");
	Graphics g;
	Turing_CBS() throws IOException
    {
		frame=new JFrame("Turing_CBS");
        frame.setSize(600,400);
        frame.setLocation(400,200);
        JButton button1 = new JButton("CRM");
        button1.setBounds(10,20,120,40);
        JButton button2 = new JButton("CASA");
        button2.setBounds(150,20,120,40);
        JButton button3 = new JButton("TD & Bulk TD");
        button3.setBounds(300,20,120,40);
        JButton button4 = new JButton("Loan & CC");
        button4.setBounds(450,20,120,40);
        JButton button5 = new JButton("CASH");
        button5.setBounds(10,80,120,40);
        JButton button6 = new JButton("Transfer");
        button6.setBounds(150,80,120,40);
        JButton button7 = new JButton("Teller");
        button7.setBounds(300,80,120,40);
        JButton button8 = new JButton("Outward");
        button8.setBounds(450,80,120,40);
        JButton button9 = new JButton("Inward");
        button9.setBounds(10,140,120,40);
        JButton button10 = new JButton("Balance");
        button10.setBounds(150,140,120,40);
        JButton button11 = new JButton("Locker");
        button11.setBounds(300,140,120,40);
        JButton button12 = new JButton("Chequebook");
        button12.setBounds(450,140,120,40);
        JButton button13 = new JButton("TD Module");
        button13.setBounds(10,200,120,40);
        //add button on frame
        frame.add(button1); 
        frame.add(button2);
        frame.add(button3);                                     
        frame.add(button4);
        frame.add(button5);                                      
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button10);
        frame.add(button11);
        frame.add(button12);
        frame.add(button13);
        frame.setLayout(null);                                   // uses no layout managers
        frame.setVisible(true);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button1);
        button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				//frame.dispose();
				new Branch();
			}
		});  
    }	
	public static void main(String[] args) throws Exception
    {
        new Turing_CBS();
    }
}


/*JButton button1 = new JButton("Ho_User");
button1.setBounds(70,30,120,40);         //setBounds(int x-coordinate, int y-coordinate, int width, int height)
JButton button2 = new JButton("Branch_User");
button2.setBounds(250,30,120,40);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // setting close operation
frame.add(button1);                                      //add button on frame
frame.add(button2);
frame.setLayout(null);                                   // uses no layout managers
frame.setVisible(true);   
//frame.setLocation(400,200);                               // makes the frame visible

/* this.setContentPane(new JFrame()
{
	public void paintComponent(Graphics g)
    {
       super.paintComponents(g);
       g.drawImage(img, 0, 0, null);
    }
 });  
pack();
setVisible(true);*/











