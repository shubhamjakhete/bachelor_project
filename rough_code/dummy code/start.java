//Programe to : Start Form
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class start extends JFrame implements ActionListener
{
  	Container c;
  	ImageIcon ic;
  	JLabel lblLogo;
  	Font font;
  	JButton btncon, btnclose;
  	public start(String title)
  	{
		super(title);
		c= getContentPane();
		font = new Font("Courier",Font.BOLD,20);
	
		//Add Lables
		JLabel lblHead = new JLabel("!!!! WELCOME !!!!");
		lblHead.setBounds(300,0,500,200);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);

		lblLogo = new JLabel("Sairam", new ImageIcon("sai.jpg"), JLabel.CENTER);
		lblLogo.setVerticalTextPosition(JLabel.TOP);
		lblLogo.setBounds(100,130,600,300);
		lblLogo.setHorizontalTextPosition(JLabel.CENTER);
		c.add(lblLogo);

		//Add Conitnue Button
		btncon = new JButton("Continue");
		btncon.setForeground(Color.black);
		btncon.setBounds(300,450,100,30);
		btncon.setActionCommand("con");
		btncon.setMnemonic('C');
		getRootPane().setDefaultButton(btncon);
		btncon.addActionListener(this);
		c.add(btncon);
	
		//Add Close Button
		btnclose = new JButton("Close");
		btnclose.setForeground(Color.black);
		btnclose.setBounds(500,450,80,30);
		btnclose.setActionCommand("close");
		btncon.setMnemonic('C');
		btnclose.addActionListener(this);
		c.add(btnclose);

		//Set Background and Layout
		c.setBackground(new Color(0,0,80));
		c.setLayout(null);
		c.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,800);
		show();
	
  	}
  	public static void main(String[] args)
  	{
		new start("Welcome To Appoitment Schedule");
  	}
  	public void actionPerformed(ActionEvent e)
  	{
		if("con".equals(e.getActionCommand()))
		{
			new pass("Welcome");
			setVisible(false);
		}
		else if("close".equals(e.getActionCommand()))
		{
			setVisible(false);
		}
  	}
}
