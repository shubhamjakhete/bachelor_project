//Programe to Show Help
import javax.swing.*;
import java.awt.*;
public class help extends JFrame
{
	Container c;
	JLabel jlfile,jlnew,jlclose,jlexit,jlexit1,jldelete,jlhelp,jlhelp1,jlfind,jlabout,jlupdate,jledit,jlviews,jlview,jlsearch;
	Font font,font1;
	public help (String title)
	{
		super(title);
		c= getContentPane();
		//set font
		font=new Font("Courier",Font.BOLD,14);
		
		//Add File Menu Label
		jlfile=new JLabel("The File Menu Offers the Following Commands");
		jlfile.setBounds(10,10,500,20);
		jlfile.setFont(font);
		c.add(jlfile);

		//Add File Sub Menu : New Lable
		jlnew=new JLabel("New   : Creates a New Appointment Entries (Insert New Entry).");
		jlnew.setBounds(40,40,500,20);
		jlnew.setFont(font);
		c.add(jlnew);
	
		//Add File Sub Menu : Close Label
		jlclose=new JLabel("Close : Closes an Opened Document");
		jlclose.setBounds(40,60,500,20);
		jlclose.setFont(font);
		c.add(jlclose);

		//Add File Sub Menu : Exit Label
		jlexit=new JLabel("Exit  : Exits from Appointment Schedule");
		jlexit.setBounds(40,80,500,20);
		jlexit.setFont(font);
		c.add(jlexit);
		
		//Add File Menu Label
		jledit=new JLabel("The Edit Menu Offers the Following Commandss:");
		jledit.setBounds(10,110,500,20);
		jledit.setFont(font);
		c.add(jledit);

		//Add Edit Sub Menu : Update Label
		jlupdate=new JLabel("Update : Updates the Appointment Entries (Updates Selected Row Entries)");
		jlupdate.setBounds(40,140,570,20);
		jlupdate.setFont(font);
		c.add(jlupdate);

		//Add Edit Sub Menu : Delete Label
		jldelete=new JLabel("Delete : Deletes the Selected Row, Using ID or Mobile Number");
		jldelete.setBounds(40,160,500,20);
		jldelete.setFont(font);
		c.add(jldelete);
		
		//Add View Menu Label
		jlview=new JLabel("The View Menu Offers the Following Commands:");
		jlview.setBounds(10,190,500,20);
		jlview.setFont(font);
		c.add(jlview);

		//Add View Sub Menu :  Views Label
		jlviews=new JLabel("Views : Show All Appointments or Shows Datewise Appointment ");
		jlviews.setBounds(40,220,500,20);
		jlviews.setFont(font);
		c.add(jlviews);

		//Add Search Menu Label
		jlsearch=new JLabel("The Search Menu Offers the Following Commands:");
		jlsearch.setBounds(10,250,500,20);
		jlsearch.setFont(font);
		c.add(jlsearch);

		//Add Search Sub Menu : Find Label
		jlfind=new JLabel("Find : Finds the Matching Entry Using Visitor's Name Or Mobile Number.");
		jlfind.setBounds(40,280,600,20);
		jlfind.setFont(font);
		c.add(jlfind);

		//Add Help Menu Label
		jlhelp=new JLabel("The Help Menu Offers the Following Commands");
		jlhelp.setBounds(10,310,500,20);
		jlhelp.setFont(font);
		c.add(jlhelp);
		
		//Add Help Sub Menu : Aboutus Label
		jlabout=new JLabel("Aboutus : Display Information About this Application");
		jlabout.setBounds(40,340,500,20);
		jlabout.setFont(font);
		c.add(jlabout);

		//Add Help Sub Menu : Help Label
		jlhelp1=new JLabel("Help    : Display Help on Clicked on Buttons");
		jlhelp1.setBounds(40,360,500,20);
		jlhelp1.setFont(font);
		c.add(jlhelp1);
	
		//Add Help Sub Menu : 
		jlexit1=new JLabel("Exit    : Exits from Appointment Schedule");
		jlexit1.setBounds(40,380,500,20);
		jlexit1.setFont(font);
		c.add(jlexit1);

		//Set Background and Layout
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		c.setVisible(true);
		setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		setSize(600,550);
		show();
	}
	public static void main(String []args)
	{
		new help ("Help Topics");
	}
}