import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class aboutus extends JFrame implements ActionListener
{
JButton okbttn;
public aboutus()
{
init();
setTitle("Help");
setSize(700,400);
setVisible(true);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
}
public void init()
{
try
{

okbttn=new JButton("Ok");

setLayout(null);


JLabel text = new  JLabel("Project Name -> Appointment Schedule System");
text.setBounds(50,10,350,30);

JLabel text1 = new  JLabel(" Team Member-> 1 : Ajinkya Yadav RollNo : 158  Class : 'TYBSC(Comp.Science) '");
text1.setBounds(50,50,650,30);

JLabel text2 = new  JLabel(" Team Member-> 2 : Shubham Jakhete RollNo : 140  Class : 'TYBSC(Comp.Science) '");
text2.setBounds(50,90,650,30);

JLabel text3 = new  JLabel("Team Member -> 3: Shubham Bharati RollNo : 161  Class: 'TYBSC(Comp.Science) '");
text3.setBounds(50,130,650,30);

JLabel text4 = new  JLabel("Front End          -> 'JAVA'");
text4.setBounds(50,170,350,30);

JLabel text5 = new  JLabel("Back End           -> 'PostgreSQL'");
text5.setBounds(50,210,350,30);

okbttn.setBounds(290,250,60,30);

//dd(lblPic);
add(okbttn);
add(text);
add(text1);
add(text2);
add(text3);
add(text4);
add(text5);

okbttn.addActionListener(this);
}
catch(Exception e)
{}
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==okbttn)
{
setVisible(false);
//new SelectionWindow();
}
}

public static void main(String args[])
{
try
{
new aboutus();
}
catch(Exception e)
{}
}
}
