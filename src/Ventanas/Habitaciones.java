package Ventanas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.window;
import etc.features;

public class Habitaciones {
	public static JLabel lblOcupadas = new JLabel();
	public static JLabel lblDisponibles = new JLabel();
	public static JLabel[] lblH = new JLabel[20];
	
	public Habitaciones()
	{
		lblOcupadas.setLayout(null);
		lblOcupadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcupadas.setText("Ocupadas: "+ (20-features.habitacionesLibres()));
		lblOcupadas.setForeground(Color.BLACK);
		lblOcupadas.setBounds(608, 50, 100, 20);
		lblOcupadas.setVisible(false);
		
		lblDisponibles.setLayout(null);
		lblDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponibles.setText("Disponibles: "+ features.habitacionesLibres());
		lblDisponibles.setForeground(Color.black);
		lblDisponibles.setBounds(768, 50, 100, 20);
		lblDisponibles.setVisible(false);
		//CUADRICULA
		//IMPRIMIR HABITACIONES
		for(int i =0; i<20; i++)
		{
			boolean condicion = window.room.get(i).getEstado();
			lblH[i] = new JLabel();
			lblH[i].setLayout(null);
			lblH[i].setText("Room: " + window.room.get(i).getNumero());
			lblH[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblH[i].setForeground(Color.WHITE);
			lblH[i].setOpaque(true);
			lblH[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
			lblH[i].setBackground((condicion==true)?Color.GREEN:Color.RED);
			lblH[i].setBounds((condicion==true)?608:768, 80+(i*20), 100, 20);	
		}
	}
	public void setVisible(boolean v)
	{
		lblOcupadas.setVisible(v);
		lblDisponibles.setVisible(v);
		lblOcupadas.setText("Ocupadas: "+ (20-features.habitacionesLibres()));
		lblDisponibles.setText("Disponibles: "+ features.habitacionesLibres());
		for(int i=0; i<20; i++)
		{
			lblH[i].setVisible(v);
			if(v)
			{
				boolean condicion = window.room.get(i).getEstado();
				window.p.add(lblH[i]);
				lblH[i].setText("Room: " + window.room.get(i).getNumero());
				lblH[i].setBackground((condicion==true)?Color.GREEN:Color.RED);
				lblH[i].setBounds((condicion==true)?768:608, 80+(i*20), 100, 20);
			}
		}
		window.p.add(lblOcupadas);
		window.p.add(lblDisponibles);
	}
}
