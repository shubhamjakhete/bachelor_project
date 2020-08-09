//Programe to Search Appointment By Mobile Number
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class searchbymobile extends JFrame implements ActionListener
{
	//Declare Variables
	JTextField txtMobileNo;
	JLabel lblMobile, lblHead;
	Font font, font1;
	JButton btnClose,btnSearch;
	JOptionPane op;
	Container c;
	public searchbymobile(String title)
	{
		super(title);
		c=getContentPane();
		
		//set font
		font=new Font ("Courier",Font.BOLD,18);
		font1=new Font ("Courier",Font.BOLD,14);

		//Add Label Head
		lblHead=new JLabel("!!!!!!!! Search Appointment !!!!!!!!");
		lblHead.setBounds(250,50,420,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);
		
		//Add Visitor's Mobile Number Label
		lblMobile=new JLabel("Enter Visitor's Mobile to Search An Appointment : ");
		lblMobile.setBounds(50,150,700,20);
		lblMobile.setForeground(new Color(255,255,100));
		lblMobile.setFont(font);
		c.add(lblMobile);

		//Add Mobile Number TextField
		txtMobileNo=new JTextField ();
		txtMobileNo.setBounds(590,150,150,30);
		txtMobileNo.setFont(font1);
		txtMobileNo.setText(null);
		c.add(txtMobileNo);

		//Add Search Button
		btnSearch=new JButton("Search");
		btnSearch.setForeground(Color.black);
		btnSearch.setBounds(300,250,80,30);
		btnSearch.setActionCommand("search");
		btnSearch.setMnemonic('S');
		getRootPane().setDefaultButton(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.setToolTipText("Click Here to Search An Appointment");
		c.add(btnSearch);

		//Add Close Button
		btnClose=new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(400,250,80,30);
		btnClose.setActionCommand("close");
		btnClose.setMnemonic('C');
		btnClose.addActionListener(this);
		btnClose.setToolTipText("Click Here to Close");
		c.add(btnClose);
		
		//Set Background and Layout
		c.setBackground(new Color(0,0,80));
		c.setLayout (null);
		c.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,600);
		show(false);
	}
	public void actionPerformed (ActionEvent e )
	{
		Connection conn=null;
		PreparedStatement stmt=null;
		DBConn connect =new DBConn();
		//System.out println("Action Commandrd" + e.getActionCommand());
		if ("search".equals(e.getActionCommand()))
		{
			String umobile = txtMobileNo.getText();
			if(umobile.length() >= 6)
			{			
				String str1 = null,str2 = null,str3 = null,str4 = null,str5 = null,str6 = null,str7 = null, str8 = null, str9 = null;
				DBConn dbcon = new DBConn();
				try
				{
	
					conn = dbcon.getConnection();
					System.out.println("Get Connection");
					stmt = conn.prepareStatement("SELECT COUNT(*) FROM Appointment WHERE vMobile Like ?");
					stmt.setString(1,umobile);
					ResultSet rs = stmt.executeQuery();
					System.out.println("Execute Query For Count");
					int count = 0;
					if (rs.next())
					{
						count = rs.getInt(1);
						System.out.println("Count : "+count);
					}
	
					Object[][] data = new Object[count][9];
					PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Appointment WHERE vMobile Like ?");
					stmt2.setString(1,umobile);
					System.out.println("Before Select Rows");
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
						txtMobileNo.setText("");
	
					}
					else
					{
						txtMobileNo.setText("");
						op.showMessageDialog(c,"Record Not Found,Plz Try Again");
					}
				}
				catch (Exception e1)
				{
					System.out.println(e1.toString());
					e1.printStackTrace();
				}
			}
			else
			{
					op.showMessageDialog(c,"Enter Valid Mobile Number");
			}
		}
		if("close".equals(e.getActionCommand()))
		{
			this.hide();
		}
	}
	public static void main(String [] args)
	{
		searchbymobile s= new searchbymobile("Search Appointment: By Visitor's Name");
	}
}
