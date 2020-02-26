package Vista;

import Controlador.RandomInt;
import Controlador.Tablero;
import Modelo.Caguano;
import Modelo.Trupalla;

public class MainTest {

	public static void main(String[] args) {
		
		Tablero tab = new Tablero();
		
		Caguano cag = new Caguano(2,"sda");
		Trupalla trup = new Trupalla (0, "arg");
		
		cag.setUbicacionX();
		cag.setUbicacionY();
		tab.crearTablero(15,15);
		tab.asignarValorTrupalla(trup.getUbicacionX(), trup.getUbicacionY(), 1);
		tab.asignarValorCaguano(cag.getUbicacionX(), cag.getUbicacionY(), 2);
		tab.mostrarTablero();
		
		
	}
	
}
