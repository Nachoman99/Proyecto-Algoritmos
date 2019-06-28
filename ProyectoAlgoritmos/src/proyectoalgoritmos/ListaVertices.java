package proyectoalgoritmos;

/**
 *
 * @author cocau
 */
public class ListaVertices {

    private Vertice Primero, Ultimo;

    public ListaVertices() {
        Primero = Ultimo = null;
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

    public void agregarArista(String origenNombre, String destinoNombre, int distancia) throws ExceptionListaVertices {

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

        if (!existeOrigen || !existeDestino) {
            throw new ExceptionListaVertices("Los datos ingresados no coinciden con los vertices existentes");
        }

        vertOrigen.getListaAristas().insertarAristas(destinoNombre, distancia);

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
