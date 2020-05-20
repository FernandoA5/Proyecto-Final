package objetos;

public class ingreso {
	private String concepto;
	private double cantidad;
	public ingreso(String conceptoLocal, double cantidadLocal)
	{
		this.concepto=conceptoLocal;
		this.cantidad=cantidadLocal;
	}
	public String getConcepto() {
		return this.concepto;
	}
	public double getCantidad()
	{
		return this.cantidad;
	}
	public void setConcepto(String conceptoLocal)
	{
		this.concepto=conceptoLocal;
	}
	public void setCantidad(double cantidadLocal)
	{
		this.cantidad=cantidadLocal;
	}
}
