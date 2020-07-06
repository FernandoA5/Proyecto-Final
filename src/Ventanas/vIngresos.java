package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.window;
import etc.repositorioIngresos;
import etc.conexion;
import etc.features;
import objetos.ingreso;

public class vIngresos {
	public static JLabel lblDRC = new JLabel();
	public static JTextField tbPrecio = new JTextField();
	public static JButton btnPrecio = new JButton();
	public static ArrayList<JLabel> lblIngreso = new ArrayList<JLabel>();
	public static ArrayList<JLabel> lblConcepto = new ArrayList<JLabel>();
	public static JLabel lblTotal = new JLabel();
	public vIngresos()
	{
		//SETEANDO EL PRECIO DE LA BASE DE DATOS
		repositorioIngresos.getPrecio(conexion.getConection());
		//SETEANDO INGRESOS
		repositorioIngresos.leerIngresos(conexion.getConection());
		//LBL INGRESOS TOTALES
		lblTotal.setLayout(null);
		lblTotal.setText("TOTAL: ");
		lblTotal.setBounds(950,650,200,20);
		//ESTABLECER PRECIO DE LA HABITACIÓN
		lblDRC.setLayout(null);
		lblDRC.setText("Precio Habitación: ");
		lblDRC.setForeground(Color.BLACK);
		lblDRC.setBounds(550, 50, 150, 20);
		//TB PRECIO
		tbPrecio.setLayout(null);
		tbPrecio.setText((window.precioH!=-5)?window.precioH+"":"");
		tbPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		tbPrecio.setBounds(700, 50, 150, 20);
		//BTN AJUSTAR PRECIO
		btnPrecio.setLayout(null);
		btnPrecio.setText("Cambiar");
		btnPrecio.setVerticalAlignment(SwingConstants.CENTER);
		btnPrecio.setForeground(Color.BLACK);
		btnPrecio.setBackground(Color.WHITE);
		btnPrecio.setBounds(900, 50, 120,20);
		ActionListener al = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				window.precioH=Double.parseDouble(tbPrecio.getText());
				repositorioIngresos.setPrecio(conexion.getConection(), window.precioH);
				features.put(window.precioH+"");
			}
		};
		btnPrecio.addActionListener(al);
	}
	public void setVisible(boolean v)
	{
		lblDRC.setVisible(v);
		tbPrecio.setVisible(v);
		btnPrecio.setVisible(v);
		lblTotal.setVisible(v);
		lblTotal.setText("TOTAL: $"+window.ingresoTotal);
		if(window.ingreso.size()!=0)
		{
			definirIngresos();
			for(int i = 0; i<window.ingreso.size(); i++)
			{
				lblIngreso.get(i).setVisible(v);
				lblConcepto.get(i).setVisible(v);
				window.p.add(lblIngreso.get(i));
				window.p.add(lblConcepto.get(i));
			}
		}
		window.p.add(lblTotal);
		window.p.add(btnPrecio);
		window.p.add(tbPrecio);
		window.p.add(lblDRC);
	}
	public void addIngreso(String concepto, double monto)
	{
		ingreso i = new ingreso(concepto, monto);
		window.ingreso.add(i);
		JLabel lblI = new JLabel();
		JLabel lblC= new JLabel();
		lblConcepto.add(lblC);
		lblIngreso.add(lblI);
		window.ingresoTotal+=monto;
	}
	public void definirIngresos()
	{
		int n = lblIngreso.size();
		for(int i=0; i<n; i++)
		{
			lblIngreso.get(i).setLayout(null);
			lblIngreso.get(i).setText("$"+window.ingreso.get(i).getCantidad());
			lblIngreso.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			lblIngreso.get(i).setBounds(550, 100+i*20, 100, 20);
			lblConcepto.get(i).setLayout(null);
			lblConcepto.get(i).setText(window.ingreso.get(i).getConcepto());
			lblConcepto.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			lblConcepto.get(i).setBounds(730, 100+i*20, 100,20);
		}
	}
}
