public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}
	
	public T extractFront() {		
		if (this.first != null) {
            T first_info = this.first.getInfo();
            this.first =  this.first.getNext();

            return first_info;
        }
		return null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	public T get(int index) {
		int actual_position = 0;
        Node<T> actual_node = this.first;

        if (index >= 0) {
            while (actual_node != null) {
                if (actual_position == index) {
                    return actual_node.getInfo();
                }
                actual_node = actual_node.getNext();
                actual_position++;
            }
        }
		return null;
	}
	
	public int size() {
		int nodes_quantity = 0;
        Node<T> actual_node = this.first;

        while (actual_node != null) {
            nodes_quantity++;
            actual_node = actual_node.getNext();
        }
		return nodes_quantity;
	}
	
	@Override
	public String toString() {
        String nodes = "";
        Node<T> actual_node = this.first;

        while (actual_node != null) {
            nodes += actual_node + " | ";
            actual_node = actual_node.getNext();
        }
		return nodes;
	}
	
}