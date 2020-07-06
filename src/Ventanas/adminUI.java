package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Main.window;
import etc.features;

public class adminUI {
	//OBJETOS GLOBALES
		public static vGastos g= new vGastos();
		public static vHabitaciones h = new vHabitaciones();
		public static vIngresos i= new vIngresos();
		public static vBalance b = new vBalance();
		//BOTONES
		public static JButton btnH = new JButton();
		public static JButton btnG = new JButton();
		public static JButton btnI = new JButton();
		public static JButton btnB = new JButton();
	
		//ETIQUETAS
		public static JLabel lblD = new JLabel();
		public static JLabel lblS = new JLabel();
		
		
		
	
	public adminUI()
	{
		//FONDO PANEL BOTONES
		lblD.setLayout(null);
		lblD.setText("PANEL");
		lblD.setOpaque(true);
		lblD.setForeground(Color.DARK_GRAY);
		lblD.setBackground(Color.DARK_GRAY);
		lblD.setBounds(0, 0, 256, 720);
		
		//BOTON HABITACIONES
		btnH.setLayout(null);
		btnH.setText("Habitaciones");
		btnH.setBackground(Color.WHITE);
		btnH.setForeground(Color.GRAY);
		btnH.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		btnH.setBounds(0, 0, 256, 100);
		ActionListener hAl = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(true, 0);
			}
	
		}; btnH.addActionListener(hAl);
		//BOTON GASTOS
		btnG.setLayout(null);
		btnG.setText("Gastos");
		btnG.setBackground(Color.WHITE);
		btnG.setForeground(Color.GRAY);
		btnG.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		btnG.setBounds(0, 100, 256, 100);
		ActionListener gAl = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(true, 1);
			}
		}; btnG.addActionListener(gAl);
		//BOTON INGRESOS
		btnI.setLayout(null);
		btnI.setText("Ingresos");
		btnI.setBackground(Color.WHITE);
		btnI.setForeground(Color.GRAY);
		btnI.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		btnI.setBounds(0, 200, 256, 100);
		ActionListener iAl = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(true, 2);
			}
		}; btnI.addActionListener(iAl);
		//BOTON BALANCE
		btnB.setLayout(null);
		btnB.setText("Balance");
		btnB.setBackground(Color.WHITE);
		btnB.setForeground(Color.GRAY);
		btnB.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		btnB.setBounds(0, 300, 256, 100);
		ActionListener bAl = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(true, 3);
			}	
		}; btnB.addActionListener(bAl);
		
		//PANEL INFORMACION
		lblS.setLayout(null);
		lblS.setText("HOJA");
		lblS.setOpaque(true);
		lblS.setForeground(Color.WHITE);
		lblS.setBackground(Color.WHITE);
		lblS.setBounds(448, 0, 640, 720);	
	}
	
	public void setVisible(boolean v, int o)
	{
		//features.put("ESTO SUCEDE");
		window.p.setBackground(Color.GRAY);
		window.p.add(btnH);
		window.p.add(btnG);
		window.p.add(btnI);
		window.p.add(btnB);
		window.p.add(lblD);
		
		///PANEL DE INFORMACION
		
		//HABITACIONES
		h.setVisible((o==0)?v:!v);
		//GASTOS
		g.setVisible((o==1)?v:!v);
		//INGRESOS
		i.setVisible((o==2)?v:!v);
		//BALANCE
		b.setVisible((o==3)?v:!v);
		
		
			
				
		
		window.p.add(lblS); //DEBE IR AL FINAL
	}
}
