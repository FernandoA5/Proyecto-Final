package etc;
import etc.conexion;
import objetos.habitacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositorioHabitacion {
	public static Connection con=null;
	public static void crearHabitacion(Connection conexion, int numero)
	{
		String sql ="insert into h(Numero, Estado, Huesped) values("+numero+",0,'')";
		if(conexion!=null)
		{
			try {
				Statement st = null;
				st = conexion.createStatement();
				try
				{
					st.executeUpdate(sql);
				}catch(SQLException e)
				{
					features.put("Error: "+e);
				}
			}catch(Exception ex)
			{
				features.put("Error: "+ex.getStackTrace());
			}
		}
		
	}
	public static habitacion obtenerHabitacion(Connection conexion, int numero)
	{
		habitacion h = new habitacion(-5, true);
		String sql = "SELECT * FROM h WHERE numero="+numero;
		if(conexion!=null)
		{
			try {
				Statement st = null;
				st = conexion.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next())
				{
					try {
						h.setNumero(Integer.parseInt(rs.getString(2)));
						h.setEstado((rs.getInt(3)==0)?true:false);
						h.setOcupante(rs.getString(4));
					}catch(SQLException e)
					{
						features.put("Error: "+e);
					}
				}
			}catch(SQLException ex)
			{
				features.put("Error: "+ex);
			}
		}
		return h;
	}
	public static void ocuparHabitacion(Connection conexion, int numero, String ocupante)
	{
		if(conexion!= null) {
			try
			{
				String sql="UPDATE h SET Estado=1 WHERE Numero="+numero;
				Statement st = null;
				st = conexion.createStatement();
				st.executeUpdate(sql);
				sql="UPDATE h SET Huesped='"+ocupante+"' WHERE Numero="+numero;
				st = conexion.createStatement();
				st.executeUpdate(sql);
			}catch(SQLException ex)
			{
				features.put("Error: "+ex);
			}
		}
	}
	public static void desocuparHabitacion(Connection conexion, int numero)
	{
		if(conexion!=null)
		{
			try {
				String sql="UPDATE h SET Estado=0 WHERE Numero="+numero;
				Statement st = null;
				st = conexion.createStatement();
				st.executeUpdate(sql);
				sql="UPDATE h SET Huesped='' WHERE Numero="+numero;
				st = conexion.createStatement();
				st.executeUpdate(sql);
			}catch(SQLException ex)
			{
				features.put("Error: "+ex);
			}
		}
	}
}
