package Main;

import java.util.Calendar;

import javax.swing.JPanel;

import Ventanas.vLogin;
import Ventanas.empleadoUI;
import etc.features;
import Ventanas.barUI;
import Ventanas.adminUI;

public class ventanas extends JPanel{
	//OBJETOS GLOBALES
	
	//VENTANAS
	public static vLogin lg= new vLogin();
	public static empleadoUI eUI = new empleadoUI();
	public static barUI ui = new barUI();
	public static adminUI aUI = new adminUI();
	
	public ventanas(int u)
	{
		
		
		admU(0);
		
	}
	//ESTA FUNCION GESTIONA LAS VENTANAS
	public static void admU(int u)
	{
		switch(u)
		{
			case 0:
			{
				window.alU.add(0);
				login();
			}
			break;
			case 1:
			{
				window.alU.add(1);
				empleadoUI();
			}
			break;
			case 2:
			{
				window.alU.add(2);
				adminUI();
			}
			break;
			default: System.out.println("404");
		}
	}
	
	public static void login()
	{
		//LIMPIANDO PANTALLA
		window.p.removeAll();
		window.p.repaint();
		//UBICACION
		System.out.println("Login-----------------");
		lg.setVisible(true);
		
	}
	public static void empleadoUI()
	{
		window.p.removeAll();
		//UBICACION
		System.out.println("Empleado--------------");
		eUI.setVisible();
		//BOTONES INTERFAZ
		interfaz();

		window.p.repaint();
	}
	public static void adminUI()
	{
		window.p.removeAll();
		window.p.repaint();
		System.out.println("Admin-----------------");
		interfaz();
		aUI.setVisible(true, 0);
		
				
	}
	public static void interfaz()
	{
		ui.setVisible(true);
	}
	
}
