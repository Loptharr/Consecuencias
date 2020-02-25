package Modelo;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class Caguano extends Carro {

		private float alcance;
		private String color;
		
		public Caguano(float alcance, String color) {
			super();
			this.alcance = alcance;
			this.color = color;
		}

		public float getAlcance() {
			return alcance;
		}

		public void setAlcance(float alcance) {
			this.alcance = alcance;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
		
		@Override 
		public void setUbicacion(int[][] ubicacion) {
			
		}
	
}
