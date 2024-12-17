// DNI 29577325S ARIADNA GUILLEN HERNANDEZ
import java.util.*;
import java.io.*;

public class Prim{

    public static Graph getMST(Graph graph, List<Node> path){

        /////// CREACION DEL GRAFO MST ///////
        int tamanyo_grafoParametro = graph.getSize(); // primero se ve cual es el size del grafo que se ha pasado por parametro
        Graph grafo_mst = new Graph(tamanyo_grafoParametro); // y se crea un nuevo grafo con el mismo tamanyo
        Set<Node> nodos_grafoOriginal = new TreeSet<Node>();
        nodos_grafoOriginal = graph.getNode(); // se consiguen todos los nodos del grafo original
        

        for(Iterator<Node> i=nodos_grafoOriginal.iterator(); i.hasNext(); i.next()){ // se recorren todos los nodos que hay en el grafo original

            Node copia_paraAnyadir = nodos_grafoOriginal.get(i).copy(); // se obtiene la copia del nodo actual
            grafo_mst.addNode(copia_paraAnyadir); // y se anyade la copia a los nodos del grafo mst, en el mismo orden que en el grafo original
        }
        //////// NODOS ANYADIDOS, GRAFO MST CREADO ///////

        /////// CREACION DEL VISITED Y SEGUIMIENTO DEL PATH ///////
        Set<Node> visited = new TreeSet<Node>(); // se crea un conjunto de nodos, que va a corresponder a los que han sido visitadps

        for(Iterator<Node> i=nodos_grafoOriginal.iterator(); i.hasNext(); i.next()){ // se recorren todos los nodos que hay en el grafo original

            if(nodos_grafoOriginal.get(i).getId() == 0){ // en caso de que el nodo tenga id 0, se anyade al visited
                
                visited.add(graph.get(0)); // se anyade el principio del grafo al conjunto de visitados
                path.add(graph.get(0)); // y se anyade tambien al path
            }
        }


    }
}