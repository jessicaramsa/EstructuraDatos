package BufferedWriterReader;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class BufferedWriterAndReader {
    String nombre, nControl, aux;
    ArrayList lista = new ArrayList();
    public static final String c = "fin";
    int n;
    writer w = new writer();

    void inicio() {
        JOptionPane.showMessageDialog(null, "BufferedWriter y Buffered Reader");
    }
    
    void navegabilidad() throws IOException {
        int op;
        aux = "Elige:\n1.Escribir en archivo\n2.Mostrar archivo\n3.Salir";

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(aux));
            switch (op) {
                case 1: escribe(); break;
                case 2: desplegar(); break;
            }
        } while (op != 3);
    }

    void escribe() throws IOException {
        nombre = JOptionPane.showInputDialog("Ingrese el nombre o fin:");
        while (!nombre.toLowerCase().equals(c)) {
            nControl = JOptionPane.showInputDialog("Numero de control");
            lista.add(nombre + ", " + nControl);
            w.escribir(lista.toString());
            n = n + 1;
            nombre = JOptionPane.showInputDialog("Ingrese el nombre o fin:");
        }
    }

    void desplegar() throws IOException {
        System.out.println("Reporte de asistencia");
        for (int i = 0; i < lista.size(); i++)
            w.leer(lista.get(i).toString());
        System.out.println("Total asistentes: " + lista.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedWriterAndReader wr = new BufferedWriterAndReader();
        wr.inicio();
        wr.navegabilidad();
    }
}
