//Program to Insert An Contact Details
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class newcontact extends JFrame implements ActionListener, KeyListener
{
	//Declare Variables
	JTextField  txtcid,txtName, txtMobile, txtEmailID;
	JTextArea txtAddress;
	JLabel lblcid,lblAddress, lblSrno, lblName, lblEmailID,lblDate, lblDuration, lblTime, lblLocation, lblMobile, lblWhom1, lblLocation1, lblHead;
	JButton btnClose, btnAdd;
	Font font, font1;
	JOptionPane op;
	Connection con;
	PreparedStatement ps = null;
	Container c;
	public newcontact(String title)
	{
		super(title);
		c = getContentPane();
		font = new Font("Courier", Font.BOLD,18);
		font1 = new Font("Courier", Font.BOLD,14);
		
		//Add Head
		lblHead = new JLabel("!!!!!!!!Contact Entry!!!!!!!!!");
		lblHead.setBounds(200,20,500,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);
		//add cid label
		 lblcid = new JLabel("Enter contact ID: ");
                lblcid.setBounds(30,90,300,20);
                lblcid.setForeground(new Color(255,255,100));
                lblcid.setFont(font);
                c.add(lblcid);
                                                                 
		                                                                 

		
		//Add Person Name Label
		lblName = new JLabel("Enter Person Name : ");
		lblName.setBounds(30,130,300,20);
		lblName.setForeground(new Color(255,255,100));
		lblName.setFont(font);
		c.add(lblName);
		
		//Add Address Label
		lblAddress = new JLabel("Enter Address : ");
		lblAddress.setBounds(30,210,300,20);
		lblAddress.setForeground(new Color(255,255,100));
		lblAddress.setFont(font);
		c.add(lblAddress);
		
		//Add Mobile Number Label
		lblMobile = new JLabel("Enter Mobile No.  : ");
		lblMobile.setBounds(30,251,500,20);
		lblMobile.setForeground(new Color(255,255,100));
		lblMobile.setFont(font);
		c.add(lblMobile);
		
		//Add Email Address Label
		
		lblEmailID= new JLabel("Enter Email Address  :  ");
		lblEmailID.setBounds(30,300,700,20);
		lblEmailID.setForeground(new Color(255,255,100));
		lblEmailID.setFont(font);
		c.add(lblEmailID);


		//add cid textfield
		 txtcid = new JTextField();
                txtcid.setBounds(370,90,200,30);
                txtcid.setFont(font1);
                txtcid.setText(null);
                c.add(txtcid);
                                                                                                

		//Add Name TextField
		txtName = new JTextField();
		txtName.setBounds(370,130,200,30);
		txtName.setFont(font1);
		txtName.setText(null);
		c.add(txtName);
	
		//Add Address TextArea
		txtAddress=new JTextArea("",2,2);
		txtAddress.setLineWrap(true);
		txtAddress.setWrapStyleWord(true);
		txtAddress.setBounds(370,190,200,60);
		txtAddress.setFont(font1);
		txtAddress.setText(null);
		txtAddress.addKeyListener(this);
		c.add(txtAddress);
		
		//Add Mobile TextField
		txtMobile =new JTextField();
		txtMobile.setBounds(370,251,200,30);
		txtMobile.setFont(font1);
		txtMobile.setText(null);
		c.add(txtMobile);
			
		//Add Email TextField
		txtEmailID=new JTextField();
		txtEmailID.setBounds(370,300,200,30);
		txtEmailID.setFont(font1);
		txtEmailID.setText(null);
		c.add(txtEmailID);

	
		
		//Add Insert Button
		btnAdd = new JButton("Insert Appointment");
		btnAdd.setForeground(Color.black);
		btnAdd.setBounds(370,340,160,40);
		btnAdd.setActionCommand("insert");
		btnAdd.addActionListener(this);
		btnAdd.setMnemonic('I');
		getRootPane().setDefaultButton(btnAdd);
		btnAdd.setToolTipText("Click Here to Insert New Appointment");
		c.add(btnAdd);
		
		//Add Close Button
		btnClose = new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(560,340,110,40);
		btnClose.setActionCommand("close")		;
		btnClose.addActionListener(this);
		btnClose.setToolTipText("Click Here to Close");
		c.add(btnClose);
		
		//Set Background adn Layout
		c.setBackground(new Color(0,0,80));
		c.setLayout(null);
		c.setVisible(true);
		setSize(800,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		show(false);
	}
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == 9)
		{	
			txtMobile.grabFocus();	
			txtMobile.setFocusable(true);
		}
	}
	public void keyPressed(KeyEvent e)
	{
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	public void actionPerformed(ActionEvent e)
	{
		DBConn conn = new DBConn();
		if("insert".equals(e.getActionCommand()))
		{	
			String contatid = txtcid.getText();
			String vname = txtName.getText();
			String vmobile = txtMobile.getText();
			String address = txtAddress.getText();
			String emailid = txtEmailID.getText();
			boolean flag = true;
			if(contatid.equals(""))
                        {
                                flag= false;
                                op.showMessageDialog(c,"Enter contact id");
                        }

			else if(vname.equals(""))
			{
				flag= false;
				op.showMessageDialog(c,"Enter Person Name");
			}
			else if(address.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Address");
			}
			else if(vmobile.equals(""))
			{
				flag= false;
				op.showMessageDialog(c,"Enter Mobile Number");
			}
			else if(emailid.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Email Address");
			}
			if(flag)
			{
				try
				{
					con = conn.getConnection();
					ps = con.prepareStatement("INSERT INTO Contact(contatid,cName, cAddress, cMobile, cEmail) VALUES(?,?,?,?,?)");
					ps.setString(1,contatid);
					ps.setString(2, vname);
					ps.setString(3, address);
					ps.setString(4,  vmobile);	
					ps.setString(5, emailid);

					if(ps.executeUpdate()>0)
					{
						op.showMessageDialog(c,"New Contact Added");
						txtMobile.setText("");
						txtName.setText("");
						txtAddress.setText("");
						txtEmailID.setText("");
					}
					else
					{
						op.showMessageDialog(c,"Sorry,plz Try Again");
					}
					ps.close();
					con.close();
				}
				catch(Exception e1)
				{
					op.showMessageDialog(c,e1.toString());
					e1.printStackTrace();
				}
			}
		}
		if("close".equals(e.getActionCommand()))
		{
			this.hide();
		}
	}
	public static void main(String[] args)
	{
		new newcontact("Contact Entry Form");
	}
}
