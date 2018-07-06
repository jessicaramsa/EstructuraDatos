package CurrentTimeMillis;

public class currentTimeMillis {
    long inicio;
    long fin, totalM;
    String aux;

    public void inicio() {
        System.out.println("Tiempo de ejecución de un programa");
    }

    public void datos() {
        inicio = System.currentTimeMillis();
    }

    public void calculos() {
        fin = System.currentTimeMillis();
        totalM = fin - inicio;
    }

    public void resultados() {
        aux = "Tiempo transcurrido: " + totalM + " milisegundos.";
        System.out.println(aux);
    }

    public static void main(String[] args) {
        currentTimeMillis ctm = new currentTimeMillis();

        ctm.inicio();
        ctm.datos();
        ctm.calculos();
        ctm.resultados();
    }
}
