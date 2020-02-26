package Vista;

import Controlador.RandomInt;
import Controlador.Tablero;
import Modelo.Caguano;
import Modelo.Kromi;
import Modelo.Trupalla;

public class MainTest {

	public static void main(String[] args) {
		//CREO TABLERO NULL
		Tablero tab = new Tablero();
		
		//CREO OBJETOS DE CARROS
		Caguano cag = new Caguano(2,"sda");
		cag.setUbicacion();
		
		Trupalla trup = new Trupalla (0, "arg");
		trup.setUbicacion();
		
		Kromi krom = new Kromi (1998,"mazda");
		krom.setUbicacion();
		
		//CREO TABLERO DE LAS DIMENSIONES INGRESADAS
		tab.crearTablero(15,15);
		
		//ASIGNO VALOR DE CARRO EN EL TABLERO (UBICO LOS CARROS EN LA MATRIZ)
		tab.asignarValorTrupalla(trup.getUbicacionX(), trup.getUbicacionY());
		tab.asignarValorCaguano(cag.getUbicacionX(), cag.getUbicacionY());
		tab.asignarValorKromi(krom.getUbicacionX(), krom.getUbicacionY());
		
		//IMPRIMO TABLERO
		tab.mostrarTablero();
		
		
	}
	
}
