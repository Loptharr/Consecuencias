package Modelo;
import Controlador.RandomInt;

public class Trupalla extends Carro {
    
    private float nivel_armadura;
    private String nombre_usuario;
    
    public Trupalla(float nivel_armadura, String nombre_usuario) {
      super();
      this.nivel_armadura = nivel_armadura;
      this.nombre_usuario = nombre_usuario;
  }
  public float getNivel_armadura() {
      return nivel_armadura;
  }
  public void setNivel_armadura(float nivel_armadura) {
      this.nivel_armadura = nivel_armadura;
  }
  public String getNombre_usuario() {
      return nombre_usuario;
  }
  public void setNombre_usuario(String nombre_usuario) {
      this.nombre_usuario = nombre_usuario;
  }
  
 
	
	
  
}