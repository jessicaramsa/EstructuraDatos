package ADTPila;

public interface Apilable {
    public Object obtCima();
    public int tamaño();
    public int capMaxima();
    public void insertar(Object e);
    public void eliminar();
    public boolean pLlena();
    public boolean esVacia();
    public void limpiar();
    public void visualiza();
}