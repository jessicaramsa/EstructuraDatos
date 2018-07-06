package ADTRational;

public class Simplificar {
    private int x, y;

    public void simplificarI() {
        int n, d, signo, r;
        n = Math.abs(x);
        d = Math.abs(y);
        if (x != 0 && y == 0)
            x = 1;
        else if (x == 0 && y != 0)
            y = 1;
        else if (x != 0 && y != 0) {
            signo = y / d;
            while(n % d != 0) {
                r = n % d;
                n = d;
                d = r;
            }
            x = signo * (x / d);
            y = signo * (y / d);
        }
    }

    public void simplificarR(int n, int d) {
        int absN, absD, signo, mcd;

        absN = Math.abs(n);
        absD = Math.abs(d);

        if (n != 0 && d == 0)
            x = 1;
        else if (n == 0 && d != 0)
            y = 1;
        else if (n != 0 && d != 0) {
            signo = d / absD;
            mcd = mcd(absN, absD);
            x = signo * (n / mcd);
            y = signo * (d / mcd);
        }
    }

    public int mcd(int n, int d) {
        if (d == 0)
            return n;
        else
            return mcd(d, n % d);
    }

    public String toString() {
        if (x == y)
            return "" + x;
        else if (x == 0)
            return "0";
        else if (y == 0)
            return "1";
        else if (y == 1)
            return "" + x;
        else
            return this.x + "/" + this.y;
    }
}
