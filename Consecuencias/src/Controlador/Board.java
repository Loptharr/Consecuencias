package Controlador;

import Modelo.BaseCar;
import Modelo.Missile;

public class Board {
    
    Celd[][] _board;
    
    boolean _isBoardCreated;
    
    public final Celd[][] __GetBoard() {
        return this._board;
    }
    
    public final void __CreateEmptyBoard(int x, int y) {
        this._board = new Celd[x][y];
        for (int ix = 0; (ix < x); ix++) {
            for (int iy = 0; (iy < y); iy++) {
                this._board[ix][iy] = new Celd();
            }
            
        }
        
        this._isBoardCreated = true;
    }
    
    public final boolean __TryInsertNewCar(BaseCar car, Position position) {
        if (!this._isBoardCreated) {  // Tablero no creado
            return false;
        }
   
        if (!this.__IsValidPositionOnBoard(position)) {	// null
            return false;
        }
        
        
        if (!this.__IsThisPositionAvailableForThisCar(car, position)) {	//  message
            return false;
        }
        
        this.__InsertNewCar(car, position);	
        return true;//  message
    }
    
    public final void __InsertNewCar(BaseCar car, Position position) {
        switch (car._sizeCar) {
            case 1:
            	this._board[position._x][position._y]._container = car._carKey;
                break;
            case 2:
                this._board[position._x][ position._y]._container = car._carKey;
                this._board[(position._x)][ position._y+1]._container = car._carKey;
                break;
            case 3:
                this._board[position._x][ position._y]._container = car._carKey;
                this._board[position._x+ 1][(position._y)]._container = car._carKey;
                this._board[position._x+ 2][(position._y )]._container = car._carKey;
                break;
            default:
                break;
        }
    }
    
    private final boolean __IsValidPositionOnBoard(Position position) {
        if ((position._x 
                    > (this._board.length - 1))) {
            return false;
        }
        
        //  overflow
        if ((position._y 
                    > (this._board.length - 1))) {
            return false;
        }
        
        //  overflow
        return true;
    }
    
    private final boolean __IsThisPositionAvailableForThisCar(BaseCar car, Position position) {
        switch (car._sizeCar) {
            case 1:
                if ((this._board[position._x][ position._y]._container != Celd.EMPTY)) {
                    return false;
                }
                
                return true;
              
            case 2:
                if ((position._x 
                            + (car._sizeCar) 
                            > (this._board.length - 1))) {
                    return false;
                }
                
                if ((this._board[position._x][ position._y]._container != Celd.EMPTY)) {
                    return false;
                }
                
                if ((this._board[(position._x + 1)][ position._y]._container != Celd.EMPTY)) {
                    return false;
                }
                
                return true;
               
            case 3:
                if ((position._y
                            + (car._sizeCar)
                            > ((this._board.length - 1)))) {
                    return false;
                }
                
                if ((this._board[position._x][ position._y]._container != Celd.EMPTY)) {
                    return false;
                }
                
                if ((this._board[position._x][ (position._y + 1)]._container != Celd.EMPTY)) {
                    return false;
                }
                
                if ((this._board[position._x][ (position._y + 2)]._container != Celd.EMPTY)) {
                    return false;
                }
                
                return true;
               
            default:
                return false;
                
        }
    }

    public void __InsertMissile(Missile missile)
    {
        if (!__IsValidPositionOnBoard(missile._position)) return;
        _board[missile._position._x][ missile._position._y]._isDestroyed = true;
        switch (_board[missile._position._x][ missile._position._y]._container) {
        case "T":
        	this._board[missile._position._x][ missile._position._y]._container="1";
        	this._board[missile._position._x][ missile._position._y]._score = 1;
        	break;
          
        case "C":
        	this._board[missile._position._x][ missile._position._y]._container="3";
        	this._board[missile._position._x][ missile._position._y]._score = 3;;
        	break;
           
        case "K":
        	this._board[missile._position._x][ missile._position._y]._container="7";
        	this._board[missile._position._x][ missile._position._y]._score = 7;
        	break;
            
        case "0":
        	this._board[missile._position._x][ missile._position._y]._container="X";
        	this._board[missile._position._x][ missile._position._y]._score = 0;
        	break;
           
           
        default:
        	break;
        
    }
}
}







