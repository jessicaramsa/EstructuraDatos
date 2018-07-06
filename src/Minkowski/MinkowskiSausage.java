package Minkowski;

import javax.swing.JOptionPane;

public class MinkowskiSausage {
    Turtle turtle;
    double size;
    String aux;
    int patron;

    public MinkowskiSausage() {}

    void inicio() {
        aux = "Prueba del fractal Minkowski sausage.";
        aux += "\nEligiendo el número de patrón a dibujar.";
        JOptionPane.showMessageDialog(null, aux);
    }

    void datos() {
        aux = "Ingrese el número de patrón que desea dibujar:";
        patron = Integer.parseInt(JOptionPane.showInputDialog(aux));
        MinkowskiSausage sp = new MinkowskiSausage(patron);
    }

    public MinkowskiSausage(int n) {
        size = 1.5 / Math.pow(4.0 / Math.sqrt(3), n + 1);
        turtle = new Turtle(90 / 512.0, 150 / 512.0, 0.0);
        sausage(n);
        turtle.turnLeft(90);
        sausage(n);
        turtle.turnLeft(90);
        sausage(n);
        turtle.turnLeft(90);
        sausage(n);
        turtle.turnLeft(90);
    }

    private void sausage(int n) {
        if (n == 0)
            turtle.goForward(size);
        else {
            turtle.turnLeft(-30);
            sausage(n - 1);
            turtle.turnLeft(90);
            sausage(n - 1);
            turtle.turnLeft(-90);
            sausage(n - 1);
            turtle.turnLeft(30);
        }
    }

    void navegabilidad() {
        aux = "¿Desea dibujar otro patrón?\n1.Si\n2.No";
        patron = Integer.parseInt(JOptionPane.showInputDialog(aux));
        switch (patron) {
            case 1: datos(); break;
            case 2: System.exit(0);
        }
    }

    public static void main(String[] args) {
        MinkowskiSausage ms = new MinkowskiSausage();
        ms.inicio();
        ms.datos();
        ms.navegabilidad();
    }
}
