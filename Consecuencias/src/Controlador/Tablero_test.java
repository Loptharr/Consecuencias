package Controlador;

import Modelo.Caguano;
import Modelo.Carro;
import Modelo.Kromi;
import Modelo.Trupalla;

public class Tablero {

	private String[][] tablero;


    private final String CAGUANO = "C";
    private final String TRUPALLA = "T";
    private final String KROMI = "K";


    private final String VACIO = "0";
    private final String HIT = "X";




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
        this.tablero = new String[x][y];
    }
    
    //ASIGNA VALOR TRUPAllA EN POSICION DE TABLERO
    public void asignarValorTrupalla(int ubicacionX, int ubicacionY) {
		this.tablero[ubicacionX][ubicacionY]=TRUPALLA;
	}
       
    //ASIGNA VALOR CAGUANO EN POSICION DE TABLERO
    public void asignarValorCaguano(int ubicacionX, int ubicacionY) {
		this.tablero[ubicacionX][ubicacionY]=CAGUANO;
		this.tablero[ubicacionX][ubicacionY+1]=CAGUANO;
	}
    
  //ASIGNA VALOR KROMI EN POSICION DE TABLERO
    public void asignarValorKromi(int ubicacionX, int ubicacionY) {
		this.tablero[ubicacionX][ubicacionY]=KROMI;
		this.tablero[ubicacionX+1][ubicacionY]=KROMI;
		this.tablero[ubicacionX+2][ubicacionY]=KROMI;
	}
    
    //MUESTRA MATRIZ EN PANTALLA
    public void mostrarTablero() {
    	for (int i = 0; i < this.tablero.length; i++) {         //la fila de la matriz.
            for (int j = 0; j < this.tablero[i].length; j++) {   //la columna de la matriz.
            	if (this.tablero[i][j]==null) {
            		System.out.print(VACIO + " ");				//Imprime vacios
				} else {System.out.print(this.tablero[i][j] + " ");}
            }
            System.out.println(); //Cambio de linea.
         }
        }

  //REVISA QUE LA POSICION DE TRUPAllA EN TABLERO ESTÉ LIBRE
    public boolean EspacioTrupallaLibre(int ubicacionX,int ubicacionY,Trupalla trup) {
    	boolean estaLibre = false;
    	if (this.tablero[ubicacionX][ubicacionY]==null) {
    		estaLibre = true;
		} else {estaLibre = false;}
	return estaLibre;
    }

  //REVISA QUE LA POSICION DE CAGUANO EN TABLERO ESTÉ LIBRE
    public boolean EspacioCaguanoLibre(int ubicacionX,int ubicacionY,Caguano cagu) {
    	boolean estaLibre = false;
    	if (this.tablero[ubicacionX][ubicacionY]==null && this.tablero[ubicacionX][ubicacionY+1]==null) {
    		estaLibre = true;
		} else {estaLibre = false;}
	return estaLibre;
    }


  //REVISA QUE LA POSICION DE KROMI EN TABLERO ESTÉ LIBRE
    public boolean EspacioKromiLibre(int ubicacionX,int ubicacionY,Kromi krom) {
    	boolean estaLibre = false;
    	if (this.tablero[ubicacionX][ubicacionY]==null && this.tablero[ubicacionX+1][ubicacionY]==null && this.tablero[ubicacionX+2][ubicacionY]==null) {
    		estaLibre = true;
		} else {estaLibre = false;}
	return estaLibre;
    }


    }




