package ADTRational;

class Rational implements Rationalizable {
    private int x;
    private int y;

    public Rational(int x, int y) {
        this.x = x;
        this.y = y;
        //simplificarI();
        simplificarR(x, y);
    }

    public Rational() {}

    public void setNum(int x) {
        this.x = x;
    }

    public void setDen(int y) {
        this.y = y;
    }

    public int getNum() {
        return x;
    }

    public int getDen() {
        return y;
    }

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
            while (n % d != 0) {
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

    @Override
    public Rational addition(Rational r1, Rational r2) {
        x = r1.getNum() * r2.getDen() + r2.getNum() * r1.getDen();
        y = r1.getDen() * r2.getDen();
        //simplificarI();
        simplificarR(x, y);
        return new Rational(x, y);
    }

    @Override
    public Rational subtraction(Rational r1, Rational r2) {
        x = r1.getNum() * r2.getDen() - r2.getNum() * r1.getDen();
        y = r1.getDen() * r2.getDen();
        simplificarI();
        return new Rational(x, y);
    }

    @Override
    public Rational multiplication(Rational r1, Rational r2) {
        x = r1.getNum() * r2.getNum();
        y = r1.getDen() * r2.getDen();
        simplificarI();
        return new Rational(x, y);
    }

    @Override
    public Rational division(Rational r1, Rational r2) {
        x = r1.getNum() * r2.getDen();
        y = r1.getDen() * r2.getNum();
        simplificarI();
        return new Rational(x, y);
    }

    @Override
    public Rational exponentiation(Rational r1, Integer p) {
        x = (int) Math.pow(r1.getNum(), p);
        y = (int) Math.pow(r1.getDen(), p);
        simplificarI();
        return new Rational(x, y);
    }

    @Override
    public Rational negation(Rational r1) {
        x = r1.getNum() * -1;
        y = r1.getDen();
        simplificarI();
        return new Rational(x, y);
    }

    @Override
    public Rational assignmentOperator(Rational r2) {
        x = r2.getNum();
        y = r2.getDen();
        simplificarI();
        return new Rational(x, y);
    }

    @Override
    public boolean equalsOperator(Rational r1, Rational r2) {
        int x1 = r1.getNum();
        int x2 = r2.getNum();
        int y1 = r1.getDen();
        int y2 = r2.getDen();

        return (x1 == x2 && y1 == y2);
    }

    @Override
    public boolean greaterThanOperator(Rational r1, Rational r2) {
        int x1 = r1.getNum();
        int x2 = r2.getNum();
        int y1 = r1.getDen();
        int y2 = r2.getDen();

        return x1 > x2 && y1 > y2;
    }

    @Override
    public boolean lessThanOperator(Rational r1, Rational r2) {
        int x1 = r1.getNum();
        int x2 = r2.getNum();
        int y1 = r1.getDen();
        int y2 = r2.getDen();

        return x1 < x2 && y1 < y2;
    }

    @Override
    public boolean greaterEqualsOperator(Rational r1, Rational r2) {
        int x1 = r1.getNum();
        int x2 = r2.getNum();
        int y1 = r1.getDen();
        int y2 = r2.getDen();

        return x1 >= x2 && y1 >= y2;
    }

    @Override
    public boolean lessEqualsOperator(Rational r1, Rational r2) {
        int x1 = r1.getNum();
        int x2 = r2.getNum();
        int y1 = r1.getDen();
        int y2 = r2.getDen();

        return x1 <= x2 && y1 <= y2;
    }

    @Override
    public boolean notEqualsOperator(Rational r1, Rational r2) {
        int x1 = r1.getNum();
        int x2 = r2.getNum();
        int y1 = r1.getDen();
        int y2 = r2.getDen();

        return x1 != x2 && y1 != y2;
    }
}
