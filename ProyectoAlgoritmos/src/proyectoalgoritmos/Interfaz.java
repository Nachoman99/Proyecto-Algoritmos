package proyectoalgoritmos;

import javax.swing.JOptionPane;

/**
 *
 * @author cocau
 */
public class Interfaz {

    public int pedirValorInt(String mensaje) {

        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }

    public String pedirCadenas(String mensaje) {

        return JOptionPane.showInputDialog(mensaje);
    }

    public void mostrar(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
