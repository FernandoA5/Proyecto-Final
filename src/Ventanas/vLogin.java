package Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Main.ventanas;
import Main.window;

public class vLogin {
	//OBJETOS GLOBALES
	public static JButton btn1 =new JButton();
	public static JLabel tag=new JLabel("Login");
	public static JTextField tb= new JTextField(16);
	public vLogin()
	{
		//PANEL
		window.p.setBackground(Color.DARK_GRAY);
		
		//LABEL
		tag.setBounds(620, 250, 50, 20);//POSICION Y TAMAÑO
		tag.setForeground(Color.white);//COLOR DE LETRA
		tag.setHorizontalAlignment(SwingConstants.CENTER);//ALINEACION HORIZONTAL
		tag.setVerticalAlignment(SwingConstants.CENTER);//ALINEACION VERTICAL
		
		
		//TEXT BOX
		tb.setLayout(null);
		tb.setText("Clave");
		tb.setHorizontalAlignment(SwingConstants.CENTER);
		tb.setBorder(null);
		tb.setBounds(550, 280, 200, 20);
		
		//BUTTON
		btn1.setLayout(null);
		btn1.setText("Ingresar");
		btn1.setBackground(Color.GREEN);
		btn1.setForeground(Color.WHITE);
		btn1.setBounds(600, 350, 100, 30);
		
		
		
		ActionListener al = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = tb.getText();
				
				if(text.equals("asdfg"))
				{
					ventanas.admU(1);
				}
				else if(text.equals("qwerty")){
					ventanas.admU(2);
				}
				else {
					btn1.setBackground(Color.RED);
					btn1.setForeground(Color.WHITE);
				}
			}
		};
		btn1.addActionListener(al);
	}
	public void start()
	{
		
	}
	public void setVisible(boolean v)
	{
		window.p.setBackground(Color.DARK_GRAY);
		tag.setVisible(v);
		window.p.add(tag);
		tb.setVisible(v);
		window.p.add(tb);
		btn1.setVisible(v);
		window.p.add(btn1);
	}
}
