package proyectoalgoritmos;

/**
 *
 * @author cocau
 */
public class Arista {

    private Arista sig;
    private String nombre;
    private int dist;

    public Arista(String nombre, int dist) {
        
        this.nombre = nombre;
        this.dist = dist;
    }

    public Arista getSig() {
        return sig;
    }

    public void setSig(Arista sig) {
        this.sig = sig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

}
