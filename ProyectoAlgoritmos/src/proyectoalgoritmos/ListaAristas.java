package proyectoalgoritmos;

/**
 *
 * @author cocau
 */
public class ListaAristas {

    private Arista Primero, Ultimo;

    public ListaAristas() {

        Primero = Ultimo = null;
    }

    public void insertarAristas(String nombre, int dist) {

        if (Primero == null) {

            Primero = new Arista(nombre, dist);
            Ultimo = Primero;
        } else {

            Arista nuevo = new Arista(nombre, dist);
            Ultimo.setSig(nuevo);
            Ultimo = nuevo;
        }

    }

    public void removeInicioLista() {
        if (Primero != null) {

            if (Primero == Ultimo) {

                Primero = null;
                Ultimo = null;
            } else {

                Primero = Primero.getSig();
            }
        }

    }

    public void removeArista(String nombreIngresado) {

        if (Primero != null) {

            Arista temp = Primero;

            if (nombreIngresado.equalsIgnoreCase(Primero.getNombre())) {

                removeInicioLista();
            } else {

                while (temp != null) {

                    if (temp.getSig() != null) {

                        if (temp.getSig().getNombre().equalsIgnoreCase(nombreIngresado)) {

                            if (temp.getSig() == Ultimo) {

                                temp.setSig(null);
                                Ultimo = temp;
                            } else {

                                temp.setSig(temp.getSig().getSig());
                            }

                            temp = null;
                        } else {

                            temp = temp.getSig();
                        }

                    } else {
                        //Exepcion
                    }
                }

            }
        }

    }

    public String toString() {

        String result = "";

        Arista temp = Primero;

        while (temp != null) {

            result += " [" + temp.getNombre() + "," + temp.getDist() + "] ";
            temp = temp.getSig();
        }

        return result;
    }

}