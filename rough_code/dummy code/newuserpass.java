//Programe to New User Registration : i.e. For Signin
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class newuserpass extends JFrame implements ActionListener
{
	//Declare Variables
	  DBConn conn = new DBConn();
	  JTextField txtID;
	  JPasswordField txtPass;
	  JLabel lblID, lblPass, lblWelcome;
	  Font font1,font2;
	  JButton btnClose, btnSign;
	  JOptionPane op;
	  Connection con;
	
	  PreparedStatement ps;
	  Container c;
	  ResultSet rs;
	  public newuserpass(String title)
	  {
		super(title);
		c = getContentPane();
		font1 = new Font("Courier", Font.BOLD, 18);
		font2 = new Font("Courier", Font.BOLD, 14);
	
		//Add welcome label
		lblWelcome = new JLabel("!!!!!!!!WELCOME!!!!!!!!");
		lblWelcome.setBounds(200,90,300,20);
		lblWelcome.setBackground(new Color(255,255,100));
		lblWelcome.setFont(font1);
		c.add(lblWelcome);
		
		//Add UserId Label
		lblID = new JLabel("User ID : ");
		lblID.setBounds(150,150,300,20);
		lblID.setBackground(new Color(255,255,100));
		lblID.setFont(font1);
		c.add(lblID);
	
		//Add Pasword Label
		lblPass = new JLabel("Enter Password");
		lblPass.setBounds(150,190,300,20);
		lblPass.setBackground(new Color(255,255,100));
		lblPass.setFont(font1);
		c.add(lblPass);
	
		//Add UserID Textfield
		txtID = new JTextField();
		txtID.setBounds(330,150,150,30);
		txtID.setFont(font2);
		txtID.setText(null);
		c.add(txtID);
	
		
		//Add pass Password Field
		txtPass = new JPasswordField();
		txtPass.setBounds(330,190,150,30);
		txtPass.setFont(font2);
		txtPass.setText(null);
		c.add(txtPass);
	
		//Add SignUP Button
		btnSign = new JButton("SignUP");
		btnSign.setForeground(Color.black);
		btnSign.setBounds(300,250,80,30);
		btnSign.setActionCommand("click");
		btnSign.setMnemonic('S');
		getRootPane().setDefaultButton(btnSign);
		btnSign.addActionListener(this);
		btnSign.setToolTipText("click Here to SignUP");
		c.add(btnSign);
	
		//Add Close Buttons
		btnClose = new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(400,250,80,30);
		btnClose.setActionCommand("close");
		btnClose.addActionListener(this);
		btnClose.setToolTipText("Click Here to Close");
		c.add(btnClose);
	
		//Auto Generate User ID
/*		try
		{
			con = conn.getConnection();

			ps = con.PreparedStatement("Select MAX(lgoinID) + 1 FROM Login");
			rs = ps.executeQuery();
			while(rs.next())
			{
			//rs.next();
			int lgoinID=rs.getInt(1);
			String s= ("insert into login(LoginID)");
			ps.setString(1,lgoinID);
			}
			con = null;
			rs.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}*/
		
		//Set Background and Layout
		c.setBackground(new Color(0,0,80));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		c.setLayout(null);
		setSize(800,600);
		show();	
  	}
  	public void actionPerformed(ActionEvent e)
  	{

		//Event for SignIN
		if("click".equals(e.getActionCommand()))
		{
	  		String userid = txtID.getText();
	  		String pass = txtPass.getText();
	  		if(userid.length() < 0)
	  		{
				op.showMessageDialog(c,"Enter User ID");
	  		}
	  		else if(pass.length() < 0)
	  		{
				op.showMessageDialog(c,"Enter Password");
	  		}
		  	else
		  	{
				try
				{
					con = conn.getConnection();
			  		ps = con.prepareStatement("INSERT INTO Login(userID, pass) VALUES(?,?)");
			  		ps.setString(1,userid);
			  		ps.setString(2,pass);
			  		if(ps.executeUpdate() != 0)
			  		{
						op.showMessageDialog(c, "WELCOME!, Registration Successful");
						txtID.setText("");
						txtPass.setText("");
						con.commit();
						ps.close();
						con.close();
						setVisible(false);
						new main("Appointment Schedule : Main Form");
			  		}
			  		else
			  		{
						op.showMessageDialog(c, "Sorry, plz Try Again");
						con.commit();
						ps.close();
						con.close();
			  		}
				}
				catch(Exception e1)
				{
			  		e1.printStackTrace();
				}
		  	}
  		}
		else if("close".equals(e.getActionCommand()))
		{
			//Exit the From
			System.exit(0);
		}
	  		
	}
	public static void main(String[] args)
  	{
		new newuserpass("Registration : New Usersss");
  	}	
}
