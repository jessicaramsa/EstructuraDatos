package ADTRational;

public interface Rationalizable{
    public Rational addition(Rational r1, Rational r2);
    public Rational subtraction(Rational r1, Rational r2);
    public Rational multiplication(Rational r1, Rational r2);
    public Rational division(Rational r1, Rational r2);
    public Rational exponentiation(Rational r1, Integer p);
    public Rational negation(Rational r1);
    public Rational assignmentOperator(Rational r2);
    public boolean equalsOperator(Rational r1, Rational r2);
    public boolean greaterThanOperator(Rational r1, Rational r2);
    public boolean lessThanOperator(Rational r1, Rational r2);
    public boolean greaterEqualsOperator(Rational r1, Rational r2);
    public boolean lessEqualsOperator(Rational r1, Rational r2);
    public boolean notEqualsOperator(Rational r1, Rational r2);
}
