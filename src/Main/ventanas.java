package Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import java.awt.Color;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;

	
public class ventanas {
	
	
	public ventanas()
	{
		
	}
	public void login()
	{
		//PANEL
		window.p.setBackground(Color.DARK_GRAY);
		window.p.setBounds(500, 230, 250, 400);
		
		
		//LABEL
		System.out.println("HOLI");
		JLabel tag=new JLabel("Login");
		tag.setBounds(620, 250, 50, 20);//POSICION Y TAMAÃ‘O
		tag.setForeground(Color.white);//COLOR DE LETRA
		tag.setHorizontalAlignment(SwingConstants.CENTER);//ALINEACION HORIZONTAL
		tag.setVerticalAlignment(SwingConstants.CENTER);//ALINEACION VERTICAL
		window.p.add(tag);
		
		//TEXT BOX
		JTextField tb= new JTextField(16);
		tb.setLayout(null);
		tb.setText("Nombre de usuario");
		tb.setHorizontalAlignment(SwingConstants.CENTER);
		tb.setBorder(null);
		tb.setBounds(550, 280, 200, 20);
		window.p.add(tb);
		JTextField tbP= new JTextField(16);
		tbP.setLayout(null);
		tbP.setText("Contraseña");
		tbP.setHorizontalAlignment(SwingConstants.CENTER);
		tb.setBorder(null);
		tbP.setBounds(550, 310, 200, 20);
		window.p.add(tbP);

		//BUTTON
		JButton btn1 =new JButton();
		btn1.setLayout(null);
		btn1.setText("BOTON");
		btn1.setBounds(600, 350, 100, 30);
		window.p.add(btn1);
		
		
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(java.awt.event.ActionEvent ae) {
				// TODO Auto-generated method stub
				System.out.println("BOTON PRECIONADO");
			}
		};
		btn1.addActionListener(al);

		//window.p.setBorder(BorderFactory.createLineBorder(Color.white));
		
	}
}
