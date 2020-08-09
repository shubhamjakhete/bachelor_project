//Programe to View All Appointments : By Appointment Date
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class viewdate extends JFrame implements ActionListener
{ 
  	//Declare Variables
  	JTextField txtDate;
  	JLabel lblView, lblHead, lblDateFormat;
  	Font font, font1;
  	Container c;
  	JOptionPane op;
  	JButton btnClose, btnSearch;
  
  	public viewdate(String title)
  	{
		super(title);
		c= getContentPane();
		
		//Set Font
		font = new Font("Courier", Font.BOLD, 18);
		font1 = new Font("Courier", Font.BOLD, 14);

		//Add Head Lable 
		lblHead = new JLabel("******View Appointments:By Date******");
		lblHead.setBounds(220,50,500,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);
	

		//Add View By Date Lable
		lblView = new JLabel("!!!!!! View Appointment:By Date !!!!!!");
		lblView.setBounds(50,150,700,20);
		lblView.setForeground(new Color(255,255,100));
		lblView.setFont(font);
		c.add(lblView);

		//Add Sample Date Format Example Label
		lblDateFormat = new JLabel("YYYY/DD/MM");
		lblDateFormat.setBounds(650,150,700,20);
		lblDateFormat.setForeground(new Color(255,255,100));
		lblDateFormat.setFont(font);
		c.add(lblDateFormat);



		//Insert Date Textbox
        txtDate = new JTextField();
        txtDate.setBounds(470,150,150,30);
		txtDate.setFont(font1);
		txtDate.setText(null);
		c.add(txtDate);
        
		//Add Search Button
		btnSearch = new JButton("View:By Date");
		btnSearch.setForeground(Color.black);
		btnSearch.setBounds(300,250,180,30);
		btnSearch.setActionCommand("search");
		btnSearch.setMnemonic('V');
		getRootPane().setDefaultButton(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.setToolTipText("Click Here to View Appointment");
		c.add(btnSearch);

		//Add Close Button
		btnClose = new JButton("Close");
		btnClose.setBounds(500,250,80,30);
		btnClose.setForeground(Color.black);
		btnClose.setActionCommand("close");
		btnClose.addActionListener(this);
		btnClose.setToolTipText("Click Here to Close");
		c.add(btnClose);
     	
     	//Set Background And Layout
		c.setBackground(new Color(0,0,80));
		c.setLayout(null);
		c.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,600);
		show(false);
		//show();
  	}

  	public void actionPerformed(ActionEvent e)
  	{  		
		Connection conn = null;
		PreparedStatement stmt = null;
		DBConn connect = new DBConn();
		System.out.println("ActionCommand : "+e.getActionCommand());
		if ("search".equals(e.getActionCommand()))
		{
			String vDate = txtDate.getText();
			if(vDate.length() >= 8)
			{
				
				String str1 = null,str2 = null,str3 = null,str4 = null,str5 = null,str6 = null,str7 = null, str8 = null, str9 = null;
				DBConn dbcon = new DBConn();
				try
				{
					conn = dbcon.getConnection();
					stmt = conn.prepareStatement("SELECT COUNT(*) FROM Appointment WHERE vDate Like ?");
					stmt.setString(1,vDate);
					ResultSet rs = stmt.executeQuery();
					int count = 0;
					if (rs.next())
					{
						count = rs.getInt(1);
						System.out.println("Count : "+count);
					}
	
					Object[][] data = new Object[count][9];
					PreparedStatement stmt2 = conn.prepareStatement("SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose,  Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contatID = Appointment.ContactID WHERE vDate Like ?");
					stmt2.setString(1,vDate);
					ResultSet rs2 = stmt2.executeQuery();
					System.out.println("Select Rows");
					int row = 0;
					while (rs2.next())
					{
						System.out.println("Read Rows");
						str1 = rs2.getString(1);
						str2 = rs2.getString(2);
						str3 = rs2.getString(3);
						str4 = rs2.getString(4);
						str5 = rs2.getString(5);
						str6 = rs2.getString(6);
						str7 = rs2.getDate(7).toString();
						str8 = rs2.getTime(8).toString();
						str9 = rs2.getTime(9).toString();
	
						data[row][0] = str1;
						data[row][1] = str2;
						data[row][2] = str3;
						data[row][3] = str4;
						data[row][4] = str5;
						data[row][5] = str6;
						data[row][6] = str7;
						data[row][7] = str8;
						data[row][8] = str9;
						row++;
					}
					if(row > 0)
					{
						viewall frame = new viewall(data);
						frame.pack();
						frame.setVisible(true);
						txtDate.setText("");
	
					}
					else
					{
						txtDate.setText("");
						op.showMessageDialog(c,"Record Not Found,Plz Try Again");
					}
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
			else
			{
				op.showMessageDialog(c,"Enter Valid Date");
			}
				
		}
		if ("close".equals(e.getActionCommand()))
		{
			setVisible(false);
		}
	}
	public static void main(String[] args)
	{
		new viewdate("View Appointment:By Date");
	}
}
