package Controlador;

public class RandomInt {

	    public static int getRandom(int min, int max) {
	        int rango = max - min + 1;
	        return (int) (Math.random() * rango) + min;
	    }

}
