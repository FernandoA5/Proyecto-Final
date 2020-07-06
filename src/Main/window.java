package Main;


import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

import etc.conexion;
import etc.features;
import objetos.habitacion;
import objetos.gasto;
import objetos.ingreso;
public class window extends JFrame{
	//CONTROL DE UBICACION EN VENTANA Y FECHA
	public static ArrayList<Integer> alU = new ArrayList<Integer>();
	public static Calendar fecha = Calendar.getInstance();
	public static String sFecha;
	public static String fechaActual;
	//CONEXION
	public static conexion con = new conexion();
	public static ArrayList<ArrayList<habitacion>> hDias = new ArrayList<ArrayList<habitacion>>();
	//OBJETOS ADMINISTRATIVOS
	public static ArrayList<habitacion> room = new ArrayList<habitacion>();
	public static ArrayList<gasto> gasto = new ArrayList<gasto>();
	public static ArrayList<ingreso> ingreso= new ArrayList<ingreso>(); 
	public static double gastoTotal=0; ///INICIALIZAR DE lA BASE DE DATOS
	public static double ingresoTotal=0; ///INICIALIZAR DE LA BASE DE DATOS
	public static double precioH=-5; //INICIALIZAR DE LA BASE DE DATOS
	public static int contadorGlobal=0;
	public static features f = new features();
	
	public static int listeners = 0;
	public static int min =0;
	
	//TAMAÑO VENTANA
	public static final int WIDTH=1280, HEIGHT=720;
	public static boolean running = true;
	//VENTANAS
	public static ventanas w1;
	public static JPanel p = new JPanel();
	
	public window()
	{
		//CONFIGURACION DE VENTANA
		setTitle("Hotel");
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	public void ventanas(int u)
	{
		w1=new ventanas(0);
		p.setLayout(null);
		this.getContentPane().add(p);
		this.setVisible(true);
		System.out.println("...");
	}
	public static void main(String[] args) {
		features.obtenerFechaInicial();
		new window().start();
		
		
	}
	public void start()
	{
		while(running)
		{
			ventanas(0);
			running=false;
		}
	}
}
