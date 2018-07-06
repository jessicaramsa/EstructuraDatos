package ADTRational;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PruebaRationalArchivo {
    Rational q[] = new Rational[20];
    ArrayList op = new ArrayList(20);
    ArrayList l = new ArrayList();
    public static final String fin = "fin";
    String n, d, p, nota, archQ, archOp, aux1, aux2;
    int c;
    Rational r = new Rational();
    Archivo a = new Archivo();

    void inicio() {
        JOptionPane.showMessageDialog(null, "Prueba clase Rational");
    }

    void datos() {
        archQ = "src//ADTRational//";
        archOp = "src//ADTRational//";
        nota = "NOTA:\n";
        nota += "Si trabajas con un entero el denominador será 1.\n";
        nota += "No puedes introducir 0 ya que crea indeterminaciones.\n\n";
        c = 0;
        capArch();
    }

    void capArch() {
        aux1 = "Ingrese nombre de archivo para guardar los quebrados:";
        archQ += JOptionPane.showInputDialog(aux1);
        a.crearArch(archQ);
        aux1 = "Ingrese nombre de archivo para guardar las operaciones:";
        archOp += JOptionPane.showInputDialog(aux1);
        a.crearArch(archOp);
    }

    void capQuebrados() throws IOException {
        a.escribir(archQ, "Quebrados:");
        aux1 = nota + (c + 1) + ".Deme el numerador o fin:";
        n = JOptionPane.showInputDialog(aux1);
        while (c < 20 && valIn(n, 1) != false) {
            aux2 = nota + (c + 1) + ".Deme el denominador:";
            d = JOptionPane.showInputDialog(aux2);
            valIn(d, 2);
            q[c] = new Rational(Integer.parseInt(n), Integer.parseInt(d));
            a.escribir(archQ, q[c].toString());
            c = c + 1;
            aux1 = nota + (c + 1) + ".Deme el numerador o fin:";
            n = JOptionPane.showInputDialog(aux1);
        }
        navegabilidad();
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

    void suma() throws IOException {
        l.add("Suma:");
        a.escribir(archOp, "Suma:");
        for (int i = 1; i < c; i++) {
            op.add(r.addition(q[i - 1], q[i]));
            l.add(q[i - 1] + " + " + q[i] + " = " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void resta() throws IOException {
        l.add("Resta:");
        a.escribir(archOp, "Resta:");
        for (int i = 1; i < c; i++) {
            op.add(r.subtraction(q[i - 1], q[i]));
            l.add(q[i - 1] + " - " + q[i] + " = " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void multiplicacion() throws IOException {
        l.add("Multiplicación:");
        a.escribir(archOp, "Multiplicación:");
        for (int i = 1; i < c; i++) {
            op.add(r.multiplication(q[i - 1], q[i]));
            l.add(q[i - 1] + " * " + q[i] + " = " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void division() throws IOException {
        l.add("División:");
        a.escribir(archOp, "División:");
        for (int i = 1; i < c; i++) {
            op.add(r.division(q[i - 1], q[i]));
            l.add("(" + q[i - 1] + ") / (" + q[i] + ") = " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void exponente() throws IOException {
        l.add("Exponente:");
        a.escribir(archOp, "Exponente:");
        p = JOptionPane.showInputDialog("Deme la potencia o fin:");
        while (valIn(p, 3) != false) {
            for (int i = 0; i < c; i++) {
                op.add(r.exponentiation(q[i], Integer.parseInt(p)));
                l.add("(" + q[i] + ") ^ " + p + " = " + op.get(i));
                a.escribir(archOp, l.get(i + 1).toString());
            }
            imprimir1Op(l);
            p = JOptionPane.showInputDialog("Deme la potencia o fin:");
        }
    }

    void negacion() throws IOException {
        l.add("Negación:");
        a.escribir(archOp, "Negación:");
        for (int i = 0; i < c; i++) {
            op.add(r.negation(q[i]));
            l.add("-(" + q[i] + ") = " + op.get(i));
            a.escribir(archOp, l.get(i + 1).toString());
        }
        imprimir1Op(l);
    }

    void asignacion() throws IOException {
        l.add("Asignación:");
        a.escribir(archOp, "Asignación:");
        for (int i = 1; i < c; i++) {
            op.add(r.assignmentOperator(q[i]));
            l.add(q[i - 1] + " -> " + q[i] + " = nuevo " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void igual() throws IOException {
        l.add("Igual:");
        a.escribir(archOp, "Igual:");
        for (int i = 1; i < c; i++) {
            op.add(r.equalsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " == " + q[i] + "? " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void mayor() throws IOException {
        l.add("Mayor que:");
        a.escribir(archOp, "Mayor que:");
        for (int i = 1; i < c; i++) {
            op.add(r.greaterThanOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " > " + q[i] + "? " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void menor() throws IOException {
        l.add("Menor que:");
        a.escribir(archOp, "Menor que:");
        for (int i = 1; i < c; i++) {
            op.add(r.lessThanOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " < " + q[i] + "? " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void mayorIgual() throws IOException {
        l.add("Mayor o igual:");
        a.escribir(archOp, "Mayor o igual:");
        for (int i = 1; i < c; i++) {
            op.add(r.greaterEqualsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " >= " + q[i] + "? " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void menorIgual() throws IOException {
        l.add("Menor o igual:");
        a.escribir(archOp, "Menor o igual:");
        for (int i = 1; i < c; i++) {
            op.add(r.lessEqualsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " <= " + q[i] + "? " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void diferente() throws IOException {
        l.add("Diferente:");
        a.escribir(archOp, "Diferente:");
        for (int i = 1; i < c; i++) {
            op.add(r.notEqualsOperator(q[i - 1], q[i]));
            l.add("¿" + q[i - 1] + " <> " + q[i] + "? " + op.get(i - 1));
            a.escribir(archOp, l.get(i).toString());
        }
        imprimir1Op(l);
    }

    void imprimir1Op(ArrayList a) {
        for (int i = 0; i < a.size(); i++)
            System.out.println(a.get(i));
        a.clear();
        op.clear();
    }

    void desplegar(String arch) throws IOException {
        for (int i = 0; i < 1; i++)
            a.leer(arch);
    }

    void navegabilidad() throws IOException {
        int m;
        aux1 = "Elige:\n1.Ingresar quebrados\n2.Mostrar quebrados\n";
        aux1 += "3.Realizar operaciones\n4.Mostrar resultados de operaciones";
        aux1 += "\n5.Salir";

        do {
            m = Integer.parseInt(JOptionPane.showInputDialog(aux1));
            switch (m) {
                case 1: capQuebrados(); break;
                case 2: desplegar(archQ); break;
                case 3: menuOp(); break;
                case 4: desplegar(archOp); break;
                case 5: System.exit(0); break;
            }
        } while (m != 5);
    }

    void menuOp() throws IOException {
        int mp;
        aux1 = "Elige:\n1.addition\n2.subtraction\n3.multiplication\n4.division";
        aux1 += "\n5.exponentiation\n6.negation\n7.assignmentOperator";
        aux1 += "\n8.equalsOperator\n9.greaterThanOperator\n10.lessThanOperator";
        aux1 += "\n11.greaterEqualsOperator\n12.lessEqualsOperator";
        aux1 += "\n13.notEqualsOperator\n14.Volver al menú principal";
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
                case 14: navegabilidad();
            }
        } while (mp != 14);
    }

    public static void main(String[] args) throws IOException {
        PruebaRationalArchivo par = new PruebaRationalArchivo();
        par.inicio();
        par.datos();

        try {
            par.navegabilidad();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
