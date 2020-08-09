//Programe to Checking Login Validation: i.e. For SignUp and SignIn
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class pass extends JFrame implements ActionListener
{ 
	//Declare Variables
	JTextField txtId;
	JPasswordField txtPass;
	JLabel lblID, lblPass, lblHead, lblExists, lblNew;
	Font font, font1;
	Container c;
	JOptionPane op;
	JButton btnClose, btnSignUp, btnSignIn, btnChange;

	public pass(String title)
	{
		super(title);
		c= getContentPane();
		font = new Font("Courier", Font.BOLD, 18);
		font1 = new Font("Courier", Font.BOLD, 14);

		//Add Head Label
		lblHead = new JLabel("******Login Window******");
		lblHead.setBounds(270,50,300,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);


		//Add Lable
		lblExists = new JLabel("Existing User");
		lblExists.setBounds(50,110,300,20);
		lblExists.setForeground(new Color(255,255,100));
		lblExists.setFont(font);
		c.add(lblExists);

		lblID = new JLabel("User ID : ");
		lblID.setBounds(150,150,300,20);
		lblID.setForeground(new Color(255,255,100));
		lblID.setFont(font);
		c.add(lblID);

		lblPass = new JLabel("Password : ");
		lblPass.setBounds(150,190,300,20);
		lblPass.setForeground(new Color(255,255,100));
		lblPass.setFont(font);
		c.add(lblPass);

		lblNew = new JLabel("New User??????? Just Click Here For Registration!");
		lblNew.setBounds(50,300,600,120);
		lblNew.setForeground(new Color(255,255,100));
		lblNew.setFont(font1);
		c.add(lblNew);


		//Add SignUp Button
		btnSignUp = new JButton("SignUP");
		btnSignUp.setBounds(400,400,80,30);
		btnSignUp.setForeground(Color.black);
		btnSignUp.setActionCommand("insert");
		btnSignUp.setMnemonic('U');
		//getRootPane().setDefaultButton(btnSignUp);
		btnSignUp.addActionListener(this);
		btnSignUp.setToolTipText("Click Here to Continue");
		c.add(btnSignUp);

		//Add SignIn Button
		btnSignIn = new JButton("SignIN");
		btnSignIn.setBounds(300,250,80,30);
		btnSignIn.setForeground(Color.black);
		btnSignIn.setActionCommand("exists");
		btnSignIn.setMnemonic('S');
		getRootPane().setDefaultButton(btnSignIn);
		btnSignIn.addActionListener(this);
		btnSignUp.setToolTipText("Click Here to Continue");
		c.add(btnSignIn);

		//Add Change Password Button
		btnChange = new JButton("Change Password");
		btnChange.setBounds(600,250,150,30);
		btnChange.setForeground(Color.black);
		btnChange.setActionCommand("update");
		btnChange.setMnemonic('C');
		//getRootPane().setDefaultButton(btnChange);
		btnChange.addActionListener(this);
		btnChange.setToolTipText("Click Here to Change Password");
		c.add(btnChange);

		//Add Close Button
		btnClose = new JButton("Close");
		btnClose.setBounds(400,250,80,30);
		btnClose.setForeground(Color.black);
		btnClose.setActionCommand("close");
		//getRootPane().setDefaultButton(btnClose);
		btnClose.addActionListener(this);
		btnClose.setToolTipText("Click Here to Close");
		c.add(btnClose);


		//Add UserID TextField
		txtId = new JTextField();
		txtId.setBounds(330,150,150,30);
		txtId.setFont(font1);
		txtId.setText(null);
		c.add(txtId);

		//Add Password TextField
		txtPass = new JPasswordField();
		txtPass.setBounds(330,190,150,30);
		txtPass.setFont(font1);
		txtPass.setText(null);
		c.add(txtPass);

		//Set Background and Layout
		c.setBackground(new Color(0,0,80));
		c.setLayout(null);
		c.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,600);
		show();
	}

	public void actionPerformed(ActionEvent e)
	{
		Connection con = null;
		PreparedStatement ps = null;
		DBConn conn = new DBConn();
		String userId = txtId.getText();
		String password = txtPass.getText();
		if("update".equals(e.getActionCommand()))
		{
			new change("change password");
		}
		else if("insert".equals(e.getActionCommand()))
		{
			new newuserpass("New User Registration");
		}
		else if("close".equals(e.getActionCommand()))
		{
			System.exit(0);
		}
		else if("exists".equals(e.getActionCommand()))
		{
			if(userId.equals(""))
			{
				op.showMessageDialog(c,"Enter User ID");
			}
			else if(password.equals(""))
			{
				op.showMessageDialog(c,"Enter Password");
			}
			else
			{
				try
				{
					con = conn.getConnection();
					ps = con.prepareStatement("Select userID, pass From Login Where (userID = ?) And (pass = ?)");
					ps.setString(1,userId);
					ps.setString(2,password);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						// getNextId(lgoinID,Login);			
						String _userId = rs.getString("userID");
						String _password = rs.getString("pass");
						if(userId.equalsIgnoreCase(_userId) && password.equalsIgnoreCase(_password))
						{
							op.showMessageDialog(c,"Access Granted");
							txtId.setText("");
							txtPass.setText("");
							new main("Main Form");
							setVisible(false);

						}
						else
						{
							op.showMessageDialog(c,"Access Denied");
							txtId.setText("");
							txtPass.setText("");
						}
					}
					else
					{		  
						op.showMessageDialog(c,"Access Denied");
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
		else if("update".equals(e.getActionCommand()))
		{
			if(txtId.getText().length() < 0)
			{
				op.showMessageDialog(c,"Enter User ID");
			}
			else if(txtPass.getText().length() < 0)
			{
				op.showMessageDialog(c,"Enter Password");
			}
			else
			{
				try
				{
					con = conn.getConnection();
					ps = con.prepareStatement("Select userID, pass From Login Where (userID = ?) And (pass = ?)");
					ps.setString(1,txtId.getText());
					ps.setString(2,txtPass.getText());
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						if(txtId.getText().equals(rs.getString(1)) && txtPass.equals(rs.getString(2)))
						{
							op.showMessageDialog(c,"Access Granted");
							txtId.setText("");
							txtPass.setText("");
							setVisible(false);
							new change("Change Password");
						}
						else
						{
							op.showMessageDialog(c,"Access Denied");
							txtId.setText("");
							txtPass.setText("");
						}
					}
					else
					{
						op.showMessageDialog(c,"Access Denied");
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
	}
	public static void main(String[] args)
	{
		new pass("Lgoin Window");
	}
}

