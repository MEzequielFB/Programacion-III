import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {

    private Node<T> node;

    public Iterador(Node<T> node) {
        this.node = node;
    }

    @Override
    public boolean hasNext() {
        return this.node != null;
    }

    @Override
    public T next() {
        Node<T> actual_node = this.node;
        this.node = this.node.getNext();
        return actual_node.getInfo();
    }
    
}
