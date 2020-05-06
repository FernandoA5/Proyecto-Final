package Main;


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
	}
	public void ventanas(int location)
	{
		w1=new ventanas();
		p.setLayout(null);
		if(location==1)
		{
			w1.login();
			
		}
		this.getContentPane().add(p);
		this.setVisible(true);
		System.out.println("...");
	}
	public static void main(String[] args) {
		new window().start();
	}
	public void start()
	{
		while(running)
		{
			ventanas(1);
			running=false;
		}
	}
}
