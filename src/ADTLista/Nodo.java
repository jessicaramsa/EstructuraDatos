package ADTLista;

public class Nodo {
    Object elemento;
    Nodo siguiente = null;

    public Nodo() {}

    public Nodo(Object e) {
        this.elemento = e;
    }

    public Nodo(Object e, Nodo n) {
        this.elemento = e;
        this.siguiente = n;
    }

    public void setElemento(Object e) {
        this.elemento = e;
    }

    public void setSiguiente(Nodo s) {
        this.siguiente = s;
    }

    public Object getElemento() {
        return elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}
