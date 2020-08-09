//Programe to database connection: Appointment Databse
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConn
{

  public Connection getConnection()
  {
	Connection con = null;

	try
	{
	  Class.forName("org.postgresql.Driver");
	  con = DriverManager.getConnection("jdbc:postgresql://192.168.16.1:5432/BG20","BG20","");
	
		if(con != null)
		{
			System.out.println("\nConnection Successful");
		}
		else
		{ 
			System.out.println("\nConnection not Successful");
		}
	}

	
	catch(ClassNotFoundException e)
	{
	  System.out.println("Unable to load driver");
	}
	catch(SQLException e)
	{
	  e.printStackTrace();
	}
	return con;

	try{}
  	{
	con.close();
	}
       catch (Exception e){}
  }

  public static void main(String args[])
  {
	DBConn db=new DBConn();
	System.out.println("This line is executed");
  } 
}
