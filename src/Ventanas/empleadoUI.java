package Ventanas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import Main.ventanas;
import Main.window;
import etc.repositorioHabitacion;
import etc.conexion;
import etc.features;
import objetos.habitacion;

public class empleadoUI {
	public empleadoUI() {
		// GENERAR HABITACIONES AL INICIAR EL PROGRAMA
		if (window.room.size() == 0) {
			crearHabitaciones();
			dibujarMasFechas();
		}
	}
	public void setVisible() {
		crearHabitaciones();
		window.p.setBackground(Color.GRAY);
		for (int j = 0; j < window.room.size(); j++) {
			window.room.get(j).setVisible(window.room.get(j).getEstado(), window.sFecha);
		}
	}

	public void crearHabitaciones() {
		for (int p = 0; p < 20; p++)// PAQUETE INCIAL DE VEINTE HABITACIONES FECHA ACTUAL
		{
			habitacion h = repositorioHabitacion.obtenerHabitacion(conexion.getConection(), p + 1, window.sFecha);
			// BUSCANDO EN LA BASE DE DATOS
			if (h.getNumero() == -5 || h.getFecha().equals("25")) {
				// GENERANDO HABIRACIONES SI NO EXISTIAN
				h = new habitacion(p + 1, true, window.sFecha);
				etc.repositorioHabitacion.crearHabitacion(conexion.getConection(), p + 1, window.sFecha);
			}
			// AÑADIENDO HABITACIONES INICIALES
			if (window.room.size() < 20) {
				
				if(h.getId()!=-5)
				{
					window.room.add(h);
				}
				
				if(p==19)
				{
					//CREANDO ELEMENTOS
					int p1=0, vueltas=-1;
					Iterator<habitacion> i = window.room.iterator();
					while(i.hasNext())
					{
							///CALCULAR COORDENADAS
							vueltas = (p1%5==0)?(vueltas+1):(vueltas);
							int r = (256*p1)-(1280*vueltas);
							habitacion sh = i.next();
							sh.dibujar(256, 125, r,vueltas*160);
							p1++;
							window.min = sh.getId();
					}
				}
			}
		}
		dibujarMasFechas();
	}
	public void dibujarMasFechas()
	{
		
		// COMPROBACION PARA AÑADIR MAS SIN REPETIR A LA BASE DE DATOS
				if (window.room.size() >= 20) {
					habitacion h = repositorioHabitacion.obtenerPorFecha(conexion.getConection(), window.sFecha);
					if (h == null) {
						for (int i = 0; i < 20; i++) {
							h = new habitacion(i + 1, true, window.sFecha);
							repositorioHabitacion.crearHabitacion(conexion.getConection(), i + 1, window.sFecha);
						}
					} else {
						//OBTENER HABITACIONES DE NUEVA FECHA
						habitacion nH = null; int n = window.room.size(), contador = 0;
						for(int j=0; j<n; j++)
						{
							contador=0;
							nH = new habitacion(-5, true, "25");
							//BUSCANDO HABITACIONES DE LA FECHA
							nH =repositorioHabitacion.obtenerHabitacion(conexion.getConection(), j+1, window.sFecha);
							for (int i = 0; i < n; i++) {
								if (nH.getId() == window.room.get(i).getId()) {
									contador++; //CONTANDO SI YA EXISTE EN LA LISTA DE OBJETOS
								}
							}
							if (contador == 0) { //SI NO EXISTE SE AÑADE
								if(nH.getId()!=-5)
								{
									window.room.add(nH);
									//
										//if(j==n-1)
										//{
											int p1 = 0, vueltas = -1, nVueltas = -1;
											habitacion dh=null;
											for (int i=0; i<window.room.size(); i++) {
												
												/// CALCULAR COORDENADAS
												vueltas = (p1%5==0)? vueltas+1:vueltas;
												nVueltas = (i%20==0)? nVueltas+1: nVueltas;
												
												int r = (256*p1)-(1280*vueltas);
												int r2 = (160*vueltas)-(640*nVueltas);
												dh=window.room.get(i);
												if(dh.getId()<window.min-20 || dh.getId()>window.min)
												{
													dh.dibujar(256, 125, r,r2);
												}
												p1++;
											}
										//}
								}
							}	
						}
					}
				}
				features.put("Habitaciones: "+window.room.size());
				features.put(window.min+"");
	}
}
