package Modelo;

public class Car1 extends BaseCar {
    
	private float _nivel_armadura;
    private String _nombre_usuario;
	
    public Car1() {
        this._sizeCar = 1;
        this._carName = "Trupalla";
        this._carKey = "T";
    }
    
    public float getNivel_armadura() {
        return _nivel_armadura;
    }
    public void setNivel_armadura(float nivel_armadura) {
        this._nivel_armadura = nivel_armadura;
    }
    public String getNombre_usuario() {
        return _nombre_usuario;
    }
    public void setNombre_usuario(String nombre_usuario) {
        this._nombre_usuario = nombre_usuario;
    }
    
}