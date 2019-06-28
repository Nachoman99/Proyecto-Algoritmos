package proyectoalgoritmos;

/**
 *
 * @author cocau
 */
public class Main {

    public static void main(String[] args) {

        ListaVertices listaVertices = new ListaVertices();
        Interfaz gui = new Interfaz();
        boolean pasar = false;

        while (pasar == false) {

            int opcion = gui.pedirValorInt("[1]INSERTAR Vertice\n[2]Remover Vertice\n[3]\n"
                    + "[4]Agregar Arista\n[5]\n[6]Imprimir grafo\n[7]\n"
                    + "[8]\n[9]\n[10]Salir\\n[11]n12)"
                    + "\n13)");

            switch (opcion) {

                case 1:
                    listaVertices.insertarVertice(gui.pedirCadenas("Ingerese un valor"));
                    break;
                case 2:
                    listaVertices.removeVertice(gui.pedirCadenas("Ingrese el nombre del nodo que desea eliminar"));
                    break;
                case 3:
                    break;

                case 4:

                    gui.mostrar(listaVertices.toString());

                    try {
                        listaVertices.agregarArista(gui.pedirCadenas("Ingrese el origen"),
                                gui.pedirCadenas("Ingrese el destino"), gui.pedirValorInt("Ingrese la distancia"),
                                gui.pedirValorInt("Ingrese el timepo en minutos"));
                    } catch (ExceptionListaVertices ex) {
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
