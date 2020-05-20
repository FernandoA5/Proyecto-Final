package etc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioIngresos {
	public static void añadirIngreo(Connection conexion, String Concepto, double Cantidad)
	{
		if(conexion!=null)
		{
			String sql="INSERT INTO i(Concepto, Cantidad) VALUES('"+Concepto+"','"+Cantidad+"')";
			try {
				Statement st = conexion.createStatement();
				st.executeUpdate(sql);
			}catch(SQLException ex)
			{
				features.put("Error: " + ex);
			}
		}
	}
	public static void leerIngresos(Connection conexion)
	{
		if(conexion!=null)
		{
			String sql= "SELECT * FROM i";
			try {
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
			}catch(SQLException ex)
			{
				features.put("ERROR: "+ ex);
			}
		}
	}
}
