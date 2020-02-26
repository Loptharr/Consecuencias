package Modelo;


import Controlador.RandomInt;

public abstract class Carro {

	private int catOcupantes;
	private int fechaIngreso;
	protected int ubicacionX;
	protected int ubicacionY;
	
	public int getCatOcupantes() {
		return catOcupantes;
	}
	public void setCatOcupantes(int catOcupantes) {
		this.catOcupantes = catOcupantes;
	}
	public int getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(int fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
//	public int[][] getUbicacion() {
//		int[][] ubicacion = new int[13][15];
//		return ubicacion;
//	}
	
	
	public void setUbicacion() {
		// TODO Auto-generated method stub
		
	}
	public int getUbicacionX() {
		return ubicacionX;
	}
	public void setUbicacionX() {
		
	}
	public int getUbicacionY() {
		return ubicacionY;
	}
	public void setUbicacionY() {
		
	}
	


	

	}
