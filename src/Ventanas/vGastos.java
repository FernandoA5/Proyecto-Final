package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.ventanas;
import Main.window;
import etc.repositorioGastos;
import etc.conexion;
import etc.features;
import objetos.gasto;

public class vGastos {
	public static JLabel lblConcepto = new JLabel();
	public static JLabel lblCosto = new JLabel();
	public static JLabel lblTotal = new JLabel();
	public static JTextField tbConcepto = new JTextField();
	public static JTextField tbCosto = new JTextField();
	public static JButton addGasto = new JButton();
	public static ArrayList<JLabel> lblCns = new ArrayList<>();
	public static ArrayList<JLabel> lblCst = new ArrayList<>();
	
	public String concept;  public double cost;
	
	public vGastos()
	{
		repositorioGastos.obtenerGastos(conexion.getConection());
		
		
		//ETIQUETA TOTAL
		lblTotal.setLayout(null);
		lblTotal.setText("TOTAL: ");
		lblTotal.setBounds(950, 650, 200, 20);
		//ETIQUETA CONCEPTO
		lblConcepto.setLayout(null);
		lblConcepto.setText("Concepto: ");
		lblConcepto.setHorizontalAlignment(SwingConstants.CENTER);
		lblConcepto.setBounds(638, 50, 100, 20);
		//TBCONCEPTO
		tbConcepto.setLayout(null);
		tbConcepto.setHorizontalAlignment(SwingConstants.CENTER);
		tbConcepto.setBounds(613,70,150,20);
		
		//ETIQUETA COSTO
		lblCosto.setLayout(null);
		lblCosto.setText("Costo: ");
		lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCosto.setBounds(808, 50, 100, 20);
		//TB COSTO
		tbCosto.setLayout(null);
		tbCosto.setHorizontalAlignment(SwingConstants.CENTER);
		tbCosto.setBounds(783, 70, 150, 20);
		//BOTON AGREGAR GASTO
		addGasto.setLayout(null);
		addGasto.setForeground(Color.BLACK);
		addGasto.setText("Añadir");
		addGasto.setBackground(Color.WHITE);
		addGasto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		addGasto.setBounds(749, 100, 50, 20);
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//AGREGAR GASTO
				concept=tbConcepto.getText();
				try {
					cost = Double.valueOf(tbCosto.getText());
					if(cost!=0)
					{
						gasto g = new gasto(concept, cost);
						window.gasto.add(g);
						window.gastoTotal+=cost;
						//REGISTRAR GASTO EN LA BASE DE DATOS
						repositorioGastos.registrarGasto(conexion.getConection(), concept, cost);
						JLabel tag = new JLabel();
						JLabel tag2 = new JLabel();
						
						lblCns.add(tag);
						lblCst.add(tag2);
						definirGastos();
						window.w1.aUI.setVisible(true, 0); //NO TOCAR!
						window.w1.aUI.setVisible(true, 1); //ESTO RECARGA EL PANEL
					}
				}catch(Exception ex) {
					tbCosto.setText("Ingrese un numero valido");
				}
			}
		};addGasto.addActionListener(al);
		//ESCRITOR DE GASTOS SOLO SE INICIALIZA CADA QUE INICIA EL PROGRAMA.
		//ADQUIRIENDO LOS DATOS DE LA DB.
		for(int i=0; i<window.gasto.size();i++)
		{
			JLabel tag = new JLabel();
			JLabel tag2 = new JLabel();
			lblCns.add(tag);
			lblCst.add(tag2);
		}
		
		if(window.gasto.size()!=0)
		{
			definirGastos();
		}
		
		
		
	}
	public void setVisible(boolean v)
	{
		
		lblCosto.setVisible(v);
		lblConcepto.setVisible(v);
		
		lblTotal.setVisible(v);
		
		tbConcepto.setVisible(v);
		tbCosto.setVisible(v);
		addGasto.setVisible(v);
		int n = window.gasto.size();
		for(int i=0; i<n;i++)
		{
			lblCns.get(i).setVisible(v);
			lblCst.get(i).setVisible(v);
			window.p.add(lblCns.get(i));
			window.p.add(lblCst.get(i));
		}
		lblTotal.setText("TOTAL: $"+window.gastoTotal);
		//definirGastos();
		window.p.add(lblTotal);
		
		window.p.add(addGasto);
		window.p.add(tbCosto);
		window.p.add(tbConcepto);
		window.p.add(lblCosto);
		window.p.add(lblConcepto);
	}
	public void definirGastos()
	{
		int n = lblCns.size();
		
		for(int i=0; i<n; i++)
		{
			lblCns.get(i).setLayout(null);
			lblCns.get(i).setText(window.gasto.get(i).getConcepto());
			lblCns.get(i).setHorizontalAlignment(SwingConstants.CENTER);;
			lblCns.get(i).setBounds(638, 120+i*20, 100,20);
			
			lblCst.get(i).setLayout(null);
			lblCst.get(i).setText("$"+window.gasto.get(i).getCosto()+"");
			lblCst.get(i).setHorizontalAlignment(SwingConstants.CENTER);;
			lblCst.get(i).setBounds(808, 120+i*20, 100, 20);
			
			lblTotal.setText("TOTAL: $"+window.gastoTotal);
		}
	}
}
