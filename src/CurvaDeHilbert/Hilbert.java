package CurvaDeHilbert;

import javax.swing.*;

public class Hilbert {
    private Turtle turtle;
    int n, patron;
    String aux;

    public Hilbert() { }

    public Hilbert(int n) {
        turtle = new Turtle(0.5, 0.5, 0.0);
        double max = Math.pow(2, n);
        turtle.setXscale(0, max);
        turtle.setYscale(0, max);
        hilbert(n);
    }
    
    void inicio() {
        aux = "Modelar un algoritmo capaz de dibujar los ";
        aux += "primeros 5 patrones de la curva de Hilbert";
        JOptionPane.showMessageDialog(null, aux);
    }

    void datos() {
        aux = "Ingrese el número de patrón que desea dibujar:";
        patron = Integer.parseInt(JOptionPane.showInputDialog(aux));
        Hilbert hp = new Hilbert(patron);
    }

    private void hilbert(int n) {
        if (n == 0)
            return;
        turtle.turnLeft(90);
        treblih(n - 1);
        turtle.goForward(1.0);
        turtle.turnLeft(-90);
        hilbert(n - 1);
        turtle.goForward(1.0);
        hilbert(n - 1);
        turtle.turnLeft(-90);
        turtle.goForward(1.0);
        treblih(n - 1);
        turtle.turnLeft(90);
    }

    public void treblih(int n) {
        if (n == 0)
            return;
        turtle.turnLeft(-90);
        hilbert(n - 1);
        turtle.goForward(1.0);
        turtle.turnLeft(90);
        treblih(n - 1);
        turtle.goForward(1.0);
        treblih(n - 1);
        turtle.turnLeft(90);
        turtle.goForward(1.0);
        hilbert(n - 1);
        turtle.turnLeft(-90);
    }

    public static void main(String[] args) {
        Hilbert h = new Hilbert();
        h.inicio();
        h.datos();
    }
}
