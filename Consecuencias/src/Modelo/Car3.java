package Modelo;

public class Car3 extends BaseCar {
    
	 private int _anio_fabricacion;
     private String _marca;
	
    public Car3() {
        this._sizeCar = 3;
        this._carName = "carro 3";
        this._carKey = "C";
    }
    
    public int getAnio_fabricacion() {
    		return _anio_fabricacion;
    }



    public void setAnio_fabricacion(int anio_fabricacion) {
    		this._anio_fabricacion = anio_fabricacion;
    }



    public String getMarca() {
    		return _marca;
    }



    public void setMarca(String marca) {
    		this._marca = marca;
    }
        
    
}