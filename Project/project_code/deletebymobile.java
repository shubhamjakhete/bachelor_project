//Program to Delete an Appointment:By Mobile Number
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class deletebymobile extends JFrame implements ActionListener
{

	//Declare Variables
	JTextField txtMobileNo;
	JLabel lblMobileNo,lblHead;
	Font font,font1;
	JButton btnClose,btnDelete;
	JOptionPane op;
	Connection conn=null;
	Container c;

	public deletebymobile(String title)
	{
		super(title);
		c = getContentPane();
		
		//Set Font
		font = new Font("Courier",font.BOLD,18);
		font1 = new Font("Courier",font.BOLD,14);

		//Add Head Labels
		lblHead= new JLabel("!!!!! Delete Appointment !!!!!");
		lblHead.setBounds(270,50,420,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);

		//Add Label Mobile Number
		lblMobileNo= new JLabel("Enter Proper Mobile No. to Delete an Appointment:");
		lblMobileNo.setBounds(50,150,700,20);
		lblMobileNo.setForeground(new Color(255,255,100));
		lblMobileNo.setFont(font1);
		c.add(lblMobileNo);

		//Add Mobile Number TextBox
		txtMobileNo = new JTextField();
		txtMobileNo.setBounds(570,150,120,30);
		txtMobileNo.setFont(font1);
		txtMobileNo.setText(null);
		c.add(txtMobileNo);

		//Add Delete Button
		btnDelete =new JButton("Delete");
		btnDelete.setForeground(Color.black);
		btnDelete.setBounds(300,250,80,30);
		btnDelete.setActionCommand("delete");
		btnDelete.setMnemonic('D');
		getRootPane().setDefaultButton(btnDelete);
		btnDelete.addActionListener(this);
		btnDelete.setToolTipText("Click Here to Delete an Appointment");
		c.add(btnDelete);

		//Add Close Button
		btnClose = new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(400,250,80,30);
		btnClose.setActionCommand("close");
		btnClose.setMnemonic('C');
		btnClose.addActionListener(this);
		btnClose.setToolTipText("Click Here to Close");
		c.add(btnClose);

		//Set Background And layout
		c.setBackground(new Color(0,0,80));
		c.setLayout(null);
		c.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800,600);
		show(false);
	}
	public void actionPerformed(ActionEvent e)
	{
		if ("delete".equals(e.getActionCommand()))
		{
			DBConn connect = new DBConn();
			try
			{
				conn = connect.getConnection();
				String uname=txtMobileNo.getText();
				String query="DELETE FROM Appointment WHERE vMobile=?";
				PreparedStatement stat = conn.prepareStatement(query);
				stat.setString(1,uname);
				int nrows=stat.executeUpdate();
				if(nrows > 0)
				{
					op.showMessageDialog(c,"Record Deleted");
					txtMobileNo.setText("");
					setVisible(false);
				}
				else
				{
					op.showMessageDialog(c,"Invalid Mobile Number, Record Not Deleted, Plz Try Again");
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		else if ("close".equals(e.getActionCommand()))
		{
			this.hide();
		}
	}
	public static void main(String[] args)
	{
		deletebymobile d = new deletebymobile("Delete Appointment : By Mobile Number");
	}
}
