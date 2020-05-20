package Ventanas;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.window;

public class Balance {
	public static JLabel lblDinero = new JLabel();
	public static JLabel lblIngresos = new JLabel();
	public static JLabel lblGastos = new JLabel();
	public static JLabel lblTotal = new JLabel();
	
	public Balance()
	{
		lblDinero.setLayout(null);
		lblDinero.setText("Balance:");
		lblDinero.setHorizontalAlignment(SwingConstants.CENTER);
		lblDinero.setBounds(710, 200, 150, 20);
		
		lblIngresos.setLayout(null);
		lblIngresos.setText("Ingresos: ");
		lblIngresos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresos.setBounds(610, 250, 150, 20);
		
		lblGastos.setLayout(null);
		lblGastos.setText("Gastos: ");
		lblGastos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGastos.setBounds(810, 250, 150, 20);
		
		lblTotal.setLayout(null);
		lblTotal.setText("TOTAL: ");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(710, 300, 150, 20);
	}
	public void setVisible(boolean v)
	{
		lblDinero.setVisible(v);
		lblIngresos.setVisible(v);
		lblIngresos.setText("INGRESOS: $"+window.ingresoTotal);
		lblGastos.setVisible(v);
		lblGastos.setText("GASTOS: $"+window.gastoTotal);
		lblTotal.setVisible(v);
		lblTotal.setText("TOTAL: $" +(window.ingresoTotal-window.gastoTotal));
		lblTotal.setForeground((window.ingresoTotal-window.gastoTotal<0)?Color.RED:Color.BLACK);
		
		window.p.add(lblDinero);
		window.p.add(lblIngresos);
		window.p.add(lblGastos);
		window.p.add(lblTotal);
	}
}
