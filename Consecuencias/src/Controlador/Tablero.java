package Controlador;

import Modelo.Carro;

public class Tablero {

	private int[][] tablero;


    private final int CAGUANO = 2;
    private final int TRUPALLA = 1;
    private final int KROMI = 3;


    private final int NO_ATACADO = 0;




    public Tablero() {
//
//        this.numeroBarcos = new int[4];
//        this.indHundidos = 0;
//        this.indCreados = 0;
    }

    
    //CREAR MATRIZ
    public void crearTablero(int x, int y) {
        System.out.println("Se va a crear un tablero de " + x + " X " + y);
        System.out.println("");
        this.tablero = new int[x][y];
    }
    
    //ASIGNA VALOR TRUPAllA EN POSICION DE TABLERO
    public void asignarValorTrupalla(int ubicacionX, int ubicacionY, int valor) {
		this.tablero[ubicacionX][ubicacionY]=valor;
	}
       
    //ASIGNA VALOR TRUPAYA EN POSICION DE TABLERO
    public void asignarValorCaguano(int ubicacionX, int ubicacionY, int valor) {
		this.tablero[ubicacionX][ubicacionY]=valor;
		this.tablero[ubicacionX][ubicacionY+1]=valor;
	}
    
    //MUESTRA MATRIZ EN PANTALLA
    public void mostrarTablero() {
    	for (int i = 0; i < this.tablero.length; i++) {         //la fila de la matriz.
            for (int j = 0; j < this.tablero[i].length; j++) {   //la columna de la matriz.
               System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println(); //Cambio de linea.
         }
        }

    public void agregarKromi(Carro kromi) {
    	
    }


	


	


    }




