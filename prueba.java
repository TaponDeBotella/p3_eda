import java.util.*;

public class prueba{

    public static void main(String[] args){

        // se declaran dos coordenadas, una con numeros validos y otra con un numero negativo
       // Coordinates coordenadas1 = new Coordinates(5,4);
       // Coordinates coordenadas2 = new Coordinates(3,-1);

        // se muestran por pantalla las dos coordenadas
       // System.out.println("Coordenada 1: ("+coordenadas1.getRow()+", "+coordenadas1.getCol()")");
       // System.out.println("Coordenada 2: ("+coordenadas2.getRow()+", "+coordenadas2.getCol()")");
       // System.out.println();

        // se calcula la distancia entre las dos coordenadas
        //int distancia;
        
       // distancia = coordenadas1.distance(coordenadas2);
        //System.out.println("Distancia entre las dos coordenadas: "+distancia);
    
    
        // CREAR Y MOSTRAR NODOS
        Coordinates coordenadas1 = new Coordinates(5,4);
        Coordinates coordenadas2 = new Coordinates(3,1);
        City ciudad1 = new City("Madrid", coordenadas1);
        City ciudad2 = new City("Barcelona", coordenadas2);

        //System.out.println("Primero se printean las coordenadas");
        String coord1 = coordenadas1.toString();
        String coord2 = coordenadas2.toString();
        //System.out.println(coord1);
        //System.out.println(coord2);

        //System.out.println("Ahora las ciudades");
        String ciu1 = ciudad1.toString();
        String ciu2 = ciudad2.toString();
        //System.out.println(ciu1);
        //System.out.println(ciu2);

        System.out.println("Ahora los nodos");
        Node nodo1 = new Node(20,ciudad1);
        Node nodo2 = new Node(44,ciudad2);
        String n1 = nodo1.toString();
        String n2 = nodo2.toString();
        System.out.println(n1);
        System.out.println(n2);

        Coordinates coordenadas3 = new Coordinates(2,7);
        Coordinates coordenadas4 = new Coordinates(9,10);
        City ciudad3 = new City("Alicante", coordenadas3);
        City ciudad4 = new City("Murcia", coordenadas4);
        Node nodo3 = new Node(10, ciudad3);
        Node nodo4 = new Node(15, ciudad4);

        int comp1 = nodo1.compareTo(nodo1);
        System.out.println("Comparacion nodo1 con nodo1 (deberia salir 0): "+comp1);
        int comp2 = nodo1.compareTo(nodo2);
        System.out.println("Comparacion nodo1 con nodo2 (deberia salir -1): "+comp2);
        int comp3 = nodo1.compareTo(nodo4);
        System.out.println("Comparacion nodo1 con nodo4 (deberia salir +1): "+comp3);

        Edge edge12 = new Edge(nodo1,nodo2);
        Edge edge23 = new Edge(nodo2,nodo3);
        Edge edge24 = new Edge(nodo2,nodo4);
        String e12 = edge12.toString();
        String e23 = edge23.toString();
        String e24 = edge24.toString();
        System.out.println("");
        System.out.println("Se crean tres aristas");
        System.out.println(e12);
        System.out.println(e23);
        System.out.println(e24);

        System.out.println("");
        System.out.println("Ahora se comparan las aristas");
        int compe1 = e12.compareTo(e12);
        System.out.println("Comparacion e12 con e12 (deberia salir 0): "+compe1);
        int compe2 = e12.compareTo(e23);
        System.out.println("Comparacion e12 con e23: "+compe2);
        int compe3 = e23.compareTo(e24);
        System.out.println("Comparacion e23 con e24: "+compe3);
        int compe4 = e24.compareTo(e23);
        System.out.println("Comparacion e24 con e23: "+compe4);

        System.out.println("");
        System.out.println("Pesos");
        Coordinates coordenadasPeso1 = new Coordinates(1,1);
        Coordinates coordenadasPeso2 = new Coordinates(2,2);
        Coordinates coordenadasPeso3 = new Coordinates(2,6);
        Coordinates coordenadasPeso4 = new Coordinates(4,1);
        City ciudadPeso1 = new City("ciudad_parapeso1",coordenadasPeso1);
        City ciudadPeso2 = new City("ciudad_parapeso2",coordenadasPeso2);
        City ciudadPeso3 = new City("ciudad_parapeso3",coordenadasPeso3);
        City ciudadPeso4 = new City("ciudad_parapeso4",coordenadasPeso4);
        Node nodP1 = new Node(100,ciudadPeso1);
        Node nodP2 = new Node(200,ciudadPeso2);
        Node nodP3 = new Node(300,ciudadPeso3);
        Node nodP4 = new Node(400,ciudadPeso4);
        Edge edP1 = new Edge(nodP1,nodP2);
        Edge edp2 = new Edge(nodP3,nodP4);
        int peso1 = edP1.getWeight();
        int peso2 = edp2.getWeight();
        System.out.println("Peso 1 (coord nodo1 =(1,1) coord nodo2 =(2,2)):"+peso1);
        System.out.println("Peso 2 (coord nodo1 =(2,6) coord nodo2 =(4,1)):"+peso2);

        System.out.println("PRUEBA DEL GETNODE DE GRAPH");
        Graph grafo = new Graph(2);  
        List<Node> nodos_grafo = new ArrayList<Node>();
        grafo.addNode(nodP1);
        grafo.addNode(nodP2);
        grafo.addNode(nodP3);

        System.out.println("Print de la lista de nodos del grafo");
        for(int i=0; i<nodos_grafo.size(); i++){
            System.out.println(nodos_grafo.get(i));
        }
        System.out.println("Ahora con el metodo de getnode");
        Set<Node> nodos_enSet = new HashSet<Node>();
        nodos_enSet = grafo.getNode();
        System.out.println(nodos_enSet);

    }
}