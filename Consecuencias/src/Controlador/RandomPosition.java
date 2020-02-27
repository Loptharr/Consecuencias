package Controlador;

public class RandomPosition {
	
	private int posX;
	private int posY;
	
	public static Position getRandom(int min, int max) {
		RandomInt randintX = new RandomInt();
		int posX = randintX.getRandom(min, max);
		RandomInt randintY = new RandomInt();
		int posY = randintY.getRandom(min, max);
        Position pos = new Position(posX, posY);
		return pos;  
    }
	
	
}
