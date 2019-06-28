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

    public Arista getPrimero() {
        return Primero;
    }

    public void setPrimero(Arista Primero) {
        this.Primero = Primero;
    }

    public Arista getUltimo() {
        return Ultimo;
    }

    public void setUltimo(Arista Ultimo) {
        this.Ultimo = Ultimo;
    }

    public void insertarAristas(String nombre, int dist, int time) throws ExceptionListaAristas {

        if (Primero == null) {

            Primero = new Arista(nombre, dist, time);
            Ultimo = Primero;
        } else {

            Arista temp = Primero;

            while (temp != null) {

                if (temp.getNombre().equalsIgnoreCase(nombre)) {
                    throw new ExceptionListaAristas("No se puede crear la arista");
                } else {
                    temp = temp.getSig();
                }
            }

            Arista nuevo = new Arista(nombre, dist, time);
            Ultimo.setSig(nuevo);
            Ultimo = nuevo;
        }

    }

    public Arista removeInicioLista() throws ExceptionListaAristas{
       
        Arista eliminado;
        if(Primero == null){
            throw new ExceptionListaAristas("No hay mas valores a eliminar");
        }else{
            if(Primero.getSig() == null){
            eliminado = Primero;
            Primero = null;
            Ultimo = null;
            return eliminado;
            }else{
                eliminado = Primero;
                Primero = Primero.getSig();
//                Primero.getDato();
                return eliminado;
            }
        }
        
    }

    public void eliminarFinal() throws ExceptionListaAristas {
        int eliminado;
        if (Primero == null) {
            throw new ExceptionListaAristas("No hay mas valores a eliminar");
        } else {
            if (Primero.getSig() == null) {
//                eliminado = Primero.getDato();
                Primero = null;
                Ultimo = null;

            } else {
                Arista temp = Primero;
                while (temp.getSig().getSig() != null) {
                    temp = temp.getSig();
                }

                temp.setSig(null);
                Ultimo = temp;

            }
        }

    }

    public void eliminarEspecifico(String valor) throws ExceptionListaAristas {
        if (Primero == null) {
            throw new ExceptionListaAristas("La lista esta vacia no se puede realizar la accion");
        } else {

            if (valor.equalsIgnoreCase(Primero.getNombre())) {
                removeInicioLista();
                return;
            } else if (valor.equalsIgnoreCase(Ultimo.getNombre())) {
                eliminarFinal();
                return;
            }
            Arista temp = Primero;
            while (temp.getSig() != null) {
                if (valor.equalsIgnoreCase(temp.getSig().getNombre())) {
                    temp.setSig(temp.getSig().getSig());

                } else {
                    temp = temp.getSig();
                }

            }

//            throw new ExceptionListaAristas("No se encontro el valor en la lista");
        }

    }

    public void removeArista(String nombreIngresado) throws ExceptionListaAristas {

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

            result += " [" + temp.getNombre() + "," + temp.getDist() + "," + temp.getTime() + "] ";
            temp = temp.getSig();
        }

        return result;
    }

}
