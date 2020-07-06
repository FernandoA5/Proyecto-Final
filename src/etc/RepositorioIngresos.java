package etc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;

import Main.window;
import objetos.ingreso;

public class repositorioIngresos {
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
			
			String sql= "SELECT * FROM i ORDER BY Id DESC";
			try {
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					ingreso i = new ingreso("", -5);
					i.setConcepto(rs.getString(2));
					i.setCantidad(Double.parseDouble(rs.getString(3)));
					window.ingreso.add(i);
					JLabel lblI = new JLabel();
					JLabel lblC= new JLabel();
					Ventanas.vIngresos.lblConcepto.add(lblC);
					Ventanas.vIngresos.lblIngreso.add(lblI);
					window.ingresoTotal+=window.precioH;
				}
			}catch(SQLException ex)
			{
				features.put("ERROR: "+ ex);
			}
		}
	}
	public static void setPrecio(Connection conexion, double precio)
	{
		String sql="UPDATE admin SET precio='"+precio+"' WHERE Id='1'";
		if(conexion!=null)
		{
			try
			{
				Statement st = conexion.createStatement();
				st.executeUpdate(sql);
			}catch(SQLException ex)
			{
				features.put("Error: "+ex);
			}
		}
	}
	public static void getPrecio(Connection conexion)
	{
		String sql="SELECT * FROM admin WHERE Id='1'";
		if(conexion!=null)
		{
			try
			{
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					window.precioH=Double.parseDouble(rs.getString(2));
					
				}
			}catch(SQLException ex)
			{
				features.put("ERROR: "+ex);
			}
		}
	}
}
