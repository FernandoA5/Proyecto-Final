package Ventanas;

import java.awt.Color;
import java.util.Iterator;
import Main.window;
import etc.RepositorioHabitacion;
import etc.conexion;
import etc.features;
import objetos.habitacion;

public class empleadoUI {
	public empleadoUI()
	{
		//GENERAR HABITACIONES
		if(window.room.size()!=20)
		{
			//SACAR HABITACIONES DE LA BASE DE DATOS
			for(int p=0;p<20;p++)
			{
				habitacion h =RepositorioHabitacion.obtenerHabitacion(conexion.getConection(), p+1); 
				//BUSCANDO EN LA BASE DE DATOS
				if(h.getNumero()==-5)
				{
					h = new habitacion(p+1, true);
					etc.RepositorioHabitacion.crearHabitacion(conexion.getConection(), p+1);
				}
				window.room.add(h);
			}
		}
		//CREANDO ELEMENTOS
		int p=0, vueltas=-1;
			Iterator<habitacion> i = window.room.iterator();
			while(i.hasNext())
			{
					///CALCULAR COORDENADAS
					vueltas = (p%5==0)?(vueltas+1):(vueltas);
					int r = (256*p)-(1280*vueltas);
					habitacion h = i.next();
					h.dibujar(256, 125, r,vueltas*160);
					p++;
			}
	}
	public void setVisible()
	{
		window.p.setBackground(Color.GRAY);
		
		for(int j = 0; j<20; j++)
		{
			window.room.get(j).setVisible(window.room.get(j).getEstado());
		}
	}
}
