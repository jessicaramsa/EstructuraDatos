package ADTCola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class pruebaQueue {
    String nom, aux1, archC, linea;
    public static final String f = "fin";
    UniCola c;

    public void inicio() {
        aux1 = "Prueba de las prestaciones del ADT Cola";
        aux1 += "\nMediante la captura de nombres en una fila";
        aux1 += "\nde inscripciones de alumnos.";
        JOptionPane.showMessageDialog(null, aux1, "ADT Cola", 1);
    }

    public void datos() throws IOException {
        archC = "src/ADTCola/";
        c = new UniCola();
        capArch();
    }

    void capArch() throws IOException {
        aux1 = "Ingrese el nombre del archivo:";
        archC += JOptionPane.showInputDialog(null, aux1, "Archivo para colas", 3);
        crearArch(archC);
    }

    public void crearArch(String archivo) throws IOException {
        try {
            File file = new File(archivo);
            if (!file.exists())
                file.createNewFile();
            else if (file.exists())
                System.out.println("El archivo " + archivo + " ya existe.");
            System.out.println("Operación realizada con éxito.");
        } catch (IOException ioe) {
            System.out.println("Error al crear archivo. " + ioe);
        }
        compArchVacio(archivo);
    }

    public void escribir(String archivo, String linea) throws IOException {
        BufferedWriter bw;
        try {
            File file = new File(archivo);
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(linea);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error escribir. " + ex);
        }
    }

    public boolean valInt(String r) {
        try {
            Integer.parseInt(r);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void compArchVacio(String archivo) throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            is = new FileInputStream(archivo);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String l = br.readLine();
            if (l != null) {
                while (l != null) {
                    c.encolar(l);
                    l = br.readLine();
                }
                System.out.println("Se ha cargado la cola.");
            } else
                System.out.println("Se empezará con una cola vacía");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            br.close();
        }
    }

    public void obtInicio() {
        System.out.println("Primer elemento: " + c.obtInicio());
    }

    public void tamaño() {
        System.out.println("Tamaño: " + c.tamaño());
    }

    public void encolar() throws IOException {
        aux1 = "Ingrese el nombre de la persona o fin:";
        nom = JOptionPane.showInputDialog(null, aux1, "Captura", 3);
        do {
            c.encolar(nom);
            nom = JOptionPane.showInputDialog(null, aux1, "Captura", 3);
        } while (!nom.equals(f));
        navegabilidad();
    }

    public void quitar() {
        System.out.println("Sale: " + c.quitar());
    }

    public void localiza() {
        aux1 = "Ingrese la posición a buscar:";
        do {
            linea = JOptionPane.showInputDialog(aux1);
            c.localiza(Integer.parseInt(linea));
        } while (valInt(linea) != false);
    }

    public void esVacia() {
        System.out.println("¿Está vacía? " + c.esVacia());
    }

    public void vaciarArch(String archivo) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("");
        bw.close();
    }

    public void vaciarCola() {
        System.out.println("Vaciando cola...");
        c.limpiar();
        System.out.print("Listo.\n");
    }

    public void guardarSalir() throws IOException {
        vaciarArch(archC);
        try {
            for (int i = 0; i < c.tamaño(); i++) {
                linea = (String) c.localiza(i);
                escribir(archC, linea);
            }
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Error al guardar. " + e);
        }

    }

    public void navegabilidad() throws IOException {
        int m;
        aux1 = "Prestaciones ADT Cola\n1.Obtener inicio\n2.Tamaño\n3.Encolar";
        aux1 += "\n4.Quitar primer elemento\n5.Localiza elemento posición";
        aux1 += "\n6.Está vacía\n7.Vaciar cola\n8.Visualizar\n9.Salir";
        do {
            m = Integer.parseInt(JOptionPane.showInputDialog(aux1));
            switch (m) {
                case 1: obtInicio(); break;
                case 2: tamaño(); break;
                case 3: encolar(); break;
                case 4: quitar(); break;
                case 5: localiza(); break;
                case 6: esVacia(); break;
                case 7: vaciarCola(); break;
                case 8: c.visualiza(); break;
                case 9: guardarSalir(); break;
            }
        } while (m != 9);
    }

    public static void main(String[] args) throws IOException {
        pruebaQueue p = new pruebaQueue();
        p.inicio();
        p.datos();
        try {
            p.navegabilidad();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
