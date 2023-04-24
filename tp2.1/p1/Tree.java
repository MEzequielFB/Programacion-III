public class Tree {
    private Nodo root;
	
	public Tree() {
		this.root = null;
	}

    public boolean delete(Nodo actual, Integer value) {
        /* Nodo node_to_delete = this.getNode(this.root, value);
        if (node_to_delete != null) {
            if (node_to_delete.isExternalNode()) {

            }
            return true;
        } */
        if (actual != null) {
            if (actual.getValue() == value) {
                if (actual.isExternalNode()) {
                    
                }
                return true;
            } else if (actual.getValue() < value) {
                delete(actual.getRight(), value);
            } else if (actual.getValue() > value) {
                delete(actual.getLeft(), value);
            }
        }
        return false;
    }

    /* private Nodo getNode(Nodo actual, Integer value) {
        if (actual != null) {
            Integer actual_value = actual.getValue();
            if (actual_value == value) {
                return actual;
            }
            if (actual_value < value) {
                this.getNode(actual.getRight(), value);
            }
            if (actual_value > value) {
                this.getNode(actual.getLeft(), value);
            }
        }
        return null;
    } */

    public void insert(Integer value) {
		if (this.root == null) {
            this.root = new Nodo(value);
        } else {
            this.insert(this.root, value);
        }
	}
	
	private void insert(Nodo actual, Integer value) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				Nodo temp = new Nodo(value);
				actual.setLeft(temp);
			} else {
				insert(actual.getLeft(), value);
			}
		} else if (actual.getValue() < value) {
			if (actual.getRight() == null) { 
				Nodo temp = new Nodo(value);
				actual.setRight(temp);
			} else {
				insert(actual.getRight(), value);
			}
		}
	}

    public boolean hasElem(Nodo actual, Integer value) {
        if (actual != null) {
            Integer actual_value = actual.getValue();
            if (actual_value == value) {
                return true;
            }
            if (actual_value < value) {
                this.hasElem(actual.getRight(), value);
            }
            if (actual_value > value) {
                this.hasElem(actual.getLeft(), value);
            }
        }
        return false;
    }

    public Integer getMaxElem(Nodo actual, Nodo actual_father) {
        if (actual != null) {
            this.getMaxElem(actual.getRight(), actual);
        }
        if (actual_father == null) {
            return null;
        }
        return actual_father.getValue();
    }

    public void printOrder(Nodo actual) {
        if (actual != null) {
            this.printOrder(actual.getLeft());
            System.out.println(actual);
            this.printOrder(actual.getRight());
        }
    }

    public void printPostOrder(Nodo actual) {
        if (actual != null) {
            this.printPostOrder(actual.getLeft());
            this.printPostOrder(actual.getRight());
            System.out.println(actual);
        }
    }

    public void printPreOrder(Nodo actual) {
        if (actual != null) {
            System.out.println(actual);
            this.printPreOrder(actual.getLeft());
            this.printPreOrder(actual.getRight());
        }
    }

    public boolean isEmpty() {
        if (this.root != null) {
            return false;
        }
        return true;
    }

    public Integer getRoot() {
        if (this.root != null) {
            return this.root.getValue();
        }
        return null;
    }
}