package objetos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.window;
import Ventanas.adminUI;
import etc.repositorioHabitacion;
import etc.repositorioIngresos;
import etc.conexion;
import etc.features;

public class habitacion {
	//OBJETOS GLOBALES
	JLabel habitacion = new JLabel();
	JButton registrar = new JButton();
	JButton xb = new JButton();
	JTextField tbNombre = new JTextField(16);
	JLabel lblFecha = new JLabel();
	
	//VARIABLES GLOBALES
	public String content;
	private int id;
	private int numero;
	private boolean estado;
	private String ocupante="";
	private String fecha;
	
	public habitacion(int numero, boolean estado, String fecha)
	{
		this.numero=numero;
		this.estado=estado; //POR DEFECTO VENDRA EN TRUE: DISPONIBLE
		this.fecha=fecha;
	}
	
	//GETTERS
	public int getNumero()
	{
		return this.numero;
	}
	public boolean getEstado()
	{
		return this.estado;
	}
	public String getOcupante()
	{
		return this.ocupante;
	}
	public String getFecha()
	{
		return this.fecha;
	}
	public int getId()
	{
		return this.id;
	}
	
	//SETTERS
	public void ocupar(String nombre)
	{
		//AQUI SE CONECTA CON LA BASE DE DATOS PARA REGISTRAR EL HUESPED Y USO DE LA HABITACION
		this.ocupante=nombre;
		this.estado=false;
	}
	public void desocupar()
	{
		//AQUI SE CONECTA CON LA BASE DE DATOS PARA DESOCUPAR LA HABITACION
		this.estado=true;
		this.ocupante="";
	}
	public void setNumero(int numeroLocal)
	{
		this.numero=numeroLocal;
	}
	public void setEstado(boolean estadoLocal)
	{
		this.estado=estadoLocal;
	}
	public void setOcupante(String ocupanteLocal)
	{
		this.ocupante=ocupanteLocal;
	}
	public void setFecha(String fechaL)
	{
		this.fecha=fechaL;
	}
	public void setId(int idL)
	{
		this.id=idL;
	}
	//METODOS ESPECIALES
	public void dibujar(int Sx, int Sy, int x, int y)
	{
		//OBJETOS
			//LBL HABITACION
		habitacion.setLayout(null);
		habitacion.setOpaque(true);
		habitacion.setHorizontalAlignment(SwingConstants.CENTER);
		habitacion.setVerticalAlignment(SwingConstants.CENTER);
		habitacion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		habitacion.setForeground(Color.WHITE);
		content = (this.ocupante.equals(""))?this.numero+"":this.ocupante;
		habitacion.setText(content);
		habitacion.setBounds(x, y, Sx, Sy);
			//LBL FECHA
		lblFecha.setLayout(null);
		lblFecha.setText(this.fecha);
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setBounds(x, y+100, Sx, 20);
		botones(Sx, Sy, x, y);
			
	}
	
	public void botones(int Sx, int Sy, int x, int y)
	{
		
		//CAJA DE TEXTO  y = y+125     y=18
		tbNombre.setLayout(null);
		tbNombre.setText("Nombre del Huesped");
		tbNombre.setHorizontalAlignment(SwingConstants.CENTER);
		tbNombre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		tbNombre.setBounds(x, y+125, 256, 18);
		
		
		//BOTON DE REGISTRAR
		registrar.setLayout(null);
		registrar.setText("Registrar");
		registrar.setForeground(Color.WHITE);
		registrar.setBackground(Color.GREEN);
		registrar.setBounds(x, y+143, 256, 17);
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(window.precioH!=-5)
				{
					System.out.println("Registrar"+numero);
					
					String nombre;
					
					int idTB=0;
					for(int i =0; i<window.room.size();i++)
					{
						
						if(window.room.get(i).getId()==id)
						{
							idTB = i;
						}
					}
					nombre = window.room.get(idTB).tbNombre.getText();
					ocupar(nombre);
					features.put(nombre);
					adminUI.i.addIngreso("Habitación", window.precioH);
					repositorioIngresos.añadirIngreo(conexion.getConection(), "Habitación", window.precioH);
					//AÑADIR NOMBRE A LA BASE DE DATOS
					
					repositorioHabitacion.ocuparHabitacion(conexion.getConection(), numero, nombre, fecha);
					tbNombre.setText("Nombre del Huesped");
					setVisible(estado, fecha);
				}
			}
		};
		registrar.addActionListener(al);
		if(this.id==1)
		{
			window.listeners++;
		}
	
		xb.setLayout(null);
		xb.setText("X");
		xb.setForeground(Color.WHITE);
		xb.setBackground(Color.RED);
		xb.setBounds(x, y+125, 256, 35);
		ActionListener xal = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("HABITACION "+ numero);
				desocupar();
				repositorioHabitacion.desocuparHabitacion(conexion.getConection(), numero);
				setVisible(estado, fecha);
			}
		};
		xb.addActionListener(xal);
		
	}
	public void setVisible(boolean v, String fecha)
	{	
			lblFecha.setVisible(v);
			content = (this.ocupante.equals(""))?this.numero+"":this.ocupante;
			Color c = (v==true)? Color.GREEN:Color.RED;
			habitacion.setBackground(c);
			habitacion.setText(content);
			
			
			habitacion.setVisible(true);
			
			registrar.setVisible(v);
			tbNombre.setVisible(v);
			xb.setVisible(!v);
			
			if(!fecha.equals(this.fecha))
			{
				lblFecha.setVisible(false);
				habitacion.setVisible(false);
				registrar.setVisible(false);
				tbNombre.setVisible(false);
				xb.setVisible(false);
			}
			
			window.p.add(lblFecha);
			window.p.add(habitacion);
			window.p.add(registrar);
			window.p.add(tbNombre);
			window.p.add(xb);
	}
	
}
