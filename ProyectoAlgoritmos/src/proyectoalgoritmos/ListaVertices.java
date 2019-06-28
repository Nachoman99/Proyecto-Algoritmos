package proyectoalgoritmos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author cocau
 */
public class ListaVertices {

    private Vertice Primero, Ultimo;

    public ListaVertices() {
        Primero = Ultimo = null;
    }

    
 public void leerArchivo(String ruta) throws FileNotFoundException, IOException {
        File file = new File(ruta);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = "";
        String[] parts;
        String origen = "";
        String destino = "";
        int distancia = 0;
        int tiempo = 0;
        while ((str = br.readLine()) != null) {
            parts = str.split(",");
            origen = parts[0];
            destino = parts[1];
            distancia = Integer.parseInt(parts[2]);
            tiempo = Integer.parseInt(parts[3]);
            insertarVertice(origen,destino,distancia,tiempo);
        }
        
    }

    public void insertarVertice(String origen,String destino,int distancia,int tiempo){
        
    }
    
    
    
    public void insertarVertice(String nombre) {

        if (Primero == null) {

            Primero = new Vertice(nombre);
            Ultimo = Primero;
        } else {

            Vertice nuevo = new Vertice(nombre);
            Ultimo.setSig(nuevo);
            Ultimo = nuevo;
        }

    }

    public void agregarArista(String origenNombre, String destinoNombre, int distancia, int time) throws ExceptionListaVertices, ExceptionListaAristas {

        Vertice temp = Primero;
        Vertice vertOrigen = null;
        boolean existeOrigen = false;
        boolean existeDestino = false;

        while (temp != null) {

            if (origenNombre.equalsIgnoreCase(temp.getNombre())) {

                vertOrigen = temp;
                existeOrigen = true;
            }

            if (destinoNombre.equalsIgnoreCase(temp.getNombre())) {

                vertOrigen = temp;
                existeDestino = true;
            }

            temp = temp.getSig();
        }

        if (!existeOrigen) {
            throw new ExceptionListaVertices("El origen ingresado no existe");
        }else if (!existeDestino) {
             throw new ExceptionListaVertices("El destino ingresado no existe");
        }

        vertOrigen.getListaAristas().insertarAristas(destinoNombre, distancia, time);

    }

    public void removeVertice(String nombreIngresado) {

        if (Primero != null) {

            Vertice temp = Primero;

            if (nombreIngresado.equalsIgnoreCase(Primero.getNombre())) {

                temp.getListaAristas().removeArista(nombreIngresado);
                removeInicioLista();
            }

            while (temp != null) {

                if (temp.getSig() != null) {

                    temp.getSig().getListaAristas().removeArista(nombreIngresado);

                    if (temp.getSig().getNombre().equalsIgnoreCase(nombreIngresado)) {

                        if (temp.getSig() == Ultimo) {

                            temp.setSig(null);
                            Ultimo = temp;
                        } else {

                            temp.setSig(temp.getSig().getSig());
                        }

                    }

                    temp = temp.getSig();

                } else {
                    temp = temp.getSig();
                }
            }

        }

    }

    private void removeInicioLista() {
        if (Primero != null) {

            if (Primero == Ultimo) {

                Primero = null;
                Ultimo = null;
            } else {

                Primero = Primero.getSig();
            }
        }

    }

    public String toString() {

        String result = "";

        Vertice temp = Primero;

        while (temp != null) {

            result += " [" + temp.getNombre() + "] => Aristas = " + temp.getListaAristas().toString() + "\n";
            temp = temp.getSig();
        }

        return result;
    }

}
