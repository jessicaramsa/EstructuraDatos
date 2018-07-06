package ADTRational;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PruebaRational {
    Rational q[] = new Rational[20];
    ArrayList op = new ArrayList(20);
    ArrayList l = new ArrayList();
    public static final String fin = "fin";
    String n, d, p, nota, archQ, archOp, aux1, aux2, aux3;
    int c;
    Rational r = new Rational();

    void inicio() {
        JOptionPane.showMessageDialog(null, "Prueba clase Rational");
    }

    void datos() {
        nota = "NOTA:\n";
        nota += "Si trabajas con un entero el denominador será 1.\n";
        nota += "No puedes introducir 0 ya que crea indeterminaciones.\n\n";
        c = 0;
        aux1 = nota + (c + 1) + ".Deme el numerador o fin:";
        n = JOptionPane.showInputDialog(aux1);

        while (c < 20 && valIn(n, 1) != false) {
            aux2 = nota + (c + 1) + ".Deme el denominador:";
            d = JOptionPane.showInputDialog(aux2);
            valIn(d, 2);
            q[c] = new Rational(Integer.parseInt(n), Integer.parseInt(d));
            System.out.println(q[c]);
            c = c + 1;
            aux1 = nota + (c + 1) + ".Deme el numerador o fin:";
            n = JOptionPane.showInputDialog(aux1);
        }
    }

    boolean valIn(String resp, int caso) {
        try {
            Integer.parseInt(resp);
            return true;
        } catch (NumberFormatException nfe) {
            if (resp.toLowerCase().equals(fin))
                return false;
            else {
                JOptionPane.showMessageDialog(null, "Introduzca un número.");
                switch (caso) {
                    case 1:
                        aux1 = nota + (c + 1) + ".Deme el numerador o fin:";
                        n = JOptionPane.showInputDialog(aux1);
                        return valIn(n, 1);
                    case 2:
                        aux1 = nota + (c + 1) + ".Deme el denominador:";
                        d = JOptionPane.showInputDialog(aux1);
                        return valIn(d, 2);
                    case 3:
                        p = JOptionPane.showInputDialog("Deme la potencia o fin:");
                        return valIn(p, 3);
                    default:
                        break;
                }
                return false;
            }
        }
    }

    void suma() {
        l.add("Suma:");
        for (int i = 1; i < c; i++) {
            op.add(r.addition(q[i - 1], q[i]));
            l.add(q[i - 1] + " + " + q[i] + " = " + op.get(i - 1));
        }
        imprimir();
    }

    void resta() {
        l.add("Resta:");
        for (int i = 1; i < c; i++) {
            op.add(r.subtraction(q[i - 1], q[i]));
            l.add(q[i - 1] + " - " + q[i] + " = " + op.get(i - 1));
        }
        imprimir();
    }

    void multiplicacion() {
        l.add("Multiplicación:");
        for (int i = 1; i < c; i++) {
            op.add(r.multiplication(q[i - 1], q[i]));
            l.add(q[i - 1] + " * " + q[i] + " = " + op.get(i - 1));
        }
        imprimir();
    }

    void division() {
        l.add("División:");
        for (int i = 1; i < c; i++) {
            op.add(r.division(q[i - 1], q[i]));
            l.add("(" + q[i - 1] + ") / (" + q[i] + ") = " + op.get(i - 1));
        }
        imprimir();
    }

    void exponente() {
        l.add("Exponente:");
        p = JOptionPane.showInputDialog("Deme la potencia o fin:");
        while (valIn(p, 3) != false) {
            for (int i = 0; i < c; i++) {
                op.add(r.exponentiation(q[i], Integer.parseInt(p)));
                l.add("(" + q[i] + ") ^ " + p + " = " + op.get(i));
            }
            imprimir();
            p = JOptionPane.showInputDialog("Deme la potencia o fin:");
        }
    }

    void negacion() {
        l.add("Negación:");
        for (int i = 0; i < c; i++) {
            op.add(r.negation(q[i]));
            l.add("-(" + q[i] + ") = " + op.get(i));
        }
        imprimir();
    }

    void asignacion() {
        l.add("Asignación:");
        for (int i = 1; i < c; i++) {
            op.add(r.assignmentOperator(q[i]));
            l.add(q[i - 1] + " -> " + q[i] + " = nuevo " + op.get(i - 1));
        }
        imprimir();
    }

    void igual() {
        l.add("Igual:");
        for (int i = 1; i < c; i++) {
            op.add(r.equalsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " == " + q[i] + "? " + op.get(i - 1));
        }
        imprimir();
    }

    void mayor() {
        l.add("Mayor que:");
        for (int i = 1; i < c; i++) {
            op.add(r.greaterThanOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " > " + q[i] + "? " + op.get(i - 1));
        }
        imprimir();
    }

    void menor() {
        l.add("Menor que:");
        for (int i = 1; i < c; i++) {
            op.add(r.lessThanOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " < " + q[i] + "? " + op.get(i - 1));
        }
        imprimir();
    }

    void mayorIgual() {
        l.add("Mayor o igual:");
        for (int i = 1; i < c; i++) {
            op.add(r.greaterEqualsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " >= " + q[i] + "? " + op.get(i - 1));
        }
        imprimir();
    }

    void menorIgual() {
        l.add("Menor o igual:");
        for (int i = 1; i < c; i++) {
            op.add(r.lessEqualsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " <= " + q[i] + "? " + op.get(i - 1));
        }
        imprimir();
    }

    void diferente() {
        l.add("Diferente:");
        for (int i = 1; i < c; i++) {
            op.add(r.notEqualsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " <> " + q[i] + "? " + op.get(i - 1));
        }
        imprimir();
    }

    void imprimir() {
        for (int i = 0; i < l.size(); i++)
            System.out.println(l.get(i));
        op.clear();
        l.clear();
    }

    void navegabilidad() {
        int mp;
        aux1 = "Elige:\n1.addition\n2.subtraction\n3.multiplication\n4.division";
        aux1 += "\n5.exponentiation\n6.negation\n7.assignmentOperator";
        aux1 += "\n8.equalsOperator\n9.greaterThanOperator\n10.lessThanOperator";
        aux1 += "\n11.greaterEqualsOperator\n12.lessEqualsOperator";
        aux1 += "\n13.notEqualsOperator\n14.Salir";

        do {
            mp = Integer.parseInt(JOptionPane.showInputDialog(aux1));
            switch (mp) {
                case 1: suma(); break;
                case 2: resta(); break;
                case 3: multiplicacion(); break;
                case 4: division(); break;
                case 5: exponente(); break;
                case 6: negacion(); break;
                case 7: asignacion(); break;
                case 8: igual(); break;
                case 9: mayor(); break;
                case 10: menor(); break;
                case 11: mayorIgual(); break;
                case 12: menorIgual(); break;
                case 13: diferente(); break;
            }
        } while (mp != 14);
    }

    public static void main(String[] args) {
        PruebaRational pa = new PruebaRational();
        pa.inicio();
        pa.datos();
        pa.navegabilidad();
    }
}
