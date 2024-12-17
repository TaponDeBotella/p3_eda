// DNI 29577325S ARIADNA GUILLEN HERNANDEZ
import java.util.*;
import java.io.*;
import java.lang.Math;

public class Edge implements Comparable<Edge>{

    private int weight;
    private Node node1;
    private Node node2;

    public Edge(Node node1, Node node2){ // constructor

        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getNode1(){ // devuelve el node1

        return node1;
    }

    public Node getNode2(){ // devuelve el node2

        return node2;
    }

    public int getWeight(){ // devuelve la distancia de Manhattan entre las ciudades de nodo1 y nodo2

        City ciudad1 = node1.getCity(); // se obtienen las dos ciudades
        City ciudad2 = node2.getCity();
        Coordinates coord1 = ciudad1.getCoordinates(); // y las coordenadas
        Coordinates coord2 = ciudad2.getCoordinates();

        //ahora se caluclua el peso 
        // d(c1,c2) = |x1-x2| + |y1-y2| x = ciudad1  y = ciudad2
        int peso = Math.abs(coord1.getRow()-coord2.getRow()) + Math.abs(coord1.getCol()-coord2.getCol());

        return peso;
    }

    public String toString(){ // formato id1 - id2 (peso)

        int peso = this.getWeight();
        String devolver = null;

        devolver = node1.getId() + " - " + node2.getId() + " (" + peso +")";
        
        return devolver;
    }

    public int compareTo(Edge e){

        int devolver = -50;
        int peso1 = this.getWeight();
        int peso2 = e.getWeight();

        if(peso1<peso2){ // si this<e, entonces devuelve -1

            devolver = 1;
        }else if(peso1>peso2){ // si this>e, se devuelve +1

            devolver = +1;
        }else{ // y en caso de que los pesos sean iguales, se comparan las id de las ciudades

            devolver = this.node1.compareTo(e.node1); // primero se compara el nodo1 de this con el de e
            if(devolver==0){ // si siguen siendo iguales, se comparan los nodo2

                devolver = this.node2.compareTo(e.node2);
            }
        }

        return devolver;
    }
}