package Integer;

import javax.swing.JOptionPane;

public class Tarea1 {
    int numero1;
    int numero2;
    int numero3;
    String s;
    String m1;
    String m2;
    String m3;
    String m4;
    String aux;

    void inicio() {
        System.out.println("Prestaciones de la clase Integer");
    }

    void datos() {
        numero1 = 12345;
        numero2 = 98765;
        numero3 = 15926;
        s = "5";
        m1 = "Elige la categoría que deseas consultar:";
        m2 = "Salida: ";
        m4 = "Constantes a utilizar:\nnumero1=12345\nnumero2=98765";
        m4 += "\nnumero3=15926\ns=5";
    }
    
    void navegabilidad() {
        int r;

        System.out.println(m4);
        do {
            aux = "\n1.Acceso\n2.Conversion\n3.Comparacion\n4.Informacion";
            aux += "\n5.Operacion \n6.Regresan una cadena\n7.Salir";
            r = Integer.parseInt(JOptionPane.showInputDialog(m1 + aux));
            switch (r) {
                case 1: acceso(); break;
                case 2: conversion(); break;
                case 3: comparacion(); break;
                case 4: informacion(); break;
                case 5: operacion(); break;
                case 6: cadena(); break;
            }
        } while (r != 7);
    }

    void acceso() {
        int r;

        do {
            aux = "\n1.byteValue \n2.getInteger\n3.parseInt";
            aux += "\n4.parseUnsigned\n5.valueOf\n6.Salir";
            r = Integer.parseInt(JOptionPane.showInputDialog(m1 + aux));
            switch (r) {
                case 1: byteValue(); break;
                case 2: getInteger(); break;
                case 3: parseInt(); break;
                case 4: parseUnsigned(); break;
                case 5: valueOf(); break;
            }
        } while (r != 6);
    }

    void byteValue() {
        aux = "byteValue():Devuelve el valor de este Integer como un byte";
        aux += "\ndespués de una conversión primitiva.";
        Integer obj = numero1;
        m3 = "" + obj.byteValue();
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void getInteger() {
        aux = "getInteger(String nm, int val):";
        aux += " Determina el valor\nentero de la propiedad del sistema";
        aux += " recibe un String\ny regresa un static Integer.";
        m3 = "" + Integer.getInteger(s, numero3);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void parseInt() {
        aux = "parseInt(String s): Analiza el";
        aux += " argumento de cadena\ncomo un entero, recibe una variable de";
        aux += " tipo String\ny regresa un static int.";
        m3 = "" + Integer.parseInt(s);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void parseUnsigned() {
        aux = "parseUnsignedInt(String s): Analiza el argumento";
        aux += " como un entero sin signo, recibe una variable";
        aux += "\nde tipo String y regresa una de tipo static int.";
        m3 = "" + Integer.parseUnsignedInt(s);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void valueOf() {
        aux = "valueOf(int i): Puede devolver una instancia";
        aux += " de Integer o un objeto de Integer, que representa el";
        aux += "\nvalor de la variable especificada (puede ser int o String)";
        m3 = "" + Integer.valueOf(numero1);
        aux += ".\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void conversion() {
        int r;

        do {
            aux = "\n1.bitCount\n2.decode\n3.doubleValue\n4.reverse";
            aux += "\n5.rotateRight\n6.shortValue\n7.toUnsignedLong\n8.Salir";
            r = Integer.parseInt(JOptionPane.showInputDialog(m1 + aux));
            switch (r) {
                case 1: bitCount(); break;
                case 2: decode(); break;
                case 3: doubleValue(); break;
                case 4: reverse(); break;
                case 5: rotateRight(); break;
                case 6: shortValue(); break;
                case 7: toUnsigned(); break;
            }
        } while (r != 8);
    }

    void bitCount() {
        aux = "bitCount(int numero1): devuelve";
        aux += " el número de bit 1 del valor entero.";
        m3 = "" + Integer.bitCount(numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void decode() {
        aux = "decode(String s): decodifica una";
        aux += " cadena en un Integer.";
        m3 = "" + Integer.decode(s);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void doubleValue() {
        Integer obj = numero1;
        aux = "doubleValue(): devuelve el valor de un Integer";
        aux += " como double\ndespués de una conversión primitiva";
        aux += " de ampliación.";
        m3 = "" + obj.doubleValue();
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void reverse() {
        aux = "reverse(int i): devuelve el valor obtenido invirtiendo";
        aux += " el orden\nde los bits de dos del entero especificado.";
        m3 = "" + Integer.reverse(numero2);
        aux += "\n" + m2 + m3;
        aux += "\nNOTA: El procedimiento realizado es el mismo para el método";
        aux += " reverseBytes(int numero2)\n que devuelve el valor";
        aux += " inviertiendo el orden de los bytes.";
        JOptionPane.showMessageDialog(null, aux);
    }

    void rotateRight() {
        aux = "Devuelven el valor girando la representación binaria";
        aux += "\ndel entero especificado a la izquierda o derecha";
        aux += " especificando los bits:\nrotateLeft(int i, int distance) /";
        aux += " rotateRight(int i, int distance),\ndonde el segundo argumento";
        aux += " representa la distancia a girar.";
        m3 = "" + Integer.rotateLeft(numero2, numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void shortValue() {
        Integer obj = numero1;
        aux = "shortValue(): devuelve el valor de un Integer";
        aux += "\ncomo short después de una conversión primitiva de";
        aux += " estrechamiento";
        m3 = "" + obj.doubleValue();
        aux += ".\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void toUnsigned() {
        aux = "toUnsignedLong(int x): convierte";
        aux += " el argumento en la conversión\na long sin signo.";
        m3 = "" + Integer.toUnsignedLong(numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void comparacion() {
        int r;

        do {
            aux = "\n1.compareTo\n2.equals\n3.max\n4.Salir";
            r = Integer.parseInt(JOptionPane.showInputDialog(m1 + aux));
            switch (r) {
                case 1: compareTo(); break;
                case 2: equals(); break;
                case 3: max(); break;
            }
        } while (r != 4);
    }

    void compareTo() {
        Integer obj1 = numero1;
        Integer obj2 = numero2;
        int val;

        val = obj1.compareTo(numero2);
        aux = "compareTo(Integer anotherInteger):";
        aux += "\nCompara numéricamente dos objetos Integer y regresa un int.";
        if (val > 0)
            m3 = obj1 + " es más grande que " + obj2;
        else if (val < 0)
            m3 = obj1 + " es menor que " + obj2;
        else
            m3 = obj1 + " es igual que " + obj2;
        aux += "\n" + m2 + m3;
        aux += "\nNOTA: El método compare() hace realiza el mismo";
        aux += " procedimiento a diferencia de que pide argumentos tipo int.";
        JOptionPane.showMessageDialog(null, aux);
    }

    void equals() {
        Integer obj1 = numero1;
        Integer obj2 = numero2;
        boolean val;

        aux = "equals(Object obj) : Compara este";
        aux += " objeto con elobjeto\nespecificado y regresa un boolean.";
        val = obj1.equals(obj2);
        if (val == true)
            m3 = obj1 + " es igual a " + obj2;
        else
            m3 = obj1 + " es diferente a " + obj2;
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void max() {
        aux = "max(int x, int y) : Devuelve el mayor de dos valores int";
        aux += "\ncomo si llamara a Math.max. y regresa un static int.";
        m3 = "" + Math.max(numero1, numero3);
        aux += "\n" + m2 + m3;
        aux += "\nNOTA: El método min() realiza el mismo";
        aux += " procedimiento regresando\nel menor de dos valores.";
        JOptionPane.showMessageDialog(null, aux);
    }

    void informacion() {
        int r;

        do {
            aux = "\n1.highestOneBit\n2.numberOfLeadingZeros\n3.Salir";
            r = Integer.parseInt(JOptionPane.showInputDialog(m1 + aux));
            switch (r) {
                case 1: highestOneBit(); break;
                case 2: numberOfLeadingZeros(); break;
            }
        } while (r != 3);
    }

    void highestOneBit() {
        aux = "highestOneBit(int i): Devuelve un valor con un máximo";
        aux += "\nde un bit, en la posicion del bir de orden más";
        aux += "\nalto (“más a la izquierda”) en un valor int especificado.";
        m3 = "" + Integer.highestOneBit(numero1);
        aux += "\n" + m2 + m3;
        aux += "\nNOTA: Existe otro método llamado lowestOneBit(int i), el";
        aux += "\ncual hace lo contrario de este, es decir,";
        aux += "\nla posicion del orden inferior.";
        JOptionPane.showMessageDialog(null, aux);
    }

    void numberOfLeadingZeros() {
        aux = "numberOfLeadingZeros(int i): Devuelve el numero de bits cero";
        aux += "\nque preceden al bit de orden superior (“más a la izquierda”)";
        aux += "\nen la representacion binaria de complemento de";
        aux += "\ndos del valor de int especificado.";
        m3 = "" + Integer.numberOfLeadingZeros(numero2);
        aux += "\n" + m2 + m3;
        aux += "\nNOTA: Existe otro método llamado numberOfTrailingZeros(int i),";
        aux += "\nel cual hace lo contrario de este, es decir,";
        aux += "\ndevuelve los bits ceros que sigue al bit de orden inferior.";
        JOptionPane.showMessageDialog(null, aux);
    }

    void operacion() {
        int r;

        do {
            aux = "\n1.divideUnsigned\n2.remainderUnsigned\n3.signum\n4.sum\n5.Salir";
            r = Integer.parseInt(JOptionPane.showInputDialog(m1 + aux));
            switch (r) {
                case 1: divideUnsigned(); break;
                case 2: remainderUnsigned(); break;
                case 3: signum(); break;
                case 4: sum(); break;
            }
        } while (r != 5);
    }

    void divideUnsigned() {
        aux = "divideUnsigned(int dividend, int divisor): Devuelve el";
        aux += "\ncociente sin signo de dividir el primer argumento";
        aux += "\npor el segundo donde cada argumento y el resultado";
        aux += "\nse interpretan como un valor sin signo,";
        aux += "\ny regresa un static int.";
        m3 = "" + Integer.divideUnsigned(numero2, numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void remainderUnsigned() {
        aux = "remainderUnsigned(int dividend, int divisor):";
        aux += "\nDevuelve el resto sin signo de dividir el primer argumento";
        aux += "\npor el segundo donde cada argumento y el resultado se";
        aux += "\ninterpreta como un valor sin signo y regresa un static int.";
        m3 = "" + Integer.remainderUnsigned(numero2, numero3);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void signum() {
        aux = "signum(int i): Devuelve la función signum del valor";
        aux += "\nint especificado y regresa un static int.";
        m3 = "" + Integer.signum(numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void sum() {
        aux = "sum(int a, int b): Agrega dos enteros juntos";
        aux += "\nsegún el operador + y regresa un static int.";
        m3 = "" + Integer.sum(numero3, numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void cadena() {
        int r;

        do {
            aux = "\n1.toBinaryString\n2.toHexString\n3.toOctaString";
            aux += "\n4.toString\n5.toUnsignedString\n6.Salir";
            r = Integer.parseInt(JOptionPane.showInputDialog(m1 + aux));
            switch (r) {
                case 1: toBynaryString(); break;
                case 2: toHexString(); break;
                case 3: toOctaString(); break;
                case 4: tostring(); break;
                case 5: toUnsignedString(); break;
            }
        } while (r != 6);
    }

    void toBynaryString() {
        aux = "toBinaryString(int i): Devuelve una representación de cadena";
        aux += "\ndel argumento entero como un entero sin signo con base 2.";
        m3 = "" + Integer.toBinaryString(numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void toHexString() {
        aux = "toHexString(int i): Devuelve una representación de cadena";
        aux += "\ndel argumento entero como un entero sin signo con base 16.";
        m3 = "" + Integer.toHexString(numero2);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void toOctaString() {
        aux = "toOctalString(int i): Devuelve una representación de cadena";
        aux += "\ndel argumento entero como un entero sin signo en base 8.";
        m3 = "" + Integer.toOctalString(numero3);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void tostring() {
        aux = "toString(): Devuelve un objeto String que representa";
        aux += "\nel valor de este entero, puede o no recibir una";
        aux += "\nvariable de tipo int.";
        m3 = "" + Integer.toString(numero2);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    void toUnsignedString() {
        aux = "toUnsignedString(int i): Devuelve una representacion de";
        aux += "\ncadena como un valor decimal sin signo.";
        m3 = "" + Integer.toUnsignedString(numero1);
        aux += "\n" + m2 + m3;
        JOptionPane.showMessageDialog(null, aux);
    }

    public static void main(String[] args) {
        Tarea1 t1 = new Tarea1();

        t1.inicio();
        t1.datos();
        t1.navegabilidad();
    }
}
