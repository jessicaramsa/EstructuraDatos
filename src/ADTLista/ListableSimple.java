package ADTLista;

public interface ListableSimple {
    public int tamaño();
    public boolean esVacia();
    public ListaSimple insertarI(Object in);
    public ListaSimple insertar(Object e, int p);
    public ListaSimple insertarF(Object f);
    public int localiza(Object e);
    public Object localiza(int p);
    public Object anterior(int p);
    public Object siguiente(int p);
    public void suprimir(Object e);
    public void suprimir(int p);
    public void anula();
    public void visualiza();
}
