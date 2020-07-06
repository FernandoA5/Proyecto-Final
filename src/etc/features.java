package etc;

import java.util.Calendar;

import Main.window;

public class features {
	public features()
	{
		
	}
	public static void put(String texto)
	{
		System.out.println(texto);
	}
	public static int habitacionesLibres()
	{
		int h=0;
		if(!window.room.isEmpty())
		{
			for(int i=0;i<20;i++)
			{
				h+=(window.room.get(i).getEstado()==true)?1:0;
			}
		}
		else
			features.put("Aun no se han iniciado las habitaciones");
		
		
		return (window.room.isEmpty()==true)?20:h; 
	}
	public static void obtenerFechaInicial()
	{
		//OBTENER FECHA DEL DIA
		int dia = window.fecha.get(Calendar.DAY_OF_MONTH);
		int mes = window.fecha.get(Calendar.MONTH)+1;
		int year = window.fecha.get(Calendar.YEAR);
		features.put(dia+"/"+mes+"/"+year);
		String fComp = dia+"/"+mes+"/"+year;
		window.sFecha=fComp;
		window.fechaActual = window.sFecha;
	}
	public static void cambiarFecha(int op)
	{
		int nD=0, nM=0, nY=0;
		String[] partesFecha = window.sFecha.split("/");
		int dia = Integer.parseInt(partesFecha[0]); 
		int mes = Integer.parseInt(partesFecha[1]);
		int year = Integer.parseInt(partesFecha[2]);
			int n=0;
			
			n = controlDeMes(mes, year);
			if(op==1)
			{
				nD = (dia==n)?1:dia+1;
				nM = (nD==1)?mes++:mes; 
				nY = (nM==13)?year++:year;
				nM = (nM==13)?1:mes;
			}
			else {
				nD = (dia==1)?controlDeMes(mes-1, year):dia-1;
				nM = (nD==controlDeMes(mes-1, year)?mes--:mes);
				nY = (nM==0)? year--:year;
				nM = (nM==0)?12:mes;
			}
			
			String nuevaFecha = nD+"/"+nM+"/"+year;
			window.sFecha=nuevaFecha;
	}
	public static int controlDeMes(int mes, int year)
	{
		int n;
		if(mes == 4 || mes == 6 || mes == 9 || mes ==11 ) //MESES CON 30 DIAS
		{
			n = 30;
			
		}
		else if(mes ==2 && year%4!=0) //FEBRERO
		{
			n=28;
		}
		else if(mes == 2 && year%4==0) //FEBRERO BISIESTO
		{
			n = 29;
		}
		else { //MESES CON 31 DIAS
			n=31;
		}
		return n;
	}
}
