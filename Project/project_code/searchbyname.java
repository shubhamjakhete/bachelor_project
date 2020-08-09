//Programe to Search Appointment By Visito's Name
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class searchbyname extends JFrame implements ActionListener
{
	//Declare Variables
	JTextField txtName;
	JLabel jlid, jlex;
	Font font, font1;
	JButton btnClose, btnSearch;
	JOptionPane op;
	Container c;
	public searchbyname(String title)
	{
		super(title);
		c=getContentPane();
		
		//set font
		font=new Font ("Courier",Font.BOLD,18);
		font1=new Font ("Courier",Font.BOLD,14);

		//Add Label Head
		jlex=new JLabel("!!!!!!!! Search Appointment !!!!!!!!");
		jlex.setBounds(250,50,420,20);
		jlex.setForeground(new Color(255,255,100));
		jlex.setFont(font);
		c.add(jlex);
		
		//Add Visitor's Name Label
		jlid=new JLabel("Enter Visitor's Name to Search An Appointment : ");
		jlid.setBounds(50,150,700,20);
		jlid.setForeground(new Color(255,255,100));
		jlid.setFont(font);
		c.add(jlid);

		//Add Visitor's Name TextField
		txtName=new JTextField ();
		txtName.setBounds(570,150,150,30);
		txtName.setFont(font1);
		txtName.setText(null);
		c.add(txtName);

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
			String uname = txtName.getText();
			if(uname.length() >= 1)
			{
				
				String str1 = null,str2 = null,str3 = null,str4 = null,str5 = null,str6 = null,str7 = null, str8 = null, str9 = null;
				DBConn dbcon = new DBConn();
				try
				{
	
					conn = dbcon.getConnection();
					System.out.println("Get Connection");
					stmt = conn.prepareStatement("SELECT COUNT(*) FROM Appointment WHERE vName Like ?");
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
					PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM Appointment WHERE vName Like ?");
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
						txtName.setText("");
	
					}
					else
					{
						txtName.setText("");
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
					op.showMessageDialog(c,"Enter Visitor's Name");
			}
		}
		if("close".equals(e.getActionCommand()))
		{
			this.hide();
		}
	}
	public static void main(String [] args)
	{
		searchbyname s= new searchbyname("Search Appointment: By Visitor's Name");
	}
}
