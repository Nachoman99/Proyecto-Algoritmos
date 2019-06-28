package proyectoalgoritmos;

/**
 *
 * @author cocau
 */
public class Vertice {

    private Vertice sig;
    private String nombre;
    private boolean definitivo;
    private int acomulado;
    private int iter;
    private ListaAristas listaAristas;

    public Vertice(String nombre) {

        this.nombre = nombre;
        this.acomulado = 0;
        this.definitivo = false;
        this.iter = 0;
        listaAristas = new ListaAristas();
    }

    public Vertice getSig() {
        return sig;
    }

    public void setSig(Vertice sig) {
        this.sig = sig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDefinitivo() {
        return definitivo;
    }

    public void setDefinitivo(boolean definitivo) {
        this.definitivo = definitivo;
    }

    public int getAcomulado() {
        return acomulado;
    }

    public void setAcomulado(int acomulado) {
        this.acomulado = acomulado;
    }

    public int getIter() {
        return iter;
    }

    public void setIter(int iter) {
        this.iter = iter;
    }

    public ListaAristas getListaAristas() {
        return listaAristas;
    }

    public void setListaAristas(ListaAristas listaAristas) {
        this.listaAristas = listaAristas;
    }

}
