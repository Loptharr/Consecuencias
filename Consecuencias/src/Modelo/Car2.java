package Modelo;

public class Car2 extends BaseCar {
	
	private float _alcance;
	private String _color;
    
    public Car2() {
        this._sizeCar = 2;
        this._carName = "Caguano";
        this._carKey = "C";
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