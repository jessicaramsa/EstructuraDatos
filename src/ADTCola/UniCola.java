package ADTCola;

public class UniCola implements Encolable {
    private NodoCola inicio;
    private NodoCola fin;
    private int tamaño;

    public UniCola() {
        this.inicio = this.fin = null;
        this.tamaño = 0;
    }

    @Override
    public Object obtInicio() {
        if (!esVacia())
            return inicio.elemento;
        else
            return "Cola vacía.";
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

    @Override
    public void encolar(Object e) {
        NodoCola nuevo = new NodoCola(e);
        if (esVacia())
            inicio = nuevo;
        else
            fin.siguiente = nuevo;
        fin = nuevo;
        tamaño++;
    }

    @Override
    public Object quitar() {
        if (!esVacia()) {
            Object elim = inicio.elemento;
            inicio = inicio.siguiente;
            tamaño--;
            return elim;
        } else
            return "No se puede eliminar de una cola vacía.";
    }

    @Override
    public Object quitar(int n) {
        if (!esVacia()) {
            NodoCola elim = inicio;
            if (n == 0)
                inicio = inicio.getSiguiente();
            else {
                for (int i = 0; i < (n - 1); i++)
                    elim = elim.getSiguiente();
                NodoCola sig = elim.getSiguiente();
                elim.setSiguiente(sig.getSiguiente());
            }
            return elim.elemento;
        } else
            return "Cola vacía.";
    }

    @Override
    public Object quitar(Object e) {
        if (!esVacia()) {
            NodoCola elim = inicio;
            if (e == inicio.getElemento())
                inicio = inicio.getSiguiente();
            else {
                for (int i = 0; i < tamaño; i++)
                    elim = elim.getSiguiente();
                NodoCola sig = elim.getSiguiente();
                elim.setSiguiente(sig.getSiguiente());
            }
            tamaño--;
            return elim.elemento;
        } else
            return "Cola vacía.";
    }

    @Override
    public Object localiza(int n) {
        if (!esVacia()) {
            NodoCola puntero = inicio;
            int cont = 0;
            while (cont < n && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                cont++;
            }
            if (cont != n)
                return "La cola no contiene la posición " + n + ".";
            else
                return puntero.elemento;
        } else
            return "Cola vacía.";
    }

    @Override
    public Object localiza(Object e) {
        if (!esVacia()) {
            NodoCola puntero = inicio;
            int cont = 0;
            while (cont < tamaño && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                cont++;
            }
            if (cont != tamaño)
                return "La cola no contiene el elemento " + e + ".";
            else
                return cont;
        } else
            return "Cola vacía.";
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }

    @Override
    public void limpiar() {
        while (inicio != null)
            inicio = inicio.siguiente;
        tamaño = 0;
        System.gc();
    }

    @Override
    public void visualiza() {
        if (!esVacia()) {
            NodoCola puntero = inicio;
            int cont = 0;
            System.out.println("Elementos de la cola:");
            while (cont < tamaño && puntero != null) {
                System.out.println(puntero.elemento);
                puntero = puntero.siguiente;
                cont++;
            }
        } else
            System.out.println("Cola vacía.");
    }
}
