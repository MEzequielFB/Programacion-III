import java.util.Iterator;

public class Iterador implements Iterator<Object> {

    private Object elemento;

    public Iterador(Object elemento) {
        this.elemento = elemento;
    }

    @Override
    public boolean hasNext() {
        return this.elemento != null;
    }

    @Override
    public Object next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }
    
}