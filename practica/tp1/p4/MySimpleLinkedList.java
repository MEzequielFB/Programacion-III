public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private Node<T> last;
	private int tamanio;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.tamanio = 0;
	}

	public int indexOf(T info) {
		Node<T> actual_node = this.first;
		int actual_position = 0;

		while (actual_position < this.tamanio) {
			if (actual_node.getInfo().equals(info)) {
				return actual_position;
			}

			actual_node = actual_node.getNext();
			actual_position++;
		}
		return -1;
	}

	public void reverse() {
        Node<T> last_original_node = this.last;
        int indice = this.tamanio - 2 ; //Indice antelast nodo

        while (indice >= 0) {
            Node<T> actual_node = this.getNode(indice);
            this.last.setNext(actual_node);
            this.last = actual_node;
            indice--;
        }
        this.last.setNext(null);
        this.first = last_original_node;
    }

	public T top() {
		if (this.last != null) {
			return this.last.getInfo();
		}
		return null;
	}
	
	public void push(T o) {
		Node<T> new_node = new Node<>(o, null);

		if (this.first == null) {
			this.first = new_node;
		} else {
			this.last.setNext(new_node);
		}

		this.tamanio++;
		this.last = new_node;
	}

	public T pop() {
		if (!this.isEmpty()) {
			Node<T> last_node = this.last;

			if (tamanio > 1) {
				this.last = this.getNode(tamanio-2);
				this.last.setNext(null);
			} else {
				this.first = null;
				this.last = null;
			}

			this.tamanio--;
			return last_node.getInfo();
		}
		return null;
	}

	private Node<T> getNode(int index) {
		int actual_position = 0;
		Node<T> actual_node = this.first;

		if (index >= 0) {
			while (actual_node != null) {
				if (actual_position == index) {
					return actual_node;
				}
				actual_node = actual_node.getNext();
				actual_position++;
			}
		}
		return null;
	}

	public boolean isEmpty() {
		return this.tamanio == 0;
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