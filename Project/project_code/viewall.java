//Programe to View All Appointments
import javax.swing.JScrollPane.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class viewall extends JFrame
{
	//Declare Variables
	private boolean DEBUG = true;
	String[] columnNames = {"ID","Visitor's Name","MobileNo","Purpose Behind Meeting","Contact Person","location","Date","Time","Duration"};

	public viewall(Object[][] data)
	{
		super("View All Appointment");
		final JTable table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,70));
		if (DEBUG)
		{
			table.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e )	{ printDebugData(table); }	});
		}		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane,BorderLayout.CENTER);
	}
	public viewall(String title)
	{
		super(title);
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		String str1 = null, str2 = null,str3 = null,str4 = null,str5 = null,str6 = null,str7 = null, str8 = null, str9 = null;

		DBConn dbcon = new DBConn();
		try
		{
			con = dbcon.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM Appointment");

			int count = 0;
			if (rs.next())
			{
				count = rs.getInt(1);
			}
			rs = null;
			Object[][] data = new Object[count][9];
			rs = stmt.executeQuery("SELECT Appointment.AppID, Appointment.vName, Appointment.vMobile, Appointment.Purpose,  Contact.cName, Appointment.vLocation, Appointment.vDate, Appointment.vTime, Appointment.Duration FROM Contact INNER JOIN Appointment ON Contact.contactID = Appointment.ContactID");
			int row = 0;
			while (rs.next())
			{

				str1 = rs.getString(1);
				str2 = rs.getString(2);
				str3 = rs.getString(3);
				str4 = rs.getString(4);
				str5 = rs.getString(5);
				str6 = rs.getString(6);
				str7 = rs.getDate(7).toString();
				str8 = rs.getTime(8).toString();
				str9 = rs.getTime(9).toString();

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
			rs.close();
			stmt.close();
			con.close();

			final JTable table = new JTable(data,columnNames);
			table.setPreferredScrollableViewportSize(new Dimension(750,150));

			if(DEBUG)
			{
				table.addMouseListener(new MouseAdapter()
					{ 
						public void mouseClick(MouseEvent e)
						{
							printDebugData(table);
						}
					}
					);
			}

			JScrollPane scrollPane = new JScrollPane(table);
			getContentPane().add(scrollPane,BorderLayout.CENTER);

		}
		catch (SQLException se)
		{
			System.out.print("Sql exception..Can't add in table");
			System.out.println(se.toString());
		}

		pack();
		setVisible(true);
		show(false);
		setSize(800,600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private void printDebugData(JTable table)
	{

		int numRows = table.getRowCount();
		int numCols = table.getColumnCount();
		javax.swing.table.TableModel model = table.getModel();

		System.out.println("Value of data:");

		for (int i = 0; i < numRows; i++)
		{
			System.out.print("     row" + i + " : ");
			for(int j =0; j< numCols; j++)
			{
			
				System.out.print(" "+ model.getValueAt(i, j));
			}
			System.out.println();

		}
		System.out.println("----------------------");
	}


	public static void main(String[] args)
	{
		new viewall("View All Appointment");
	}
}
