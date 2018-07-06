package ADTCola;

public interface Encolable {
    public Object obtInicio();
    public int tamaño();
    public void encolar(Object e);
    public Object quitar();
    public Object quitar(int n);
    public Object quitar(Object e);
    public Object localiza(int n);
    public Object localiza(Object e);
    public boolean esVacia();
    public void limpiar();
    public void visualiza();
}