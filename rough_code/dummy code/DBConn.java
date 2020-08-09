//Programe to databse connection: Appointment Databse
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
	  con = DriverManager.getConnection("jdbc:postgresql://localhost/shubham","shubham","");
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
  }
}
