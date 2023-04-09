import java.util.Iterator;

public class Iterador implements Iterator<Object> {

    private Nodo nodo;

    public Iterador(Nodo nodo) {
        this.nodo = nodo;
    }

    @Override
    public boolean hasNext() {
        return this.nodo != null;
    }

    @Override
    public Object next() {
        Nodo aux = this.nodo;
        this.nodo = this.nodo.getSiguiente();
        return aux.getInfo();
    }
    
}