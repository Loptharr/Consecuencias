package Modelo;

public class Car2 extends BaseCar {
	
	private float _alcance;
	private String _color;
    
    public Car2() {
        _sizeCar = 2;
        _carName = "carro 2";
        _carKey = "B";
    }
    
    public float getAlcance() {
		return _alcance;
	}

	public void setAlcance(float alcance) {
		this._alcance = alcance;
	}

	public String getColor() {
		return _color;
	}

	public void setColor(String color) {
		this._color = color;
	}
    
}