package Modelo;

public abstract class BaseCar {
    
    public int _sizeCar;
    
    public String _carName;
    
    public String _carKey;
    
    private int _catOcupantes;
    
	private int _fechaIngreso;

	
	public int getCatOcupantes() {
		return _catOcupantes;
	}
	public void setCatOcupantes(int catOcupantes) {
		this._catOcupantes = catOcupantes;
	}
	public int getFechaIngreso() {
		return _fechaIngreso;
	}
	public void setFechaIngreso(int fechaIngreso) {
		this._fechaIngreso = fechaIngreso;
	}
}