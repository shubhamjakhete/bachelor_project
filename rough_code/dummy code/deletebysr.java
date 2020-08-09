//Programe to Delete Appointment By Serial Number
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class deletebysr extends JFrame implements ActionListener
{
		//Declare Variables
	JTextField txtID;
	JLabel lblID,lblHead;
	Font font,font1;
	JButton btnClose,btnDelete;
	JOptionPane op;
	Connection conn=null;
	Container c;

  public deletebysr(String title)
  {
		super(title);
		c = getContentPane();

		//Set Font
		font = new Font("Courier",font.BOLD,18);
		font1 = new Font("Courier",font.BOLD,14);

		//Add Head Labels
		lblHead= new JLabel("!!!!! Delete Appointment !!!!!");
		lblHead.setBounds(240,50,420,20);
		lblHead.setForeground(new Color(255,255,100));
		lblHead.setFont(font);
		c.add(lblHead);

		//Add ID Label
		lblID= new JLabel("Enter Proper ID to Delete An Appoitment : ");
		lblID.setBounds(50,150,700,20);
		lblID.setForeground(new Color(255,255,100));
		lblID.setFont(font1);
		c.add(lblID);

		//Add ID TextBox
		txtID = new JTextField();
		txtID.setBounds(500,150,100,30);
		txtID.setFont(font1);
		txtID.setText(null);
		c.add(txtID);


		//Add Delete Button
		btnDelete =new JButton("Delete");
		btnDelete.setForeground(Color.black);
		btnDelete.setBounds(300,250,80,30);
		btnDelete.setActionCommand("Delete");
		btnDelete.setMnemonic('D');
		getRootPane().setDefaultButton(btnDelete);
		btnDelete.addActionListener(this);
		btnDelete.setToolTipText("Click Here to Delete an Appointment");
		c.add(btnDelete);

		//ADD Close Button
		btnClose = new JButton("Close");
		btnClose.setForeground(Color.black);
		btnClose.setBounds(400,250,80,30);
		btnClose.setActionCommand("Close");
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
  	if ("Delete".equals(e.getActionCommand()))
		{
			DBConn connect = new DBConn();
			try
			{			
				conn = connect.getConnection();
				String uname=txtID.getText();
				String query="Delete From Appointment WHERE AppID=?";
				PreparedStatement stat = conn.prepareStatement(query);
				stat.setString(1,uname);
				int nrows =stat.executeUpdate();
				if(nrows > 0)
				{
					op.showMessageDialog(c,"Record Deleted");
					txtID.setText("");
					this.hide();
				}
				else
				{
					op.showMessageDialog(c,"Invalid ID,Record Not Deleted,Plz Try Again");
					txtID.setText("");
				}

			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		if ("Close".equals(e.getActionCommand()));
		{
			this.hide();
		}
  }
  public static void main(String[] args)
  {
     new deletebysr("Delte Appointment: By Serail No");
  }
}