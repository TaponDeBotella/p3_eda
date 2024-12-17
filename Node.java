// DNI 29577325S ARIADNA GUILLEN HERNANDEZ
import java.util.*;
import java.io.*;

public class Node implements Comparable<Node>{

    private int id;
    private City city;

    public Node(int id, City city){ // constructor

        if(id>=0){
            this.id = id;
        }else{
            id = -1;
        }

        if(city != null){
            this.city = city;
        }else{
            String a = "";
            Coordinates b = new Coordinates(-1,-1);
            this.city = new City(a,b); // se crea una city invalida
        }
    }

    public int getId(){ // devuelve el id del nodo

        return id;
    }

    public City getCity(){ // devuelve la ciudad del nodo

        return city;
    }
 
    public String toString(){ // formato: id: ciudad (row,col)

        String devolver = null;

        devolver = id + ": " + city;
        
        return devolver;
    }

    public Node copy(){ // devuelve una copia del nodo (id y ciudad)

        int identificador = this.id;
        Coordinates coord_this = this.city.getCoordinates();
        Coordinates coord = new Coordinates(coord_this.getRow(),coord_this.getCol()); // se crea la nueva coordenada, que es la misma de la ciudad de this
        String nombre_ciudad = this.city.getName(); // y se obtiene el noombre de la ciudad tambien
        
        City ciudad_copia = new City(nombre_ciudad,coord); // se crea la ciudad copia
        Node nodo_devolver = new Node(identificador,ciudad_copia); // y por ultimo se crea el nodo copia
    
        return nodo_devolver;
    }

    public int compareTo(Node n){ // si this < n devuelve -1, si es igual devuelve 0, y si es mayo devuelve +1

        int devolver = -50;

        if(this.id < n.id){ // en caso de que this sea menor

            devolver = -1;
        }else if(this.id == n.id){ // si son iguales

            devolver = 0;
        }else{ // si this es mayor

            devolver = +1;
        }

        return devolver;
    }
}