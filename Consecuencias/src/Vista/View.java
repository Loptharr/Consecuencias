package Vista;

import java.util.Scanner;

import Controlador.Controller;
import Controlador.Position;
import Controlador.RandomPosition;
import Modelo.Car1;
import Modelo.Missile;

public class View {

	static Controller control;
	
	public static void main(String[] args) {
		control = new Controller();
		startGameMenu();
		control.board.__CreateEmptyBoard(15, 15);
		
		for (int i = 0; i < 3; i++) {
			Car1 car1 = new Car1();
			Position position = RandomPosition.getRandom(0, 12);
			control.board.__TryInsertNewCar(car1, position);
		}
		
		for (int i = 0; i < 5; i++) {
			
		}
		
		for (int i = 0; i < 10; i++) {
			
		}
		
		control.board.__TryInsertNewCar(car, position);
		mostrarMenu();
	}

	public static void startGameMenu() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("---------------");
        System.out.println("START GAME");
        System.out.println("----------------");
        System.out.println("Presiona cualquier tecla para continuar");
        int opcion = teclado.nextInt();
	}
	
	public static void mostrarMenu() {
		Scanner teclado = new Scanner(System.in);

         System.out.println("1) Disparar huevos");
         System.out.println("2) Salir (mostar tablero y puntaje)");
         System.out.println("----------------");
         System.out.println("Seleccionar opción : ");
         int opcion = teclado.nextInt();

		mandarOpcion(opcion);
    
         
	} 
	
	public static void mandarOpcion(int n) {
		 switch (n) {
         case 1:
        	 System.out.println("Marcaste 1");
        	 Position pos = preguntaCoordenadas();   
        	 Missile huevo = new Missile(pos);
        	 control.board.__InsertMissile(huevo);
        	 mostrarMenu();
        	 break;
         case 2:
        	 System.out.println("Marcaste 2");
        	 int [][] tablero = new int [15][15];
        	 mostrarMatriz(tablero);
        	 mostarPuntaje(150);
        	 break;
         default:
        	 System.out.println("Seleccionar opción válida (1/5): ");
        	 mostrarMenu();
        	 break;
 
	}
	}
	
	private static void mostarPuntaje(int puntos) {
		System.out.println("Tu puntaje totale es:" + puntos);
	}

	public static Position preguntaCoordenadas() {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("ingresa ubicaccion X");
        int posX = teclado.nextInt();
        System.out.println("ingresa ubicaccion Y");
        int posY = teclado.nextInt();
        Position pos = new Position(posX,posY);
		return pos;
	}
	
	public static void mostrarMatriz(int matriz[][]) {
		for (int i = 0; i < matriz.length; i++) {         //la fila de la matriz.
            for (int j = 0; j < matriz[i].length; j++) {   //la columna de la matriz.
            	if (matriz[i][j]==0) {
            		System.out.print("0" + " ");				//Imprime vacios
				} else {System.out.print(matriz[i][j] + " ");}
            }
            System.out.println(); //Cambio de linea.
         }}
}
