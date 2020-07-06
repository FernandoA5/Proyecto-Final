package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;

import Main.ventanas;
import Main.window;
import etc.features;

public class barUI {
	
	public static JButton volver = new JButton();
	public static JButton nextDay = new JButton();
	public static JButton lastDay = new JButton();
	
	public barUI()
	{
		//BOTON DE NAVEGACION EN INTERFAZ
		volver.setLayout(null);
		volver.setText("<<");
		volver.setBackground(Color.white);
		volver.setForeground(Color.BLACK);
		volver.setBounds(0, 640, 100, 51);
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//
				int t = window.alU.size();
				//
				ventanas.admU(window.alU.get(t-2));
				
			}
		};
		volver.addActionListener(al);
		//BOTONES NAVEGAR ENTRE DIAS
		//SIGUIENTE
		nextDay.setLayout(null);
		nextDay.setText(">>");
		nextDay.setBackground(Color.WHITE);
		nextDay.setForeground(Color.blue);
		nextDay.setBounds(1180,640,100,51);
		ActionListener alNext = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//SUMAR FECHA
				features.cambiarFecha(1);
				ventanas.admU(0);
				ventanas.admU(1);
			}
		};
		nextDay.addActionListener(alNext);
		//ANTERIOR
		lastDay.setLayout(null);
		lastDay.setText("<<");
		lastDay.setBackground(Color.WHITE);
		lastDay.setForeground(Color.red);
		lastDay.setBounds(1080,640,100,51);
		ActionListener alLast = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				//RESTAR FECHA
				features.cambiarFecha(2);
				ventanas.admU(0);
				ventanas.admU(1);
			}
		};
		lastDay.addActionListener(alLast);
	}
	public void setVisible(boolean v)
	{
		volver.setVisible(v);
		window.p.add(volver);
		
		nextDay.setVisible((window.alU.get(window.alU.size()-1)==1)?v:!v);
		window.p.add(nextDay);
		lastDay.setVisible((window.alU.get(window.alU.size()-1)==1)?v:!v);
		window.p.add(lastDay);
	}
}
