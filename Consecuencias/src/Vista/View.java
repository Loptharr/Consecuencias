package Vista;

import java.util.Scanner;

import Controlador.Celd;
import Controlador.Controller;
import Controlador.Position;
import Controlador.RandomPosition;
import Modelo.Car1;
import Modelo.Car2;
import Modelo.Car3;
import Modelo.Missile;

public class View {

	static Controller control;
	
	public static void main(String[] args) {
		control = new Controller();
		startGameMenu();
		control.board.__CreateEmptyBoard(15, 15);
		
		
		//Agregar Cars al Board
		for (int i = 0; i < 10; i++) {
			Boolean inserted = false;
			do {
			Car1 car1 = new Car1();
			Position position = RandomPosition.getRandom(0, 14, 0, 14); //AGREGAR MIN X & MAX X Y MIN Y & MAX Y
			inserted = control.board.__TryInsertNewCar(car1, position);
			} while(!inserted);
		}
		
		for (int i = 0; i < 5; i++) {
			Boolean inserted = false;
			do {
				Car2 car2 = new Car2();
				Position position = RandomPosition.getRandom(0, 13, 0, 14); //AGREGAR MIN X & MAX X Y MIN Y & MAX Y
				inserted = control.board.__TryInsertNewCar(car2, position);
			} while(!inserted);
			
		}
		
		for (int i = 0; i < 3; i++) {
			Boolean inserted = false;
			do {
			Car3 car3 = new Car3();
			Position position = RandomPosition.getRandom(0, 14, 0, 12); //AGREGAR MIN X & MAX X Y MIN Y & MAX Y
			inserted = control.board.__TryInsertNewCar(car3, position);
			} while(!inserted);
		}
		
		//Debug para probar disaros
		mostrarMatriz(control.board.__GetBoard());
		
		mostrarMenu();
	}

	public static void startGameMenu() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("---------------");
        System.out.println("START GAME");
        System.out.println("----------------");
        System.out.println("Presiona cualquier numero para continuar");
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
        	 Celd [][] tablero = control.board.__GetBoard();
        	 mostrarMatriz(tablero);
        	 
        	 //Intentando sumar puntos
        	 
        	 int sumScore = 0;
     		//int y = 0;
        	 for (int ix = 0; (ix < tablero.length); ix++) {
        		sumScore = tablero[ix][ix]._score+sumScore;
             	//y++;

//                 for (int iy = 0; (iy < tablero.length); iy++) {
//                	// sumScore = tablero[ix][iy]._score+sumScore;
//                 }
        	 }
        	 mostarPuntaje(sumScore);
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
	
	public static void mostrarMatriz(Celd[][] tablero) {
		for (int i = 0; i < tablero.length; i++) {         //la fila de la matriz.
            for (int j = 0; j < tablero[i].length; j++) {   //la columna de la matriz.
            	if (tablero[i][j]==null) {
            		System.out.print("0" + " ");				//Imprime vacios
				} else {System.out.print(tablero[i][j]._container + " ");}
            }
            System.out.println(); //Cambio de linea.
         }}
}
