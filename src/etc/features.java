package etc;

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
}
