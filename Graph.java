// DNI 29577325S ARIADNA GUILLEN HERNANDEZ
import java.util.*;
import java.io.*;

public class Graph{

    private List<Node> nodes;
    private int[][] adjacencyMatrix;
    
    public Graph(int size){ // constructor con int

        List<Node> nodes = new ArrayList<Node>(); // se inicializa la lista de nodos con un arraylist
        int[][] adjacencyMatrix = new int[size][size]; // se crea la matriz con el tamanyo pasado por parametro

        for(int i=0; i<size; i++){ // y se rellena toda la matriz con 0
            for(int j=0; j<size; j++){

                adjacencyMatrix[i][j] = 0;
            }
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////7
    public Graph(Map map){ // constructor con map 

        List<Node> nodes = new ArrayList<Node>();
        
    }   

    public void addNode(Node node){

        Node copia_deNodo = node.copy(); // se crea la copia del nodo pasado por parametro, que es el que se quiere anyadir
        int id_enMatriz = -1;
        boolean apto_paraAnyadir = true;
        boolean anyadido = false;

        for(int i=0; i<adjacencyMatrix.length && anyadido==false; i++){ // se recorre la matriz para ver si ya hay un nodo con el mismo id
            for(int j=0; j<adjacencyMatrix.length && anyadido==false; j++){

                id_enMatriz = adjacencyMatrix[i][j]; // se almacena el id actual
                if(id_enMatriz == node.getId()){ // en caso de que ya exista el nodo, no se anyade

                    apto_paraAnyadir = false;
                }

                if(id_enMatriz==0 && apto_paraAnyadir==true){ // si se puede anyadir y llegamos a un sitio de la matriz sin nodo, se anyade la copia

                    adjacencyMatrix[i][j] = copia_deNodo.getId(); // se pone el id en la matriz
                    nodes.add(copia_deNodo); // y se mete a la lista de nodos
                    anyadido = true;
                }
            }
        }
    }

    public Node getNode(int id){ // se devuelve el nodo con el id que ha pasado el usuario

        Node devolver = null;
        boolean encontrado = false;

        for(int i=0; i<nodes.size() && encontrado==false; i++){ // se recorre la matriz para ver si ya hay un nodo con el mismo id
            
            Node nodo_actual = nodes.get(i);
            if(nodo_actual.getId() == id){ // en caso de que coincidan los ids, se almacena para devolver el nodo

                devolver = nodo_actual;
                encontrado=true;
            }           
        }

        return devolver;
    }

    public boolean edgeExist(int id1, int id2){ 

        boolean devolver = false;
        int peso_arista;
        Node n1 = null;
        Node n2 = null;
        Node nodo_actual = null;

        for(int i=0; i<nodes.size() && devolver==false; i++){ // se buscan los nodos, para ver si existen

            nodo_actual = nodes.get(i); // se consigue el nodo actual
            if(nodo_actual.getId() == id1){

                n1 = nodo_actual; // en caso de que coincidan las ids, se almacena el nodo
            }else if(nodo_actual.getId() == id2){

                n2 = nodo_actual;
            }

            if(n1!=null && n2!=null){ // para salir del bucle
                devolver = true;
            }
            
        }

        devolver = false; // se vuelve a poner a false

        if(n1!=null && n2!=null){ // en caso de que existan los nodos, se procede

            Edge arista = new Edge(n1,n2); // se crea la arista con los nodos que se han conseguido
            peso_arista = arista.getWeight(); // y se llama al metodo que consigue su peso

            if(peso_arista!=0){ // si el peso es distinto de 0, entonces estan conectados y existe la arista

                devolver = true;
            }
        }

        return devolver;
    }

    public void setEdge(int id1, int id2, int weight){ ////////////////////////////////////////////////////////////////////////////////////
        
        boolean salir = false;
        Node n1 = null;
        Node n2 = null;
        Node nodo_actual = null;

        for(int i=0; i<nodes.size() && salir==false; i++){ // se buscan los nodos, para ver si existen

            nodo_actual = nodes.get(i); // se consigue el nodo actual
            if(nodo_actual.getId() == id1){

                n1 = nodo_actual; // en caso de que coincidan las ids, se almacena el nodo
            }else if(nodo_actual.getId() == id2){

                n2 = nodo_actual;
            }

            if(n1!=null && n2!=null){ // para salir del bucle
                salir = true;
            }
        }

        if(n1!=null && n2!=null){ // en caso de que ningun nodo sea nulo, se sigue con el metodo
            for(int i=0; i<adjacencyMatrix.length; i++){ // se recorre la matriz para ver donde hay que anyadir el peso de la arista
                for(int j=0; j<adjacencyMatrix.length; j++){

///////////////////////// COMO SE DONDE PONER EL PESO QUE ME HAN DADO POR PARAMETRO?????????? /////////////////////////////////////////777

                }
            }
        }
    }

    public int getSize(){ // devuelve el numero total de nodos que hay en el grafo

        int tamanyo = nodes.size();
        return tamanyo;
    }

    public int getWeight(int id1, int id2){

        int peso_arista = 0;
        boolean salir = false;
        Node n1 = null;
        Node n2 = null;
        Node nodo_actual = null;

        for(int i=0; i<nodes.size() && salir==false; i++){ // se buscan los nodos, para ver si existen

            nodo_actual = nodes.get(i); // se consigue el nodo actual
            if(nodo_actual.getId() == id1){

                n1 = nodo_actual; // en caso de que coincidan las ids, se almacena el nodo
            }else if(nodo_actual.getId() == id2){

                n2 = nodo_actual;
            }

            if(n1!=null && n2!=null){ // para salir del bucle
                salir = true;
            }            
        }

        if(n1!=null && n2!=null){ // en caso de que existan los nodos, se procede

            Edge arista = new Edge(n1,n2); // se crea la arista con los nodos que se han conseguido
            peso_arista = arista.getWeight(); // y se llama al metodo que consigue su peso
        }

        return peso_arista;
    }

    public Set<Node> getNode(){ // devuelve un conjunto con todos lo elementos del grafo
    
        Set<Node> devolver = new TreeSet<Node>(); // se crea el Set a devolver
        devolver.addAll(nodes); // y se anyaden al Set todos los nodos de la lista nodes

        return devolver;
    }

    public Set<Edge> getEdges(int id){

        Set<Edge> devolver = new TreeSet<Edge>(); // se crea el Set que se devolvera
        Node nodo_aComparar = this.getNode(id); // se consigue el nodo con el metodo getNode
        boolean existe_arista = false;

        if(nodo_aComparar!=null){ // en caso de que el nodo exista, se sigue
            for(int i=0; i<nodes.size(); i++){ // ahora se recorre toda la lista de nodos, y con el nodo a comprar se buscan las aristas que existen
                if(nodo_aComparar!=nodes.get(i)){ // se comprueba que no son el mismo nodo

                    int id1 = nodo_aComparar.getId();
                    int id2 = nodes.get(i).getId();
                    existe_arista = edgeExist(id1,id2); // con el meto se conprueba si la arista existe o no
                }  

                if(existe_arista==true){
                    Edge arista_aAnyadir = new Edge(nodo_aComparar, nodes.get(i)); // se crea la arista que se va a anyadir al Set
                    devolver.add(arista_aAnyadir); // se anyade al Set a devolver el nodo que tiene una arista con el nodo pasado por parametro
                }              
            }
        }

        return devolver;
    }

    /* public PriorityQueue<Edge> getPendingEdges(Set<Node> origins){ //////////////////////////////////////////////////////////////////////////////


    } */

    public int[][] getMatrix(){ // devuelve la matriz de adyacencia

        return adjacencyMatrix;
    }

    public String toString(){ // formato que hay en la imaegn de la practica 3

        String devolver = null;

        devolver = "Nodos:\n";

        for(int i=0; i<nodes.size(); i++){ // se recorre todos los nodos para imprimir sus ciudades segun el formato de Node

            Node nodo_imprimir = nodes.get(i);
            devolver = devolver + nodo_imprimir + "\n";
        }

        devolver = devolver + "\n" + "Matriz de adyacencia:\n"; // separaccion entre las ciudades de los nodos y la matriz

        for(int x=0; x<adjacencyMatrix.length; x++){ // se recorre la matriz imprimirla
            for(int y=0; y<adjacencyMatrix.length; y++){

                devolver = devolver + adjacencyMatrix[x][y] + " ";
            }

            devolver = devolver + "\n";
        }

        return devolver;
    }
}