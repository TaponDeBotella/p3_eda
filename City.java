// DNI 29577325S ARIADNA GUILLEN HERNANDEZ
import java.util.*;

public class City{

    private String name;
    private Coordinates coordinates;

    public City(String name, Coordinates coordinates){

        if(name == null){

            this.name = "";
        }else{

            this.name = name;
        }
        
        this.coordinates = coordinates; // el constructor ya hace que la coordenada sea valida
    }

    public Coordinates getCoordinates(){ // devuelve la coordenada

        return coordinates;
    }

    public String getName(){ // devuelve el nombre

        return name;
    }

    public String toString(){ // formato Madrid (3,5)

        String devolver;

        devolver = name + " (" + coordinates.getRow() + "," + coordinates.getCol() + ")";

        return devolver;
    }
}