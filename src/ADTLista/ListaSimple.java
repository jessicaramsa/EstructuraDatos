package ADTLista;

public class ListaSimple implements ListableSimple {
    private Nodo cabeza;
    private int tamaño;

    public ListaSimple() {
        cabeza = null;
        tamaño = 0;
    }

    public void setCabeza(Nodo c) {
        this.cabeza = c;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

    @Override
    public boolean esVacia() {
        return cabeza == null;
    }

    @Override
    public ListaSimple insertarI(Object in) {
        Nodo nuevo = new Nodo(in);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamaño++;
        return this;
    }

    @Override
    public ListaSimple insertar(Object e, int p) {
        Nodo nuevo = new Nodo(e);

        if (cabeza == null)
            cabeza = nuevo;
        else {
            Nodo puntero = cabeza;
            int c = 0;
            while (c < p && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                c++;
            }
            nuevo.siguiente = puntero.siguiente;
            puntero.siguiente = nuevo;
        }
        tamaño++;
        return this;
    }

    @Override
    public ListaSimple insertarF(Object f) {
        Nodo nuevo = new Nodo(f);

        if (cabeza == null)
            cabeza = nuevo;
        else {
            Nodo p = cabeza;
            while (p.siguiente != null)
                p = p.siguiente;
            p.siguiente = nuevo;
        }
        tamaño++;
        return this;
    }

    @Override
    public int localiza(Object e) {
        if (cabeza != null) {
            Nodo puntero = cabeza;
            int c = 0;
            while (c < tamaño && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                c++;
            }
            if (c < tamaño)
                return c;
            else if (c != tamaño)
                return Integer.parseInt(null);
        }
        return Integer.parseInt(null);
    }

    @Override
    public Object localiza(int p) {
        if (cabeza == null)
            return "La lista solo tiene " + tamaño + " elementos.";
        else {
            Nodo puntero = cabeza;
            int c = 0;
            while (c < p && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                c++;
            }
            if (c != p)
                return "La lista no contiene la posición " + p + ".";
            else
                return puntero.elemento;
        }
    }

    @Override
    public Object anterior(int p) {
        Nodo puntero = cabeza;
        int c = 0;

        if (!esVacia()) {
            while (c < tamaño && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                c++;
            }

            if (c != p)
                return "La lista no contiene la posición " + p + ".";
            else
                return puntero;
        } else
            return "La lista está vacía.";
    }

    @Override
    public Object siguiente(int p) {
        Nodo puntero = cabeza;
        int c = 0;

        if (!esVacia()) {
            while (c < tamaño && puntero.siguiente != null) {
                puntero = puntero.siguiente;
                c++;
            }
            if (c < tamaño)
                return puntero;
            else
                return "La lista no contiene la posición " + p + ".";
        } else
            return "La lista está vacía.";
    }

    @Override
    public void suprimir(Object e) {
        if (cabeza != null) {
            if (e == cabeza.getElemento())
                cabeza = cabeza.getSiguiente();
            else {
                Nodo elim = cabeza;
                for (int i = 0; i < tamaño; i++)
                    elim = elim.getSiguiente();
                Nodo sig = elim.getSiguiente();
                elim.setSiguiente(sig.getSiguiente());
            }
            tamaño--;
        }
    }

    @Override
    public void suprimir(int p) {
        if (p >= 0 && p < tamaño) {
            if (p == 0)
                cabeza = cabeza.getSiguiente();
            else {
                Nodo elim = cabeza;
                for (int i = 0; i < (p - 1); i++)
                    elim = elim.getSiguiente();
                Nodo sig = elim.getSiguiente();
                elim.setSiguiente(sig.getSiguiente());
            }
            tamaño--;
        }
    }

    @Override
    public void anula() {
        if (!esVacia()) {
            Nodo puntero = cabeza;
            int c = 0;
            while (puntero.siguiente == null) {
                Nodo elim = puntero;
                puntero = puntero.siguiente;
                elim = null;
                c++;
            }
            tamaño = 0;
        } else
            System.out.println("La lista esta vacía.");
    }

    @Override
    public void visualiza() {
        if (!esVacia()) {
            Nodo in = cabeza;
            int c = 0;
            while (c < tamaño && in != null) {
                System.out.println(c + ". " + in.getElemento());
                in = in.getSiguiente();
                c++;
            }
        } else
            System.out.println("Lista vacía.");
    }
}
