// DNI 29577325S ARIADNA GUILLEN HERNANDEZ
import java.util.*;
import java.io.*;

public class Map{

    private int rows;
    private int cols;
    private List<City> cities;

    public Map(String filename){ // constructor que lee un fichero

        List<City> cities = new ArrayList<City>(); // se inicializa la List
    
        FileReader entrada = null; // para leer el fichero
        BufferedReader mibuf = null;
        String cadena = null;
        String separador = " "; // para separar el texto de una linea
        String[] elementos_delTexto = null;
        int fila = 0; // tamanyo de la fila del mapa
        int columna = 0; // tamanyo de las columnas del mapa
        City ciudad = null; // ciudades que se van a crear a partir de los datos del fichero
        boolean ciudad_creada = false; // booleano para poder crear las ciudades de forma mas comoda
        String nombre_ciudad = null; // variable que se usara para el contructor de City
        Coordinates coordenadas_ciudad = null;

        try{

            if(filename != null){ // se comprueba que el fichero existe

                entrada = new FileReader(filename); // se asigna el fichero para leer
                mibuf = new BufferedReader(entrada); // se asigna lo que se va a leer
                cadena = mibuf.readLine(); // se lee la primera linea del ficher (tamanyo del mapa)

                elementos_delTexto = cadena.split(separador); // se separa la primera linea para que en elementos se guarde el tamanyo en filas y columnas
                fila = Integer.parseInt(elementos_delTexto[0]); // en el primer puesto se ha almacenado el tamanyo de las filas
                columna = Integer.parseInt(elementos_delTexto[1]); // y el en segundo el de las columnas
                
                if(fila>=0){ // se comprueba que las filas y columnas son validas, y en caso de que no sean se ponen a -1
                    this.rows = fila;
                }else{
                    this.rows = -1;
                }

                if(columna>=0){
                    this.cols = columna;
                }else{
                    this.cols = -1;
                }

                cadena = mibuf.readLine(); // se lee la siguiente linea, donde ya se empiezan a crear las ciudades

                while(cadena!=null){ // se lee el fichero hasta que termine

                    if(ciudad_creada == false){ // en este caso, la primera linea que se ha leido es el nombre de la ciudad

                        nombre_ciudad = cadena; // se almacena el nombre de la ciudad
                        ciudad_creada = true;
                    }else{ // en este caso lo que se lee son las coordenadas de la ciudad

                        elementos_delTexto = cadena.split(separador); // se almacena la coordenada en un vector
                        fila = Integer.parseInt(elementos_delTexto[0]);
                        columna = Integer.parseInt(elementos_delTexto[1]);
                        coordenadas_ciudad = new Coordinates(fila,columna); // se crean las coordenadas de la ciudad

                        ciudad = new City(nombre_ciudad, coordenadas_ciudad); // y se crea la ciudad pasandole los datos que se han leido

                        cities.add(ciudad);
                    }

                    if(ciudad != null){ // si hay una ciudad, se vacia

                        ciudad = null;
                    }
                    
                }
            }
        }catch(IOException ex){System.out.println(ex);
        }
    } 

    public int getRows(){ // devuelve rows

        return rows;
    }  

    public int getCols(){ // devuelve cols

        return cols;
    }

    public List<City> getCities(){ // devuelve cities

        return cities;
    }

    public String toString(){ // formato: primera linea -> rows=M, cols=N otras lineas -> ciudades con su formato ya hecho

        String devolver = null;
        City ciudad;

        devolver = "rows=" + rows + ", cols=" + cols + "\n";
        for(int i=0; i<cities.size(); i++){ // se recorren todas las ciudades para anyadrilas a la cadena que se va a devolver

            ciudad = cities.get(i); // se obtiene la ciudad y se anyade al string
            devolver = devolver + ciudad.toString() + "\n";
        }

        return devolver;
    }
}