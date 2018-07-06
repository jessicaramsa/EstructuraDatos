package SerieFibonacci;

import CurrentTimeMillis.currentTimeMillis;

public class SerieFibonacci {
    int c, f0, f1, fn, fr;
    String aux, aux1;
    currentTimeMillis ctm = new currentTimeMillis();

    void inicio() {
        System.out.println("Serie Fibonacci");
    }

    void datos() {
        f0 = 0;
        f1 = 1;
        c = 10;
        aux = "Iterativamente: " + f0;
        fr = 0;
        aux1 = "Recursivamente: 0";
    }

    void calculos() {
        iterativo(c);
        recursivo(c);
        ctm.calculos();
    }

    public String iterativo(int n) {
        for (int i = 2; i < c; i++) {
            fn = f0 + f1;
            aux += "," + fn;
            f0 = f1;
            f1 = fn;
        }
        return aux;
    }

    public int recursivo(int n) {
        if (n <= 1)
            fr = n;
        else
            fr = recursivo(n - 1) + recursivo(n - 2);
        return fr;
    }

    public String recursivoP() {
        for (int i = 1; i < c; i++)
            aux1 += "," + recursivo(i);
        return aux1;
    }

    void resultados() {
        System.out.println(c + " términos");
        System.out.println(aux);
        System.out.println(recursivoP());
        ctm.resultados();
    }

    public static void main(String[] args) {
        SerieFibonacci s = new SerieFibonacci();

        s.inicio();
        s.datos();
        s.calculos();
        s.resultados();
    }
}
