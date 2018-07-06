package FrameWork;

import javax.swing.JOptionPane;

public class PruebaFrameWork {
    String m, r, aux1;
    int x, y, s;
    long iT = System.currentTimeMillis();
    long fT;
    FrameWork f = new FrameWork();
    FrameWork d1 = new FrameWork();
    FrameWork d2 = new FrameWork();

    void inicio() {
        m = "Prueba de las prestaciones del ADT Framework.";
        f.meta(m);
    }

    void datos() {
        aux1 = "Inicializar datos correspondientes.";
        JOptionPane.showMessageDialog(null, aux1);
        aux1 = "Ejemplo de una variable x.\n\nIngresa un valor numérico:";
        x = Integer.parseInt(JOptionPane.showInputDialog(aux1));
        aux1 = "Variable y.\n\nIngrese un valor numérico:";
        y = Integer.parseInt(JOptionPane.showInputDialog(aux1));
        navegabilidad();
    }

    void calculos() {
        s = x + y;
        fT = System.currentTimeMillis();
        f.calculosT(iT, fT);
    }

    void resultados() {
        aux1 = "Prueba resultados";
        r = "Suma de valores x+y = " + s;
        f.resultados(r, aux1);
        navegabilidad();
    }

    void mNav() {
        aux1 = "Este menú es solo un ejemplo de la navegabilidad";
        aux1 += "\nque puedes utilizar.";
        JOptionPane.showMessageDialog(null, aux1);
    }

    void navegabilidad() {
        int mp;
        aux1 = "Elige la prestación a mostrar:\n1.Meta\n2.Datos\n3.Calculos";
        aux1 += "\n4.Resultados\n5.Navegabilidad\n6.Salir";
        do {
            mp = Integer.parseInt(JOptionPane.showInputDialog(aux1));;
            switch (mp) {
                case 1: inicio(); break;
                case 2: datos(); break;
                case 3: calculos(); break;
                case 4: resultados(); break;
                case 5: mNav(); break;
                default: System.exit(0); break;
            }
        } while (mp != 6);
    }

    public static void main(String[] args) {
        PruebaFrameWork pf = new PruebaFrameWork();
        pf.navegabilidad();
    }
}
