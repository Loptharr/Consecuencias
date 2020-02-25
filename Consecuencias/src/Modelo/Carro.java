package Modelo;

import java.time.LocalDate;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Controlador.RandomInt;

public abstract class Carro {

	private int catOcupantes;
	private LocalDate fechaIngreso;
	private int[][] ubicacion;
	
	public int getCatOcupantes() {
		return catOcupantes;
	}
	public void setCatOcupantes(int catOcupantes) {
		this.catOcupantes = catOcupantes;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int[][] getUbicacion() {
		int[][] ubicacion = new int[15][15];
		return ubicacion;
	}
	public void setUbicacion(int[][] ubicacion) {
		this.ubicacion = ubicacion;
	}


	

	}
