package objetos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.ventanas;
import Main.window;
import Ventanas.adminUI;
import etc.RepositorioHabitacion;
import etc.conexion;
import etc.features;

public class habitacion {
	//OBJETOS GLOBALES
	//JButton habitacion = new JButton();
	JLabel habitacion = new JLabel();
	JButton registrar = new JButton();
	JButton xb = new JButton();
	JTextField tbNombre = new JTextField(16);
	public String content;
	private int numero;
	private boolean estado;
	private String ocupante;
	public habitacion(int numero, boolean estado)
	{
		this.numero=numero;
		this.estado=estado; //POR DEFECTO VENDRA EN TRUE: DISPONIBLE
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
	
	//METODOS ESPECIALES
	public void dibujar(int Sx, int Sy, int x, int y)
	{
		
		//OBJETOS
		habitacion.setLayout(null);
		habitacion.setOpaque(true);
		habitacion.setHorizontalAlignment(SwingConstants.CENTER);
		habitacion.setVerticalAlignment(SwingConstants.CENTER);
		habitacion.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		habitacion.setForeground(Color.WHITE);
		content = (this.ocupante.equals(""))?this.numero+"":this.ocupante;
		habitacion.setText(content);
		habitacion.setBounds(x, y, Sx, Sy);
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
					
					String nombre = tbNombre.getText();
					ocupar(nombre);
					adminUI.i.addIngreso("Habitación", window.precioH);
					//AÑADIR NOMBRE A LA BASE DE DATOS
					RepositorioHabitacion.ocuparHabitacion(conexion.getConection(), numero, ocupante);
					tbNombre.setText("Nombre del Huesped");
					setVisible(estado);
				}
			}
		};
		registrar.addActionListener(al);
	
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
				RepositorioHabitacion.desocuparHabitacion(conexion.getConection(), numero);
				setVisible(estado);
			}
		};
		xb.addActionListener(xal);
		
	}
	public void setVisible(boolean estado)
	{	
		content = (this.ocupante.equals(""))?this.numero+"":this.ocupante;
		habitacion.setText(content);
		Color c = (estado==true)? Color.GREEN:Color.RED;
		habitacion.setBackground(c);
		window.p.add(habitacion);
		
		
		
		registrar.setVisible(estado);
		window.p.add(registrar);
		
		tbNombre.setVisible(estado);
		
		window.p.add(tbNombre);
	
		xb.setVisible(!estado);
		window.p.add(xb);
	}
	
}
