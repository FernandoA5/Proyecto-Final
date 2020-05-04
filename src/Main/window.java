package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class window extends JFrame{
	
	//TAMAÑO VENTANA
	public static final int WIDTH=1280, HEIGHT=720;
	public static boolean running = true;
	//VENTANAS
	private ventanas w1;
	public static JPanel p = new JPanel();
	public window()
	{
		//CONFIGURACION DE VENTANA
		setTitle("Hotel");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void ventanas(int location)
	{
		w1=new ventanas();
		this.getContentPane().add(p);
		if(location==1)
		{
			w1.login();
			
		}
	}
	public static void main(String[] args) {
		new window().start();
	}
	public void start()
	{
		int ventana=1;
		while(running)
		{
			ventanas(ventana);
			running=false;
		}
	}
}
