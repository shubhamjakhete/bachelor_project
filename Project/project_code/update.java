//Programe to Update Appointment
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class update extends JFrame implements ActionListener
{
	//Declare Variables
	JTextField txtSearch, txtMobile, txtSrno, txtName,  txtDate, txtDuration, txtTime, txtLocation, txtPurpose;
	JComboBox txtWhom;
	JLabel lblHead, lblMobile, lblSrno, lblName, lblWhom,lblDate, lblDuration, lblTime, lblLocation, lblPurpose, lblWhom1, lblLocation1;
	JButton btnClose, btnUpdate, btnFirst, btnLast, btnNext, btnPrevious;
	Font font, font1;
	JOptionPane op;
	Connection con;
	PreparedStatement ps = null;
	Container c;
	ResultSet rs;

  	public update(String title)
  	{
  		super(title);
		c = getContentPane();
		font = new Font("Courier", Font.BOLD,18);
		font1 = new Font("Courier", Font.BOLD,14);
		
		//Add Head
		lblHead = new JLabel("!!!!!!!!Update Appointment Entries!!!!!!!!!");
		lblHead.setBounds(150,10,500,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);
		
		//Add Serial No. Label
		lblSrno = new JLabel("Enter Sr. No. : ");
		lblSrno.setBounds(30,70,300,20);
		lblSrno.setForeground(new Color(255,255,100));
		lblSrno.setFont(font);
		c.add(lblSrno);
		
		//Add Visitors Label
		lblName = new JLabel("Enter Visitor's Name : ");
		lblName.setBounds(30,100,300,20);
		lblName.setForeground(new Color(255,255,100));
		lblName.setFont(font);
		c.add(lblName);
		
		lblMobile = new JLabel("Enter Mobile No. : ");
		lblMobile.setBounds(30,140,300,20);
		lblMobile.setForeground(new Color(255,255,100));
		lblMobile.setFont(font);
		c.add(lblMobile);
		
		//Add Purpose Label
		lblPurpose = new JLabel("Enter Purpose Behind Meeting : ");
		lblPurpose.setBounds(30,180,500,20);
		lblPurpose.setForeground(new Color(255,255,100));
		lblPurpose.setFont(font);
		c.add(lblPurpose);
		
		//Add Label Whom to Meet
		
		lblWhom = new JLabel("Enter Name of the Person to ");
		lblWhom1 = new JLabel("to Whom He/She wants to meet : ");
		lblWhom.setBounds(30,219,700,20);
		lblWhom1.setBounds(30,239,700,20);
		lblWhom.setForeground(new Color(255,255,100));
		lblWhom1.setForeground(new Color(255,255,100));
		lblWhom.setFont(font);
		lblWhom1.setFont(font);
		c.add(lblWhom);
		c.add(lblWhom1);
		
		//Add Location Label
		lblLocation = new JLabel("Enter Location from where ");
		lblLocation1 = new JLabel(" He/She came  : ");
		lblLocation.setBounds(30,279,500,20);
		lblLocation1.setBounds(30,299,500,20);
		lblLocation.setForeground(new Color(255,255,100));
		lblLocation1.setForeground(new Color(255,255,100));
		lblLocation.setFont(font);
		lblLocation1.setFont(font);
		c.add(lblLocation);
		c.add(lblLocation1);
		
		//Add Date Label
		lblDate = new JLabel("Enter Date : ");
		lblDate.setBounds(30,340,500,20);
		lblDate.setForeground(new Color(255,255,100));
		lblDate.setFont(font);
		c.add(lblDate);
		
		//Add Time Label
		lblTime = new JLabel("Enter Time : ");
		lblTime.setBounds(30,380,500,20);
		lblTime.setForeground(new Color(255,255,100));
		lblTime.setFont(font);
		c.add(lblTime);
		
		
		//Add Duration Label
		lblDuration = new JLabel("Enter Duration : ");
		lblDuration.setBounds(30,420,500,20);
		lblDuration.setForeground(new Color(255,255,100));
		lblDuration.setFont(font);
		c.add(lblDuration);
		
		//Add Sr No. TextField
		txtSrno = new JTextField();
		txtSrno.setBounds(370,60,140,30);
		txtSrno.setFont(font1);
		txtSrno.setText(null);
		txtSrno.setEnabled(false);
		c.add(txtSrno);
		
		//Add Name TextField
		txtName = new JTextField();
		txtName.setBounds(370,100,140,30);
		txtName.setFont(font1);
		txtName.setText(null);
		c.add(txtName);
	
		//Add Mobile TextField
		txtMobile =new JTextField();
		txtMobile.setBounds(370,140,140,30);
		txtMobile.setFont(font1);
		txtMobile.setText(null);
		c.add(txtMobile);
			
		//Add Purpose TextField
		txtPurpose=new JTextField();
		txtPurpose.setBounds(370,180,140,30);
		txtPurpose.setFont(font1);
		txtPurpose.setText(null);
		c.add(txtPurpose);
			
		//Add Whom TextField
		txtWhom=new JComboBox();
		txtWhom.setBounds(370,239,140,30);
		txtWhom.setFont(font1);
		getContact();
		c.add(txtWhom);

		//Add Location TextField
		txtLocation=new JTextField();
		txtLocation.setBounds(370,289,140,30);
		txtLocation.setFont(font1);
		txtLocation.setText(null);
		c.add(txtLocation);
			
		//Add Date TextField
		txtDate=new JTextField();
		txtDate.setBounds(370,340,140,30);
		txtDate.setFont(font1);
		txtDate.setText(null);
		c.add(txtDate);
			
		//Add Time TextField
		txtTime=new JTextField();
		txtTime.setBounds(370,380,140,30);
		txtTime.setFont(font1);
		txtTime.setText(null);
		c.add(txtTime);
			
		//Add Duration TextField
		txtDuration=new JTextField();
		txtDuration.setBounds(370,420,140,30);
		txtDuration.setFont(font1);
		txtDuration.setText(null);
		c.add(txtDuration);
		
		
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
		//show();
		//Get Connection and Result Set of Appointment Table
		getData();
	}
	public void getContact()
	{		
		try
		{
			DBConn conn = new DBConn();
			con = conn.getConnection();
			ps = con.prepareStatement("Select cName From Contact");
			ResultSet rs = ps.executeQuery();		
			txtWhom.removeAllItems();	
			while(rs.next())
			{
				txtWhom.addItem(rs.getString(1));
			}
		}
		catch(Exception ex)
		{
			op.showMessageDialog(c,ex.toString());
		}
	}
	public void getData()
	{
		try
		{
			DBConn conn = new DBConn();
			con = conn.getConnection();
			ps = con.prepareStatement("SELECT * FROM Appointment",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();
			if(rs.next())
			{
				rs.first();
				txtSrno.setText(rs.getInt(1) + "");
				txtName.setText(rs.getString(2));
				txtMobile.setText(rs.getString(3));
				txtPurpose.setText(rs.getString(4));
				int contactid = rs.getInt(5);
				DBConn conn2 = new DBConn();
				Connection con2 = conn2.getConnection();
				PreparedStatement ps2= con2.prepareStatement("Select cName From Contact Where (contactID= ?)");
				ps2.setInt(1,contactid);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next())
				{
						String contact = rs2.getString(1);
						txtWhom.setSelectedItem(contact);
				}
				txtLocation.setText(rs.getString(6));
				txtDate.setText(rs.getDate(7).toString());
				txtTime.setText(rs.getTime(8).toString());
				txtDuration.setText(rs.getTime(9).toString());
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

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
				txtSrno.setText(rs.getInt(1) + "");
				txtName.setText(rs.getString(2));
				txtMobile.setText(rs.getString(3));
				txtPurpose.setText(rs.getString(4));
				int contactid = rs.getInt(5);
				DBConn conn2 = new DBConn();
				Connection con2 = conn2.getConnection();
				PreparedStatement ps2= con2.prepareStatement("Select cName From Contact Where (contactID= ?)");
				ps2.setInt(1,contactid);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next())
				{
						String contact = rs2.getString(1);
						txtWhom.setSelectedItem(contact);
				}
				txtLocation.setText(rs.getString(6));
				txtDate.setText(rs.getDate(7).toString());
				txtTime.setText(rs.getTime(8).toString());
				txtDuration.setText(rs.getTime(9).toString());
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
					txtSrno.setText(rs.getInt(1) + "");
					txtName.setText(rs.getString(2));
					txtMobile.setText(rs.getString(3));
					txtPurpose.setText(rs.getString(4));
					int contactid = rs.getInt(5);
					DBConn conn2 = new DBConn();
					Connection con2 = conn2.getConnection();
					PreparedStatement ps2= con2.prepareStatement("Select cName From Contact Where (contactID= ?)");
					ps2.setInt(1,contactid);
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next())
					{
							String contact = rs2.getString(1);
							txtWhom.setSelectedItem(contact);
					}
					txtLocation.setText(rs.getString(6));
					txtDate.setText(rs.getDate(7).toString());
					txtTime.setText(rs.getTime(8).toString());
					txtDuration.setText(rs.getTime(9).toString());
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
				txtSrno.setText(rs.getInt(1) + "");
				txtName.setText(rs.getString(2));
				txtMobile.setText(rs.getString(3));
				txtPurpose.setText(rs.getString(4));
				int contactid = rs.getInt(5);
				DBConn conn2 = new DBConn();
				Connection con2 = conn2.getConnection();
				PreparedStatement ps2= con2.prepareStatement("Select cName From Contact Where (contactID= ?)");
				ps2.setInt(1,contactid);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next())
				{
						String contact = rs2.getString(1);
						txtWhom.setSelectedItem(contact);
				}
				txtLocation.setText(rs.getString(6));
				txtDate.setText(rs.getDate(7).toString());
				txtTime.setText(rs.getTime(8).toString());
				txtDuration.setText(rs.getTime(9).toString());
  				
  			}
  			catch(Exception ex)
  			{
  				ex.printStackTrace();
  			}
  		}
  		if("update".equals(e.getActionCommand()))
  		{
  			String vname = txtName.getText();
			String vmobile = txtMobile.getText();
			String purpose = txtPurpose.getText();
			String whom = txtWhom.getSelectedItem().toString();
			String vlocation = txtLocation.getText();
			String date = txtDate.getText();
			String time = txtTime.getText();
			String duration = txtDuration.getText();
			String appid = txtSrno.getText();
			boolean flag = true;
			if(vname.equals(""))
			{
				flag= false;
				op.showMessageDialog(c,"Enter Visitor Name");
			}
			if(vmobile.equals(""))
			{
				flag= false;
				op.showMessageDialog(c,"Enter Visitor Mobile Number");
			}
			if(purpose.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Purpose for Appointment");
			}
			if(whom.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Whom Visitor Wants To Meet");
			}
			if(vlocation.equals(""))
			{
				flag=false;
				op.showMessageDialog(c,"Enter Visitor's Location");
			}
			if(date.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Appointment Date");
			}
			if(time.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Appointment Time");
			}
			if(duration.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Duration");
			}
			if(flag)
			{
				
				try
				{	
					int contact=0;
					DBConn conn = new DBConn();
					Connection con2 = conn.getConnection();
					ps = con2.prepareStatement("Select contactID From Contact Where (cName = ?)");
					ps.setString(1,whom);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						contact = rs.getInt(1);
						ps = con.prepareStatement("UPDATE Appointment Set vName = ?, vMobile = ?, Purpose = ?, vLocation = ? , vDate = ?, vTime = ?, Duration = ?, ContactID= ? WHERE AppID = ?");
						ps.setString(1, vname);
						ps.setString(2, vmobile);
						ps.setString(3, purpose);	
						ps.setString(4, vlocation);
						ps.setString(5, date);
						ps.setString(6, time);
						ps.setString(7, duration);
						ps.setString(8, String.valueOf(contact));
						ps.setInt(9,Integer.parseInt(appid));
						ps.executeUpdate();
						op.showMessageDialog(c,"Record Updated");
					}
				}catch(Exception e2)
				{
					op.showMessageDialog(c,e2.toString());
					e2.printStackTrace();
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
     	new update("Update Appointment");
  	}
}
