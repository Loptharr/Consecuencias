package Modelo;

public class Kromi extends Carro {
    
    private int anio_fabricacion;
    private String marca;
    
    
    
	public Kromi() {
		super();
	}



	public Kromi(int anio_fabricacion, String marca) {
		super();
		this.anio_fabricacion = anio_fabricacion;
		this.marca = marca;
	}



	public int getAnio_fabricacion() {
		return anio_fabricacion;
	}



	public void setAnio_fabricacion(int anio_fabricacion) {
		this.anio_fabricacion = anio_fabricacion;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}
    
    
    
}
