package ADTPila;

public class Pila implements Apilable {
    private NodoPila cima;
    private int tamaño;
    private final int capacidad;

    public Pila() {
        this.capacidad = 100;
    }

    public Pila(int c) {
        this.cima = null;
        this.tamaño = 0;
        this.capacidad = c;
    }

    @Override
    public Object obtCima() {
        return cima.elemento;
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

    @Override
    public int capMaxima() {
        return capacidad;
    }

    @Override
    public void insertar(Object e) {
        if (pLlena())
            System.out.println("Desbordamiento de pila.");
        else {
            NodoPila nuevo = new NodoPila(e);
            nuevo.siguiente = cima;
            cima = nuevo;
            tamaño++;
        }
    }

    @Override
    public void eliminar() {
        if (!esVacia()) {
            NodoPila antiguo = cima;
            cima = cima.siguiente;
            antiguo.siguiente = null;
            tamaño--;
        } else
            System.out.println("Pila vacía, operación no posible.");
    }

    @Override
    public boolean pLlena() {
        return tamaño == capacidad;
    }

    @Override
    public boolean esVacia() {
        return cima == null;
    }

    @Override
    public void limpiar() {
        cima = null;
        tamaño = 0;
    }

    @Override
    public void visualiza() {
        if (!esVacia()) {
            NodoPila posicion = cima;
            int cont = 0;
            while (cont <= tamaño && posicion != null) {
                System.out.println(posicion.elemento);
                cont++;
                posicion = posicion.siguiente;
            }
        } else
            System.out.println("Pila vacía.");
    }
}
