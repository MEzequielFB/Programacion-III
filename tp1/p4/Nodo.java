public class Nodo {
    private Object info;
    private Nodo siguiente;

    public Nodo() {
        this(null, null);
    }

    public Nodo(Object info, Nodo siguiente) {
        this.setInfo(info);
        this.setSiguiente(siguiente);
    }

    public Object getInfo() {
        return this.info;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}