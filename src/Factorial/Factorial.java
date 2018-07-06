package Factorial;

public class Factorial {
    int fi, fr, n;

    void inicio() {
        System.out.println("Calcular factorial de n");
    }

    void datos() {
        n = 10;
        fi = 1;
        fr = 1;
    }

    void calculos() {
        factI(n);
        factR(n);
    }

    public int factI(int n) {
        if (n == 0)
            fi = 1;
        else {
            for (int i = 1; i < (n + 1); i++)
                fi = fi * i;
        }
        return fi;
    }

    public int factR(int n) {
        if (n == 0)
            fr = 1;
        else
            fr = n * factR(n - 1);
        return fr;
    }

    void resultados() {
        System.out.println("Iterativamente: " + fi);
        System.out.println("Recursivamente: " + fr);
    }

    public static void main(String[] args) {
        Factorial f = new Factorial();
        f.inicio();
        f.datos();
        f.calculos();
        f.resultados();
    }
}
