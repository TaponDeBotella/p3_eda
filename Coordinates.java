// DNI 29577325S ARIADNA GUILLEN HERNANDEZ
import java.util.*;
import java.lang.Math;

public class Coordinates{

    private int row;
    private int col;

    public Coordinates(int row, int col){ // constructor de Coordinates

        if(row >=0){ // 0 en caso de que sea coordenada invalida

            this.row = row;
        }else{

            this.row = -1;
            this.col = -1;
        }

        if(col >=0){ // 0 en caso de que sea coordenada invalida

            this.col = col;
        }else{

            this.col = -1;
            this.row = -1;
        }
    }

    public int getRow(){ // devuelve el valor de row

        return row;
    }

    public int getCol(){ // devuelve el valor de col

        return col; 
    }

    public int distance(Coordinates c){ // calcula la distancia de Manhattan entre dos coordenadas

        int devolver;
        // d(c1,c2) = |x1-x2| + |y1-y2| x = this  y = parametro        
        devolver = Math.abs(this.row - c.row) + Math.abs(this.col - c.col);

        return devolver;
    }

    public String toString(){ // formato (row,col)

        String devolver;
        devolver = "(" + row + "," + col + ")";

        return devolver;
    }
}