public class Nodo {
    private Object info;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo() {
        this(null, null, null);
    }
    public Nodo(Object info) {
        this(info, null, null);
    }
    public Nodo(Object info, Nodo siguiente, Nodo anterior) {
        this.setInfo(info);
        this.setSiguiente(siguiente);
        this.setAnterior(anterior);
    }

    @Override
    public boolean equals(Object o) {
        try {
            Nodo otro_nodo = (Nodo) o;
            return this.getInfo().equals(otro_nodo.getInfo());
        }
        catch(Exception exc) {
            return false;
        }
    }

    public Object getInfo() {
        return this.info;
    }

    public Nodo getSiguiente() {
        return this.siguiente;
    }

    public Nodo getAnterior() {
        return this.anterior;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}