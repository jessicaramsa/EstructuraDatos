package ADTCola;

public class NodoCola {
    Object elemento;
    NodoCola siguiente;

    public NodoCola(Object e) {
        this.elemento = e;
        this.siguiente = null;
    }

    public void setElemento(Object e) {
        this.elemento = e;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setSiguiente(NodoCola s) {
        this.siguiente = s;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }
}
