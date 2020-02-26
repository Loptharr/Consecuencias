package Modelo;

import Controlador.RandomInt;

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
		
		public void setUbicacionX() {
			int posX = RandomInt.getRandom(0, 14);
			this.ubicacionX = posX;

		}
		
		public void setUbicacionY() {
			int posY = RandomInt.getRandom(0, 13);
			this.ubicacionY = posY;
		}
		
	
		
	
	
	
}
