//Programe to Main Form
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class main extends JFrame implements ActionListener
{
	//Declare Veriables
	insert insert1;
	search search1;
	searchbyname searchbyname1;
	searchbymobile searchbymobile1;
	viewall viewall1;
	viewdate viewdate1;
	update update1;
	delete delete1;
	deletebysr deletebysr1;
	deletebymobile deletebymobile1;
	newcontact newcontact1;
	updatecontact updatecontact1;
	JMenuBar mb;
	JMenu mFile, mEdit, mSearch, mView, mSb, mFind, mDelete, mSubView, mHelp, mContact;
	JMenuItem miNew, miExit, miOpen, miUpdate, miAbout, miExit2, miClose, miHelp;
	JMenuItem mibyName, mibyMobile, miDelSrno, miDelMobile, miViewAll, miViewDate,miNewContact,miUpdateContact;
	JButton btnNew, btnView, btnSelect, btnDelete, btnUpdate, btnSearch, btnExit, btnHelp, btnDate;
	JLabel lblCenter;
	Font font;
	public main(String title)
	{
		super(title);
		Container c = getContentPane();
		
		//Set Font
		font = new Font("Courier", Font.BOLD, 20);

		//Add ImageIcon
		ImageIcon iiNew = new ImageIcon("Images/new.png");
		ImageIcon iiView = new ImageIcon("Images/viewall.png");
		ImageIcon iiDelete = new ImageIcon("Images/delete.png");
		ImageIcon iiUpdate = new ImageIcon("Images/update.png");
		ImageIcon iiSearch = new ImageIcon("Images/search.png");
		ImageIcon iiExit = new ImageIcon("Images/exit.png");
		ImageIcon iiDate = new ImageIcon("Images/viewdate.png");

		//Create MenuBar and Add Menu Item to it
		mb = new JMenuBar();

		//File Menu and its Menu Item
		mFile = new JMenu("File");
			miNew = new JMenuItem("New");
			miNew.addActionListener(this);
			miNew.setActionCommand("insert");
			mFile.add(miNew);
			mFile.addSeparator();
			miClose = new JMenuItem("Close");
			miClose.setActionCommand("close");
			miClose.addActionListener(this);
			mFile.add(miClose);
			mFile.addSeparator();
			miExit = new JMenuItem("Exit");
			miExit.setActionCommand("exit");
			miExit.addActionListener(this);
			mFile.add(miExit);
			

		//View Menu and its Menu Item
		mView = new JMenu("View");
		mSubView = new JMenu("View", true);
			miViewAll = new JMenuItem("View All Appointments");
			miViewAll.setActionCommand("select");
			miViewAll.addActionListener(this);
			miViewDate = new JMenuItem("Appointments: By Date");
			miViewDate.setActionCommand("viewdate");
			miViewDate.addActionListener(this);
			mSubView.add(miViewAll);
			mSubView.add(miViewDate);
			mView.add(mSubView);

		//Help Menu And its Menu Items
		mHelp = new JMenu("Help");
			miAbout = new JMenuItem("About Us");
			miHelp = new JMenuItem("Help");
			miExit = new JMenuItem("Exit");
			miAbout.setActionCommand("aboutus");
			miAbout.addActionListener(this);
			miHelp.setActionCommand("help");
			miHelp.addActionListener(this);
			miExit.setActionCommand("exit");
			miExit.addActionListener(this);
			mHelp.add(miAbout);
			mHelp.addSeparator();
			mHelp.add(miHelp);
			mHelp.addSeparator();
			mHelp.add(miExit);
		
		//Find Menu and its Menu Item
		mFind = new JMenu("Find");
			mibyName = new JMenuItem("By Name");
			mibyMobile = new JMenuItem("By Mobile");
			mibyName.addActionListener(this);
			mibyName.setActionCommand("searchbyname");
			mibyMobile.addActionListener(this);
			mibyMobile.setActionCommand("searchbymobile");
			mFind.add(mibyName);
			mFind.add(mibyMobile);

		//Search Menu and its Sub Menu Find
		mSearch = new JMenu("Search");
			mSearch.add(mFind);

		//Delete Menu and its Menu Item
		mDelete = new JMenu("Delete", true);
			miDelSrno = new JMenuItem("By ID");
			miDelMobile = new JMenuItem("By Mobile Number");
			miDelSrno.setActionCommand("deletebysr");
			miDelSrno.addActionListener(this);
			miDelMobile.setActionCommand("deletebymobile");
			miDelMobile.addActionListener(this);
			mDelete.add(miDelSrno);
			mDelete.add(miDelMobile);

		//Edit Menu and its Sub Menu Delete and Menu Items
		mEdit = new JMenu("Edit");
			miUpdate = new JMenuItem("Update");
			miUpdate.setActionCommand("update");
			miUpdate.addActionListener(this);
			mEdit.add(mDelete);
			mEdit.addSeparator();
			mEdit.add(miUpdate);
			
		//Contact Menu and its Sub Menu New Update
		mContact = new JMenu("Contact");
			miNewContact = new JMenuItem("New Contact");
			miUpdateContact = new JMenuItem("Update Contact");
			miNewContact.setActionCommand("newcontact");
			miUpdateContact.setActionCommand("updatecontact");
			miNewContact.addActionListener(this);
			miUpdateContact.addActionListener(this);
			mContact.add(miNewContact);
			mContact.addSeparator();
			mContact.add(miUpdateContact);

		//Add Menu
		setJMenuBar(mb);
		mb.add(mFile);
		mb.add(mEdit);
		mb.add(mView);
		mb.add(mSearch);
		mb.add(mContact);
		mb.add(mHelp);


		//Add Insert Button
		btnNew = new JButton(iiNew);
		btnNew.setForeground(Color.black);
		btnNew.setBounds(10,10,50,50);
		btnNew.setActionCommand("insert");
		btnNew.addActionListener(this);
		btnNew.setToolTipText("Click Here to Insert New Appointment");
		c.add(btnNew);

		//Add View Button
		btnView = new JButton(iiView);
		btnView.setForeground(Color.black);
		btnView.setBounds(100,10,50,50);
		btnView.setActionCommand("select");
		btnView.addActionListener(this);
		btnView.setToolTipText("Click Here To View All Appointments");
		c.add(btnView);
		
		//Add Delete Button
		btnDelete = new JButton(iiDelete);
		btnDelete.setForeground(Color.black);
		btnDelete.setBounds(190,10,50,50);
		btnDelete.setActionCommand("delete");
		btnDelete.addActionListener(this);
		btnDelete.setToolTipText("Click Here To Delete an Appointment");
		c.add(btnDelete);
		
		//Add Update Button
		btnUpdate = new JButton(iiUpdate);
		btnUpdate.setForeground(Color.black);
		btnUpdate.setBounds(280,10,50,50);
		btnUpdate.setActionCommand("update");
		btnUpdate.addActionListener(this);
		btnUpdate.setToolTipText("Click Here To Update an Appointment");
		c.add(btnUpdate);
		
		//Add Search Button
		btnSearch = new JButton(iiSearch);
		btnSearch.setForeground(Color.black);
		btnSearch.setBounds(370,10,50,50);
		btnSearch.setActionCommand("search");
		btnSearch.addActionListener(this);
		btnSearch.setToolTipText("Click Here To Search an Appointment");
		c.add(btnSearch);
		
		//Add View By Date Button
		btnDate = new JButton(iiDate);
		btnDate.setForeground(Color.black);
		btnDate.setBounds(480,10,50,50);
		btnDate.setActionCommand("viewdate");
		btnDate.addActionListener(this);
		btnDate.setToolTipText("Click Here To View Appointment: By Date");
		c.add(btnDate);

		//Add Exit Button
		btnExit = new JButton(iiExit);
		btnExit.setForeground(Color.black);
		btnExit.setBounds(550,10,50,50);
		btnExit.setActionCommand("exit");
		btnExit.addActionListener(this);
		btnExit.setToolTipText("Click Here To Exit");
		c.add(btnExit);
		
		/*Adding Flower Icon
		lblCenter = new JLabel(new ImageIcon("sai.jpg"),JLabel.CENTER);
		lblCenter.setVerticalTextPosition(JLabel.TOP);
		lblCenter.setBounds(100,100,500,400);
		lblCenter.setHorizontalTextPosition(JLabel.CENTER);*/
		
		
		//Add key Stroke Menu Item : New		
		miNew.setMnemonic(KeyEvent.VK_N);
		KeyStroke ksmiNew = KeyStroke.getKeyStroke(KeyEvent.VK_N,Event.CTRL_MASK);
		miNew.setAccelerator(ksmiNew);
		
		//Add key Stroke Menu Item : Exit
		miExit.setMnemonic(KeyEvent.VK_X);
		KeyStroke ksmiExit = KeyStroke.getKeyStroke(KeyEvent.VK_X,Event.CTRL_MASK);
		miExit.setAccelerator(ksmiExit);
		
		//Add key Stroke Menu Item : Search By Name
		mibyName.setMnemonic(KeyEvent.VK_F3);
		KeyStroke ksmibyName = KeyStroke.getKeyStroke(KeyEvent.VK_F3,Event.CTRL_MASK);
		mibyName.setAccelerator(ksmibyName);
		
		//Add Key Stroke Menu Item : Delete By Mobile Number
		miDelMobile.setMnemonic(KeyEvent.VK_D);
		KeyStroke ksmidelMobile = KeyStroke.getKeyStroke(KeyEvent.VK_D, Event.CTRL_MASK);
		miDelMobile.setAccelerator(ksmidelMobile);
		
		//Add Key Stroke Menu Item : Update
		
		miUpdate.setMnemonic(KeyEvent.VK_U);
		KeyStroke ksmiUpdate = KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK);
		miUpdate.setAccelerator(ksmiUpdate);
		
		//Add Key Stroke Menu Item : View All
		miViewAll.setMnemonic(KeyEvent.VK_1);
		KeyStroke ksmiviewAll = KeyStroke.getKeyStroke(KeyEvent.VK_1, Event.CTRL_MASK);
		miViewAll.setAccelerator(ksmiviewAll);
		
		
		//Add Key Stroke Menu Item : View By Date
		
		miViewDate.setMnemonic(KeyEvent.VK_2);
		KeyStroke ksmiviewDate = KeyStroke.getKeyStroke(KeyEvent.VK_2, Event.CTRL_MASK);
		miViewDate.setAccelerator(ksmiviewDate);
		
		/*lblCenter = new JLabel("Weclome",new ImageIcon("sai.jpg"),JLabel.CENTER);
		lblCenter.setVerticalTextPosition(JLabel.TOP);
		lblCenter.setBounds(100,100,500,400);
		lblCenter.setHorizontalTextPosition(JLabel.CENTER);
		c.add(lblCenter);*/
		
		//Set Background and Layout
		c.setBackground(new Color(0, 0, 80));
		c.setLayout(null);
		c.setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 800);
		show();
		deletebymobile1 = new deletebymobile("Delete Appointment: By Visitor's Mobile No");
		insert1 = new insert("Appointment Entry Form");
		search1 = new search("Search Appointment Form");
		searchbyname1 = new searchbyname("Search Appointment: By Visitor's Name");
		searchbymobile1 = new searchbymobile("Search Appointment: By Visitor's Mobile Number");
		viewall1 = new viewall("View All Appointment");
		viewdate1 = new viewdate("View Appointment : By Date");
		update1 = new update("Update Appointment");
		delete1 = new delete("Delete Appointment");
		deletebysr1 = new deletebysr("Delete Appointment: By Serail No.");
		newcontact1 = new newcontact("Contact Entry Form");
		updatecontact1 = new updatecontact("Update Contact Details");
	}
	public void actionPerformed(ActionEvent e)
	{
	 	
			if("insert".equals(e.getActionCommand()))
			{
				insert1.getContact();
			 	insert1.show();
			}
			if("search".equals(e.getActionCommand()))
			{
				search1.show();
			}
			if("exit".equals(e.getActionCommand()))
			{
				this.dispose();
				System.exit(0);
			}
			if("close".equals(e.getActionCommand()))
			{
				if(deletebymobile1.isShowing())
				{
					deletebymobile1.hide();
				}
				else if(insert1.isShowing())
				{
					insert1.hide();
				}
				else if(search1.isShowing())
				{
					search1.hide();
				}
				else if(searchbyname1.isShowing())
				{
					searchbyname1.hide();
				}
				else if(searchbymobile1.isShowing())
				{
					searchbymobile1.hide();
				}
				else if(viewall1.isShowing())
				{
					viewall1.hide();
				}
				else if(viewdate1.isShowing())
				{
					viewdate1.hide();
				}
				else if(update1.isShowing())
				{
					update1.hide();
				}
				else if(delete1.isShowing())
				{
					delete1.hide();
				}
				else if(newcontact1.isShowing())
				{
					newcontact1.hide();
				}
				else if(updatecontact1.isShowing())
				{
					updatecontact1.hide();
				}
			}
			if("searchbyname".equals(e.getActionCommand()))
			{
				searchbyname1.show();
			}
			if("searchbymobile".equals(e.getActionCommand()))
			{
				searchbymobile1.show();
			}
			if("select".equals(e.getActionCommand()))
			{
				viewall1.show();
			}
			if("viewdate".equals(e.getActionCommand()))
			{
				viewdate1.show();
			}
			if("update".equals(e.getActionCommand()))
			{
				update1.getData();
				update1.getContact();
				update1.show();				
			}
			if("delete".equals(e.getActionCommand()))
			{
				delete1.show();
			}
			if("deletebysr".equals(e.getActionCommand()))
			{
				deletebysr1.show();
			}
			if("deletebymobile".equals(e.getActionCommand()))
			{
				deletebymobile1.show();				
			}
			if("newcontact".equals(e.getActionCommand()))
			{
				newcontact1.show();
			}
			if("updatecontact".equals(e.getActionCommand()))
			{
				updatecontact1.getData();
				updatecontact1.show();				
			}
			if("aboutus".equals(e.getActionCommand()))
			{
				new aboutus();
			}
			if("help".equals(e.getActionCommand()))
			{
				new help("Help");
			}
	}
	public static void main(String[] args)
	{
		new main("Main Form");
	}
}
