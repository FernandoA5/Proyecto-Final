package objetos;

public class gasto {
	private String concepto;
	private double costo;
	public gasto(String conceptoLocal, double costoLocal){
		this.concepto=conceptoLocal;
		this.costo=costoLocal;
	}
	public String getConcepto()
	{
		return this.concepto;
	}
	public double getCosto()
	{
		return this.costo;
	}
	public void setConcepto(String conceptoLocal)
	{
		this.concepto=conceptoLocal;
	}
	public void setCosto(double costoLocal) 
	{
		this.costo = costoLocal;
	}
}
