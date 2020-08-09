//Programe to Change Password
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class change extends JFrame implements ActionListener
{
	//Declare Variables
  	JTextField txtId;
  	JPasswordField txtPass, txtNew;
  	JLabel lblId, lblPass, lblNew, lblHead;
  	Font font,font1;
  	JButton btnClose, btnChange;
  	JOptionPane op;
  	Connection con=null;
  	ResultSet rs=null;
  	PreparedStatement ps;
  	Container c;

  	public change(String title)
  	{
		super(title);
		c=getContentPane();
		font = new Font("Courier",Font.BOLD, 18);
		font1 = new Font("Courier",Font.BOLD, 14);
	
		//Add Head Lable
		lblHead = new JLabel("!!!!!!Change Password!!!!!!");
		lblHead.setBounds(200,50,400,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);
	
		//Add ID Label
		lblId = new JLabel("Enter User ID : ");
		lblId.setBounds(50,150,700,20);
		lblId.setForeground(new Color(255,255,100));
		lblId.setFont(font);
		c.add(lblId);

		//Add Password Label
		lblPass = new JLabel("Enter Old Password : ");
		lblPass.setBounds(50,200,700,20);
		lblPass.setForeground(new Color(255,255,100));
		lblPass.setFont(font);
		c.add(lblPass);
	
		//Add New Password Label
		lblNew = new JLabel("Enter New Password : ");
		lblNew.setBounds(50,250,700,20);
		lblNew.setForeground(new Color(255,255,100));
		lblNew.setFont(font);
		c.add(lblNew);

		//Add userID TextField
		txtId = new JTextField();
		txtId.setBounds(300,150,150,30);
		txtId.setFont(font1);
		txtId.setText(null);
		c.add(txtId);
	
		//Add Old Password TextField
		txtPass = new JPasswordField();
		txtPass.setBounds(300,200,150,30);
		txtPass.setFont(font1);
		txtPass.setText(null);
		c.add(txtPass);

		//Add New Password TextField
		txtNew = new JPasswordField();
		txtNew.setBounds(300,250,150,30);
		txtNew.setFont(font1);
		txtNew.setText(null);
		c.add(txtNew);

		//Add Close Button
		btnClose = new JButton("Close");
		btnClose.setBounds(400,350,80,40);
		btnClose.setForeground(Color.black);
		btnClose.setActionCommand("close");
		btnClose.addActionListener(this);
		btnClose.setToolTipText("Click Here to Close");
		c.add(btnClose);
	
		//Add Change Password Button
		btnChange = new JButton("Change Password");
		btnChange.setBounds(150,350,150,40);
		btnChange.setForeground(Color.black);
		btnChange.setActionCommand("change");
		btnChange.addActionListener(this);
		btnChange.setToolTipText("Click Here to Change Password");
		btnChange.setMnemonic('C');
		c.add(btnChange);
		getRootPane().setDefaultButton(btnChange);
		
		//Set Background and Layout
		c.setBackground(new Color(0,0,80));
		c.setLayout(null);
		c.setVisible(true);
		setSize(800,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		show();
		
  	}
  	public void actionPerformed(ActionEvent e)
  	{
		DBConn conn = new DBConn();
		String userID = txtId.getText();
		String password = txtPass.getText();
		if("change".equals(e.getActionCommand()))
		{
			if(txtId.getText().equals(""))
		  	{
				op.showMessageDialog(c,"Enter User ID");
			}
		  	else if(txtPass.getText().equals(""))
		  	{
				op.showMessageDialog(c,"Enter Password");
		  	}
		  	else if(txtNew.getText().equals(""))
		  	{
				op.showMessageDialog(c,"Enter New Password");
		  	}	
		  	else if(txtPass.getText().equals(txtNew.getText()))
		  	{
				op.showMessageDialog(c,"Password Match  : Plz Change New Password");
		  	}
		  	else
		  	{
				try
				{
			  		con = conn.getConnection();
			  		ps = con.prepareStatement("Select userID, pass From Login Where (userID = ?) And (pass = ?)");
			  		ps.setString(1,userID);
			  		ps.setString(2,password);
			  		ResultSet rs = ps.executeQuery();
			  		if(rs.next())
			  		{
	
			  			String _userID = rs.getString("userID");
			  			String _password = rs.getString("pass");
						if(userID.equalsIgnoreCase(_userID) && password.equalsIgnoreCase(_password))
						{
				  			op.showMessageDialog(c,"Access Granted");
				  			ps = con.prepareStatement("UPDATE Login Set pass=? Where(userID=?) And(pass=?)");
				  			ps.setString(1,txtNew.getText());
				  			ps.setString(2,txtId.getText());
				  			ps.setString(3,txtPass.getText());
				  			if(ps.executeUpdate() !=0)
				  			{
								op.showMessageDialog(c,"Password Changed");
				  				txtId.setText("");
			 					txtPass.setText("");
								txtNew.setText("");
				  				setVisible(false);
				  				new main("Main Form");
	
						  	}
				  			else
				  			{
								op.showMessageDialog(c,"Password Not Changed, Plz Try Agina");
								txtId.setText("");
				 				txtPass.setText("");
								txtNew.setText("");
				  			}
						}
						else
			  			{
							op.showMessageDialog(c,"Enter Valid User ID And Password");
							txtId.setText("");
							txtPass.setText("");
			  			}
			  		}
			  		else
			  		{
						op.showMessageDialog(c,"Enter Valid User ID And Password");
						txtId.setText("");
						txtPass.setText("");
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
			//Exit the Form
			this.hide();
		}
  	}
  	public static void main(String[] args)
  	{
		new change("Change Password");
  	}
}

	
