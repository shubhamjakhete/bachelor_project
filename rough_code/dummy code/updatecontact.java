//Programe to Update Contact Perston Details
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class updatecontact extends JFrame implements ActionListener, KeyListener
{
	//Declare Variables
	JTextField txtSrno, txtName, txtMobile, txtEmailID;
	JTextArea txtAddress;
	JLabel lblAddress, lblSrno, lblName, lblEmailID,lblDate, lblDuration, lblTime, lblLocation, lblMobile, lblWhom1, lblLocation1, lblHead;
	JButton btnClose, btnUpdate, btnFirst, btnLast, btnNext, btnPrevious;
	Font font, font1;
	JOptionPane op;
	Connection con;
	PreparedStatement ps = null;
	Container c;
	ResultSet rs;

  	public updatecontact(String title)
  	{
		super(title);
		c = getContentPane();
		font = new Font("Courier", Font.BOLD,18);
		font1 = new Font("Courier", Font.BOLD,14);
		
		//Add Head
		lblHead = new JLabel("!!!!!!!!Contact Update!!!!!!!!!");
		lblHead.setBounds(200,20,500,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);

		//Add Serial No. Label
		lblSrno = new JLabel("Enter Sr. No. : ");
		lblSrno.setBounds(30,60,300,20);
		lblSrno.setForeground(new Color(255,255,100));
		lblSrno.setFont(font);
		c.add(lblSrno);
				
		//Add Person Name Label
		lblName = new JLabel("Enter Person Name : ");
		lblName.setBounds(30,100,300,20);
		lblName.setForeground(new Color(255,255,100));
		lblName.setFont(font);
		c.add(lblName);
		
		//Add Address Label
		lblAddress = new JLabel("Enter Address : ");
		lblAddress.setBounds(30,140,300,20);
		lblAddress.setForeground(new Color(255,255,100));
		lblAddress.setFont(font);
		c.add(lblAddress);
		
		//Add Mobile Number Label
		lblMobile = new JLabel("Enter Mobile No.  : ");
		lblMobile.setBounds(30,220,500,20);
		lblMobile.setForeground(new Color(255,255,100));
		lblMobile.setFont(font);
		c.add(lblMobile);
		
		//Add Email Address Label
		
		lblEmailID= new JLabel("Enter Email Address  :  ");
		lblEmailID.setBounds(30,261,700,20);
		lblEmailID.setForeground(new Color(255,255,100));
		lblEmailID.setFont(font);
		c.add(lblEmailID);

		//Add Sr No. TextField
		txtSrno = new JTextField();
		txtSrno.setBounds(370,60,140,30);
		txtSrno.setFont(font1);
		txtSrno.setText(null);
		txtSrno.setEnabled(false);
		c.add(txtSrno);
		
		//Add Name TextField
		txtName = new JTextField();
		txtName.setBounds(370,100,200,30);
		txtName.setFont(font1);
		txtName.setText(null);
		c.add(txtName);
	
		//Add Address TextArea
		txtAddress=new JTextArea("",2,2);
		txtAddress.setLineWrap(true);
		txtAddress.setWrapStyleWord(true);
		txtAddress.setBounds(370,140,200,60);
		txtAddress.setFont(font1);
		txtAddress.setText(null);
		txtAddress.addKeyListener(this);
		c.add(txtAddress);
		
		//Add Mobile TextField
		txtMobile =new JTextField();
		txtMobile.setBounds(370,210,200,30);
		txtMobile.setFont(font1);
		txtMobile.setText(null);
		c.add(txtMobile);
			
		//Add Email TextField
		txtEmailID=new JTextField();
		txtEmailID.setBounds(370,251,200,30);
		txtEmailID.setFont(font1);
		txtEmailID.setText(null);
		c.add(txtEmailID);
		
		//Add First Button
		btnFirst = new JButton("First");
		btnFirst.setForeground(Color.black);
		btnFirst.setBounds(10,480,100,40);
		btnFirst.addActionListener(this);
		btnFirst.setActionCommand("first");
		btnFirst.setToolTipText("Click Here to View First Appointment");
		c.add(btnFirst);
			 
		//Add Previous Button
		btnPrevious= new JButton("Previous");
		btnPrevious.setForeground(Color.black);
		btnPrevious.setBounds(120,480,100,40);
		btnPrevious.addActionListener(this);
		btnPrevious.setActionCommand("previous");
		btnPrevious.setToolTipText("Click Here to View Previous Appointment");
		c.add(btnPrevious);
		
		//Add Next Button
		btnNext= new JButton("Next");
		btnNext.setForeground(Color.black);
		btnNext.setBounds(230,480,100,40);
		btnNext.addActionListener(this);
		btnNext.setActionCommand("next");
		btnNext.setToolTipText("Click Here to View Next Appointment");
		c.add(btnNext);
		
		//Add Last Button
		btnLast = new JButton("Last");
		btnLast.setForeground(Color.black);
		btnLast.setBounds(340,480,100,40);
		btnLast.addActionListener(this);
		btnLast.setActionCommand("last");
		btnLast.setToolTipText("Click Here to View Last Appointment");
		c.add(btnLast);
		
		//Add Update Button
		btnUpdate = new JButton("Update Appointment");
		btnUpdate.setForeground(Color.black);
		btnUpdate.setBounds(470,480,160,40);
		btnUpdate.setActionCommand("update");
		btnUpdate.addActionListener(this);
		btnUpdate.setMnemonic('U');
		getRootPane().setDefaultButton(btnUpdate);
		btnUpdate.setToolTipText("Click Here to Update Appointment");
		c.add(btnUpdate);
		
		//Add Close Button
		btnClose = new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(640,480,110,40);
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
		
		//Get Connection and Result Set of Appointment Table
		getData();
	}
	public void getData()
	{
		try
		{
			DBConn conn = new DBConn();
			con = conn.getConnection();
			ps = con.prepareStatement("SELECT * FROM Contact",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			if(rs.next())
			{
				rs.first();
				txtSrno.setText(rs.getInt(1)+"");
				txtName.setText(rs.getString(2));
				txtMobile.setText(rs.getString(3));
				txtAddress.setText(rs.getString(4));
				txtEmailID.setText(rs.getString(5));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

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
  		if("first".equals(e.getActionCommand()))
  		{
			getData();  			
  		}
  		if("previous".equals(e.getActionCommand()))
  		{
  			try
  			{
  				rs.previous();
				txtSrno.setText(rs.getInt(1)+"");
				txtName.setText(rs.getString(2));
				txtMobile.setText(rs.getString(3));
				txtAddress.setText(rs.getString(4));
				txtEmailID.setText(rs.getString(5));
  			}
  			catch(Exception ex)
  			{
  				ex.printStackTrace();
  			}
  		}
  		if("next".equals(e.getActionCommand()))
  		{
  			try
  			{
  				if(rs.next())
  				{
				txtSrno.setText(rs.getInt(1)+"");
				txtName.setText(rs.getString(2));
				txtMobile.setText(rs.getString(3));
				txtAddress.setText(rs.getString(4));
				txtEmailID.setText(rs.getString(5));
  				}
  			}
  			catch(Exception ex)
  			{
  				ex.printStackTrace();
  			}
  		}
  		if("last".equals(e.getActionCommand()))
  		{
  			try
  			{
  				rs.last();
				txtSrno.setText(rs.getInt(1)+"");
				txtName.setText(rs.getString(2));
				txtMobile.setText(rs.getString(3));
				txtAddress.setText(rs.getString(4));
				txtEmailID.setText(rs.getString(5));
  				
  			}
  			catch(Exception ex)
  			{
  				ex.printStackTrace();
  			}
  		}
  		if("update".equals(e.getActionCommand()))
  		{
  			String srno = txtSrno.getText();
			String vname = txtName.getText();
			String vmobile = txtMobile.getText();
			String address = txtAddress.getText();
			String emailid = txtEmailID.getText();
			boolean flag = true;
			if(vname.equals(""))
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
					DBConn conn = new DBConn();
					con = conn.getConnection();
					ps = con.prepareStatement("UPDATE Contact SET cName=?, cAddress=?, cMobile=?, cEmail=? Where contatID=?");
					ps.setString(1, vname);
					ps.setString(2, address);
					ps.setString(3,  vmobile);	
					ps.setString(4, emailid);
					ps.setString(5,srno);
					ps.executeUpdate();
					op.showMessageDialog(c,"Record Updated");
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
     	new updatecontact("Update Contact Details");
  	}
}
