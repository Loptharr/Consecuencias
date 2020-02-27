package Controlador;

public class RandomPosition {
	
	private int posX;
	private int posY;
	
	public static Position getRandom(int minX, int maxX, int minY, int maxY) {
		RandomInt randintX = new RandomInt();
		int posX = randintX.getRandom(minX, maxX);
		RandomInt randintY = new RandomInt();
		int posY = randintY.getRandom(minY, maxY);
        Position pos = new Position(posX, posY);
		return pos;  
    }
	
	
}
