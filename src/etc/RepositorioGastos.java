package etc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.window;
import objetos.gasto;

public class RepositorioGastos {
	public static void registrarGasto(Connection conexion, String concepto, double costo)
	{
			if(conexion!=null)
			{
				String sql = "INSERT INTO g(Concepto, Costo) VALUES('"+concepto+"', '"+costo+"')";
				try {
					Statement st = conexion.createStatement();
					st.executeUpdate(sql);
				}catch(SQLException ex)
				{
					features.put("Error: "+ex);
				}
			}
	}
	public static void obtenerGastos(Connection conexion)
	{
		String c1; double c2; int count=0;
		if(conexion!=null)
		{
			String sql = "SELECT * FROM g";
			try {
				Statement st=conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					c1=rs.getString(2);
					c2=Double.parseDouble(rs.getString(3));
					escribir(c1, c2);
				}
			}catch(SQLException ex)
			{
				features.put("Error: "+ex);
			}
			
		}
	}
	public static void escribir(String c1, double c2)
	{
		gasto g = new gasto("-5", -5);
		//features.put(c1);
		g.setConcepto(c1);
		//features.put(c2+"");
		g.setCosto(c2);
		window.gasto.add(g);
		window.gastoTotal+=c2;
	}
}
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * */
