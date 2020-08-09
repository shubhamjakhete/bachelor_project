//Programe to Search Appiontment
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class search extends JFrame implements ActionListener
{
	//Declare Variables
	JComboBox cbSearchBy;
	JTextField txtSearchText;
	JLabel lblSearch, lblSearchBy, lblHead;
	Font font, font1;
	JButton btnClose,btnSearch;
	JOptionPane op;
	Container c;
  	public search(String title)
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
		
		//Add Search By Label
		lblSearchBy = new JLabel("Search By : ");
		lblSearchBy.setBounds(50,150,700,20);
		lblSearchBy.setForeground(new Color(255,255,100));
		lblSearchBy.setFont(font);
		c.add(lblSearchBy);
		
		//Add Search By ComboBox
		String[] values = {"Serail No.","Appointment Date","Visitor's Name","Visitor's Mobile NO."};
		cbSearchBy = new JComboBox(values);
		cbSearchBy.setBounds(500,150,250,30);
		cbSearchBy.setFont(font);
		cbSearchBy.setSelectedIndex(0);
		c.add(cbSearchBy);
		
		//Add Search Label
		lblSearch=new JLabel("Enter Value to Search An Appointment : ");
		lblSearch.setBounds(50,250,700,20);
		lblSearch.setForeground(new Color(255,255,100));
		lblSearch.setFont(font);
		c.add(lblSearch);

		//Add Search TextField
		txtSearchText=new JTextField ();
		txtSearchText.setBounds(500,250,150,30);
		txtSearchText.setFont(font1);
		txtSearchText.setText(null);
		c.add(txtSearchText);

		//Add Search Button
		btnSearch=new JButton("Search");
		btnSearch.setForeground(Color.black);
		btnSearch.setBounds(300,350,80,30);
		btnSearch.setActionCommand("search");
		btnSearch.setMnemonic('S');
		getRootPane().setDefaultButton(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.setToolTipText("Click Here to Search An Appointment");
		c.add(btnSearch);

		//Add Close Button
		btnClose=new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(400,350,80,30);
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
  	public void actionPerformed(ActionEvent e)
  	{
  		Connection conn=null;
		PreparedStatement stmt=null;
		DBConn connect =new DBConn();
		//System.out println("Action Commandrd" + e.getActionCommand());
		if ("search".equals(e.getActionCommand()))
		{
			String uname = txtSearchText.getText();
			String query1="",query2="";
			String searchby = cbSearchBy.getSelectedItem().toString();
			if(searchby == "Visitor's Name")
			{
				query1="SELECT COUNT(*) FROM Appointment WHERE vName Like ?";
				query2="SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose, Appointment.contactID, Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contatID = Appointment.contactID WHERE (((Appointment.vName) Like ?))";
			}
			else if(searchby == "Visitor's Mobile NO.")
			{
				query1="SELECT COUNT(*) FROM Appointment WHERE vMobile Like ?";
				query2="SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose, Appointment.contactID, Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contatID = Appointment.contactID WHERE (((Appointment.vMobile) Like ?))";

			}
			else if(searchby=="Serail No.")
			{
				query1="SELECT COUNT(*) FROM Appointment WHERE AppID LIKE ? ";
				query2="SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose, Appointment.contactID, Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contatID = Appointment.contactID WHERE (((Appointment.AppID) Like ?))";
			}
			else if(searchby=="Appointment Date")
			{
				query1="SELECT COUNT(*) FROM Appointment WHERE vDate LIKE ?";
				query2="SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose, Appointment.contactID, Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contatID = Appointment.contactID WHERE (((Appointment.vDate) Like ?))";
			}

			String str1 = null,str2 = null,str3 = null,str4 = null,str5 = null,str6 = null,str7 = null, str8 = null, str9 = null;
			DBConn dbcon = new DBConn();
			try
			{

				conn = dbcon.getConnection();
				System.out.println("Get Connection");
				stmt = conn.prepareStatement(query1);
				stmt.setString(1,uname);
				ResultSet rs = stmt.executeQuery();
				System.out.println("Execute Query For Count");
				int count = 0;
				if (rs.next())
				{
					count = rs.getInt(1);
					System.out.println("Count : "+count);
				}

				Object[][] data = new Object[count][9];
				PreparedStatement stmt2 = conn.prepareStatement(query2);
				stmt2.setString(1,uname);
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
					str5 = rs2.getString(6);
					str6 = rs2.getString(7);
					str7 = rs2.getDate(8).toString();
					str8 = rs2.getTime(9).toString();
					str9 = rs2.getTime(10).toString();

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
					txtSearchText.setText("");

				}
				else
				{
					txtSearchText.setText("");
					op.showMessageDialog(c,"Record Not Found,Plz Try Again");
				}
			}
			catch (Exception e1)
			{
				System.out.println(e1.toString());
				e1.printStackTrace();
			}
		}
		if("close".equals(e.getActionCommand()))
		{
			this.hide();
		}
  	}
  	public static void main(String[] args)
  	{
     	new search("Search Appointment");
  	}
}
