package etc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
	
	  private static Connection conexion=null;
	  //private Statement sentencia;
	  private static String driver;
	  
	  private static String db;
	  public conexion()
	  {
		this.driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		this.db = "jdbc:ucanaccess://C:\\\\POOProject\\\\DB.accdb";
		
	  }
	  public static Connection getConection()
	  {
		  try {
			  if(conexion==null)
			  {
				  Class.forName(driver);
				  conexion=DriverManager.getConnection(db );
				  features.put("CONEXION CORRECTA");
			  }
		  }catch(Exception ex)
		  {
			  features.put("ERROR"+ex);
		  }
		  return conexion;
	  }
	  
}
