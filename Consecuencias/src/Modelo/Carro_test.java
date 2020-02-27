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
		this.setUbicacionX();
		this.setUbicacionY();
	}
	public int getUbicacionX() {
		return ubicacionX;
	}

	public int getUbicacionY() {
		return ubicacionY;
	}
	
	public void setUbicacionX() {
		int posX = RandomInt.getRandom(0, 14);
		this.ubicacionX = posX;

	}
	
	public void setUbicacionY() {
		int posY = RandomInt.getRandom(0, 14);
		this.ubicacionY = posY;
	}


	

	}
