package ADTRational;

import java.io.IOException;
import java.io.*;

public class Archivo {
    public void crearArch(String archivo) {
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
    }

    public void escribir(String archivo, String lista) throws IOException {
        BufferedWriter bw;
        try {
            File file = new File(archivo);
            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(lista);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.out.println("Error al escribir. " + ex);
        }
    }

    public String leer(String archivo) throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            is = new FileInputStream(archivo);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while ((archivo = br.readLine()) != null) {
                System.out.println(archivo);
            }
        } catch (IOException ex) {
            System.out.println("Error al leer. " + ex);
        } finally {
            br.close();
        }
        return null;
    }
}
