//Program for Insert New Appointment
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.awt.print.*;
public class insert extends JFrame implements ActionListener, Printable
{
	//Declare Variables
	JTextField txtaid,txtMobile, txtName, txtDate, txtDuration, txtTime, txtLocation, txtPurpose;
	JComboBox txtWhom;
	JLabel lblaid,lblMobile, lblSrno, lblName, lblWhom,lblDate, lblDuration, lblTime, lblLocation, lblPurpose, lblWhom1, lblLocation1, lblHead;
	JLabel lblDateFormat, lblTimeFormat, lblDurationFormat;
	JButton btnClose, btnAdd;
	Font font, font1;
	JOptionPane op;
	Connection con;
	PreparedStatement ps = null;
	Container c;
	String vname, contact,vmobile, purpose, whom, vlocation, date, time, duration;
	PrinterJob job=null;
	public insert(String title)
	{
		super(title);
		c = getContentPane();
		font = new Font("Courier", Font.BOLD,18);
		font1 = new Font("Courier", Font.BOLD,14);
		
		//Add Head
		lblHead = new JLabel("!!!!!!!!Appointment Entry!!!!!!!!!");
		lblHead.setBounds(200,10,500,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);
		//add aid label
		lblaid = new JLabel("Enter appointment id : ");
                lblaid.setBounds(30,40,300,20);
                lblaid.setForeground(new Color(255,255,100));
                lblaid.setFont(font);
                c.add(lblaid);

		//Add Visitors Label
		lblName = new JLabel("Enter Visitor's Name : ");
		lblName.setBounds(30,90,300,20);
		lblName.setForeground(new Color(255,255,100));
		lblName.setFont(font);
		c.add(lblName);
		
		lblMobile = new JLabel("Enter Mobile No. : ");
		lblMobile.setBounds(30,130,300,20);
		lblMobile.setForeground(new Color(255,255,100));
		lblMobile.setFont(font);
		c.add(lblMobile);
		
		//Add Purpose Label
		lblPurpose = new JLabel("Enter Purpose Behind Meeting : ");
		lblPurpose.setBounds(30,170,500,20);
		lblPurpose.setForeground(new Color(255,255,100));
		lblPurpose.setFont(font);
		c.add(lblPurpose);
		
		//Add Label Whom to Meet
		
		lblWhom = new JLabel("Enter Name of the Person to ");
		lblWhom1 = new JLabel("Whom He/She wants to meet : ");
		lblWhom.setBounds(30,211,700,20);
		lblWhom1.setBounds(30,231,700,20);
		lblWhom.setForeground(new Color(255,255,100));
		lblWhom1.setForeground(new Color(255,255,100));
		lblWhom.setFont(font);
		lblWhom1.setFont(font);
		c.add(lblWhom);
		c.add(lblWhom1);
		
		//Add Location Label
		lblLocation = new JLabel("Enter Location from where ");
		lblLocation1 = new JLabel("He/She came  : ");
		lblLocation.setBounds(30,271,500,20);
		lblLocation1.setBounds(30,291,500,20);
		lblLocation.setForeground(new Color(255,255,100));
		lblLocation1.setForeground(new Color(255,255,100));
		lblLocation.setFont(font);
		lblLocation1.setFont(font);
		c.add(lblLocation);
		c.add(lblLocation1);
		
		//Add Date Label
		lblDate = new JLabel("Enter Date : ");
		lblDate.setBounds(30,331,500,20);
		lblDate.setForeground(new Color(255,255,100));
		lblDate.setFont(font);
		c.add(lblDate);
		
		//Add Date Format Label
		lblDateFormat = new JLabel("MM/DD/YYYY");
		lblDateFormat.setBounds(600,331,180,20);
		lblDateFormat.setForeground(new Color(255,255,100));
		lblDateFormat.setFont(font);
		c.add(lblDateFormat);
		
		//Add Time Label
		lblTime = new JLabel("Enter Time : ");
		lblTime.setBounds(30,371,500,20);
		lblTime.setForeground(new Color(255,255,100));
		lblTime.setFont(font);
		c.add(lblTime);
		
		//Add Time Example
		lblTimeFormat = new JLabel("i.e. 12:50 ");
		lblTimeFormat.setBounds(600,371,180,20);
		lblTimeFormat.setForeground(new Color(255,255,100));
		lblTimeFormat.setFont(font);
		c.add(lblTimeFormat);
		
		//Add Duration Example		
		lblDurationFormat = new JLabel("i.e. 13:20 ");
		lblDurationFormat.setBounds(600,411,180,20);
		lblDurationFormat.setForeground(new Color(255,255,100));
		lblDurationFormat.setFont(font);
		c.add(lblDurationFormat);

		//Add Duration Label
		lblDuration = new JLabel("Enter Duration : ");
		lblDuration.setBounds(30,411,500,20);
		lblDuration.setForeground(new Color(255,255,100));
		lblDuration.setFont(font);
		c.add(lblDuration);
		
		//add aid textfield
		txtaid = new JTextField();
                txtaid.setBounds(370,40,140,30);
                txtaid.setFont(font1);
                txtaid.setText(null);
                c.add(txtaid);

		
		//Add Name TextField
		txtName = new JTextField();
		txtName.setBounds(370,90,140,30);
		txtName.setFont(font1);
		txtName.setText(null);
		c.add(txtName);
		
		//Add Mobile TextField
		txtMobile =new JTextField();
		txtMobile.setBounds(370,130,140,30);
		txtMobile.setFont(font1);
		txtMobile.setText(null);
		c.add(txtMobile);
			
		//Add Purpose TextField
		txtPurpose=new JTextField();
		txtPurpose.setBounds(370,170,140,30);
		txtPurpose.setFont(font1);
		txtPurpose.setText(null);
		c.add(txtPurpose);


		//Add Whom TextField
		txtWhom=new JComboBox();
		txtWhom.setBounds(370,231,140,30);
		txtWhom.setFont(font1);
		getContact();
		c.add(txtWhom);
		

		//Add Location TextField
		txtLocation=new JTextField();
		txtLocation.setBounds(370,291,140,30);
		txtLocation.setFont(font1);
		txtLocation.setText(null);
		c.add(txtLocation);
			
		//Add Date TextField
		txtDate=new JTextField();
		txtDate.setBounds(370,331,140,30);
		txtDate.setFont(font1);
		txtDate.setText(null);
		c.add(txtDate);
			
		//Add Time TextField
		txtTime=new JTextField();
		txtTime.setBounds(370,371,140,30);
		txtTime.setFont(font1);
		txtTime.setText(null);
		c.add(txtTime);
			
		//Add Duration TextField
		txtDuration=new JTextField();
		txtDuration.setBounds(370,411,140,30);
		txtDuration.setFont(font1);
		txtDuration.setText(null);
		c.add(txtDuration);
		
		
		//Add Insert Button
		btnAdd = new JButton("Insert Appointment");
		btnAdd.setForeground(Color.black);
		btnAdd.setBounds(450,450,160,40);
		btnAdd.setActionCommand("insert");
		btnAdd.addActionListener(this);
		btnAdd.setMnemonic('I');
		getRootPane().setDefaultButton(btnAdd);
		btnAdd.setToolTipText("Click Here to Insert New Appointment");
		c.add(btnAdd);
		
		//Add Close Button
		btnClose = new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(640,450,110,40);
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
	public void actionPerformed(ActionEvent e)
	{
		DBConn conn = new DBConn();
		if("insert".equals(e.getActionCommand()))
		{	String appid1 = txtaid.getText();
			int appid=Integer.parseInt(appid1);
			vname = txtName.getText();
			vmobile = txtMobile.getText();
			purpose = txtPurpose.getText();
			whom = txtWhom.getSelectedItem().toString();
	//		contact = (String)txtWhom.getSelectedItem();
			vlocation = txtLocation.getText();
			date = txtDate.getText();
			time = txtTime.getText();
			duration = txtDuration.getText();
			boolean flag = true;
			
			if(appid1.equals(""))
                        {
                                flag= false;
                                op.showMessageDialog(c,"Enter appointment id");
                        }

			else if(vname.equals(""))
			{
				flag= false;
				op.showMessageDialog(c,"Enter Visitor Name");
			}
			else if(vmobile.equals(""))
			{
				flag= false;
				op.showMessageDialog(c,"Enter Visitor Mobile Number");
			}
			else if(purpose.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Purpose for Appointment");
			}
			 else if(whom.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Whom Visitor Wants To Meet");
			}
			else if(vlocation.equals(""))
			{
				flag=false;
				op.showMessageDialog(c,"Enter Visitor's Location");
			}
			else if(date.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Appointment Date");
			}
			else if(time.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Appointment Time");
			}
			else if(duration.equals(""))
			{
				flag = false;
				op.showMessageDialog(c,"Enter Duration");
			}
			if(flag)
			{
				try
				{
					int contact=0;
					con = conn.getConnection();
					ps = con.prepareStatement("Select contatID From Contact Where cName =?");
					ps.setString(1,whom);
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						boolean checkTime=false;
						contact = rs.getInt(1);
						try
						{
							
								//Select Appointment of Given Date and Contact Person
								ps = con.prepareStatement("SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose,  Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contatID = Appointment.ContactID WHERE vDate Like ? AND ContactID = ?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
								ps.setString(1,txtDate.getText());
								ps.setInt(2,contact);
								rs = ps.executeQuery();

								int row=0;
								//Counts Rows of ReultSet for Create a Arrya for Table
								while(rs.next())
								{
									row++;
								}
								if(rs.first())
								{
									int timecount=0;
									//Checcking Time
									do
									{
										long currentTime = Date.parse(txtDate.getText()+" "+ txtTime.getText());
										long currentDuration = Date.parse(txtDate.getText()+" "+ txtDuration.getText());
										long databaseTime = Date.parse(txtDate.getText()+" "+ rs.getTime(8).toString());
										long databaseDuration = Date.parse(txtDate.getText()+" "+ rs.getTime(9).toString());
										if(currentTime>databaseTime && currentTime< databaseDuration)
										{
											checkTime = false;
											op.showMessageDialog(c,"Appointment Time Not Availablse");
											timecount++;
										}
										else if(currentDuration >databaseTime && currentDuration< databaseDuration)
										{
											checkTime = false;
											op.showMessageDialog(c,"Appointment Duration Not Availablse");
											timecount++;
										}
										
										if(timecount >0)
										{
											//Calling viewdate class
											Object[][] data = new Object[row][9];
											String str1 = null,str2 = null,str3 = null,str4 = null,str5 = null,str6 = null,str7 = null, str8 = null, str9 = null;
											rs.first();
											int count=0;
											do
											{
												System.out.println("Read Rows");
												str1 = rs.getString(1);
												str2 = rs.getString(2);
												str3 = rs.getString(3);
												str4 = rs.getString(4);
												str5 = rs.getString(5);
												str6 = rs.getString(6);
												str7 = rs.getDate(7).toString();
												str8 = rs.getTime(8).toString();
												str9 = rs.getTime(9).toString();
							
												data[count][0] = str1;
												data[count][1] = str2;
												data[count][2] = str3;
												data[count][3] = str4;
												data[count][4] = str5;
												data[count][5] = str6;
												data[count][6] = str7;
												data[count][7] = str8;
												data[count][8] = str9;
												count++;
											}while (rs.next());
											if(count > 0)
											{
												viewall frame = new viewall(data);
												frame.pack();
												frame.setVisible(true);
												txtDate.setText("");							
											}
											break;
										}
									}while(rs.next());
								}
								else
								{
									checkTime = true;
								}
						}					
						catch(Exception ex)
						{
							System.out.println(ex.toString());
							op.showMessageDialog(c,ex.toString());
						}
						
						if(checkTime)
						{						
							ps = con.prepareStatement("INSERT INTO Appointment(appid,vName, vMobile, Purpose, ContactID, vLocation, vDate, vTime, Duration) VALUES(?,?,?,?,?,?,?,?,?)");
							ps.setInt(1,appid);
							ps.setString(2, vname);
							ps.setString(3, vmobile);
							ps.setString(4, purpose);	
							ps.setString(5, contact +"");
							ps.setString(6, vlocation);
							ps.setString(7, date);
							ps.setString(8, time);
							ps.setString(9, duration);
	
							if(ps.executeUpdate()>0)
							{
							
								op.showMessageDialog(c,"New Appointment Added");
								//Printing Receipt of Appointment
								job = PrinterJob.getPrinterJob();
								if(ps== null)
								{
									op.showMessageDialog(c,"No Default Printer Available");
									return;
								}

								job.setPrintable(this);
								if(job.printDialog())
								{
									try
									{
										job.print();
									}
									catch(PrinterException ex)
									{
										op.showMessageDialog(c,ex.toString());
									}
								}
								txtDate.setText("");
								txtDuration.setText("");
								txtLocation.setText("");
								txtMobile.setText("");
								txtName.setText("");
								txtPurpose.setText("");
								txtTime.setText("");
								txtWhom.setSelectedIndex(0);

							}
							else
							{
								op.showMessageDialog(c,"Sorry,plz Try Again");
							}
						}
					}
					ps.close();
					con.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		}
		if("close".equals(e.getActionCommand()))
		{
			this.hide();
		}
	}
	public int print(Graphics g, PageFormat pageFormat,  int pageIndex) throws PrinterException
	{
		if (pageIndex != 0)
		{
           return NO_SUCH_PAGE;
       }
       FontMetrics fm;
       g.setFont(font1);
       g.setColor(Color.black);
       fm = g.getFontMetrics();
       
       int i;
       double x, y;
       x = pageFormat.getImageableX();
       y = pageFormat.getImageableY() + fm.getMaxAscent();
		try
		{
			PreparedStatement ps = null;
			DBConn conn = new DBConn();
			Connection con = conn.getConnection();
			ps = con.prepareStatement("SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose,  Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contatID = Appointment.ContactID",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			rs.last();
			g.drawString("Date : " + rs.getDate(7) + "   Time : "+ rs.getTime(8), (int)x,(int)y);
			y += fm.getHeight();
			
			//Printing Appointment ID
			g.drawString("Appointment ID ", (int)x,(int)y);		
			g.drawString(" :  "+  rs.getInt(1), (int)x+150,(int)y);		
			y += fm.getHeight();
			
			//Printing Visitor's Name
			g.drawString("Visitor's Name ", (int)x,(int)y);
			g.drawString(" :  "+ rs.getString(2), (int)x+150,(int)y);
			y += fm.getHeight();
			
			//Printing Purpose
			g.drawString("Purpose "+ rs.getString(4), (int)x,(int)y);
			g.drawString(" :  "+ rs.getString(4), (int)x+150,(int)y);
			y += fm.getHeight();
			
			//Printing Contact Person
			g.drawString("Contact Person ", (int)x,(int)y);
			g.drawString(" :  " + rs.getString(5), (int)x+150,(int)y);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return PAGE_EXISTS;
	}
	public static void main(String[] args)
	{
		new insert("Appointment Entry Form");
	}
}
