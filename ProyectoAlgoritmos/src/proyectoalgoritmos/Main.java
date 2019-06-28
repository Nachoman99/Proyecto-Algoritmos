package proyectoalgoritmos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author cocau
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, ExceptionListaVertices, ExceptionListaAristas {

        /*
        ruta = "";
                    JFileChooser file = new JFileChooser();
                    file.showOpenDialog(file);
                    File fichero = file.getSelectedFile();
                    try {
                        lista = leerArchivo(fichero.getPath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
        
        public static ArrayList leerArchivo(String ruta) throws FileNotFoundException, IOException {
        ArrayList<Persona> list = new ArrayList<>();
        File file = new File(ruta);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = "";
        String[] parts;
        int cedula = 0;
        String nombre = "";
        int edad = 0;
        while ((str = br.readLine()) != null) {
            parts = str.split(",");
            cedula = Integer.parseInt(parts[0]);
            nombre = parts[1];
            edad = Integer.parseInt(parts[2]);
            Persona persona = new Persona(cedula, nombre, edad);
            list.add(persona);
        }
        return list;
    }
         */
        ListaVertices listaVertices = new ListaVertices();
        Interfaz gui = new Interfaz();
        boolean pasar = false;
        while (pasar == false) {

            int opcion = gui.pedirValorInt("[1] Insertar mediante fichero"+"\n"+"[2] INSERTAR Vertice\n[3] Remover Vertice\n[4]\n"
                    + "[5] Agregar Arista\n[6] Imprimir grafo\n[7]\n"
                    + "[8]\n[9]\n[10] Salir\n[11]\n[12]"
                    + "\n[13]");

            switch (opcion) {
                case 1:
                    String ruta = "";
                    JFileChooser file = new JFileChooser();
                    file.showOpenDialog(file);
                    File fichero = file.getSelectedFile();
                    try {
                        listaVertices.leerArchivo(fichero.getPath());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } 

                    break;
                case 2:
                    listaVertices.insertarVertice(gui.pedirCadenas("Ingerese un valor"));
                    break;
                case 3:
                    listaVertices.removeVertice(gui.pedirCadenas("Ingrese el nombre del nodo que desea eliminar"));
                    break;
                case 4:
                    break;

                case 5:

                    gui.mostrar(listaVertices.toString());

                    try {
                        listaVertices.agregarArista(gui.pedirCadenas("Ingrese el origen"),
                                gui.pedirCadenas("Ingrese el destino"), gui.pedirValorInt("Ingrese la distancia"),
                                gui.pedirValorInt("Ingrese el timepo en minutos"));
                    } catch (ExceptionListaVertices | ExceptionListaAristas ex) {
                        gui.mostrar(ex.getMessage());
                    }

                    break;
                case 6:
                    gui.mostrar(listaVertices.toString());
                    break;
                case 10:
                    pasar = true;
                    break;
                default:
                    gui.mostrar("Opción invalida");
            }

        }
    }
}
