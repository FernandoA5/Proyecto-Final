package Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.JButton;

	
public class ventanas {
	
	
	public ventanas()
	{
		
	}
	public void login()
	{
		//PANEL
		window.p.setBackground(Color.DARK_GRAY);
		
		//LABEL
		System.out.println("HOLI");
		JLabel tag=new JLabel("Login");
		tag.setBounds(620, 20, 50, 20);//POSICION Y TAMAÑO
		tag.setForeground(Color.white);//COLOR DE LETRA
		tag.setHorizontalAlignment(SwingConstants.CENTER);//ALINEACION HORIZONTAL
		tag.setVerticalAlignment(SwingConstants.CENTER);//ALINEACION VERTICAL
		window.p.add(tag);
		
		//BUTTON
		JButton btn1 =new JButton();
		btn1.setLayout(null);
		btn1.setText("BOTON");
		btn1.setBounds(600, 100, 100, 30);
		window.p.add(btn1);
		//btn.addActionListener(this);
		
		//TEXT BOX
		JTextField tb= new JTextField(16);
		tb.setLayout(null);
		tb.setBounds(550, 40, 200, 20);
		window.p.add(tb);
	}
}
