package Modelo;

import java.time.LocalDate;
import java.time.Month;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public abstract class Carro {

	private int catOcupantes;
	private LocalDate fechaIngreso;
	private Array[] ubicacion;
	
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
	public Array[] getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Array[] ubicacion) {
		this.ubicacion = ubicacion;
	} 


	
	
}
