package BufferedWriterReader;

import java.io.IOException;
import java.io.*;

public class writer {
    String archivo = "src//BufferedWriterReader//ED.txt";

    public void escribir(String lista) throws IOException {
        BufferedWriter bw = null;

        try {
            File file = new File(archivo);
            if (!file.exists())
                file.createNewFile();

            FileWriter fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            bw.write(lista);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException ioe) {
                System.out.println("Error al cerrar. " + ioe);
            }
        }
    }

    public void leer(String lista) throws IOException {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try {
            is = new FileInputStream(archivo);
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            System.out.println(lista);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer. " + e);
        } finally {
            if (is != null)
                is.close();
            if (isr != null)
                isr.close();
            if (br != null)
                br.close();
        }
    }
}
