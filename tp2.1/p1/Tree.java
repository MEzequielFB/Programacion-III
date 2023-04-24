public class Tree {
    private Nodo root;
	
	public Tree() {
		this.root = null;
	}

    private Nodo getNMD(Nodo actual) {
        if (actual != null && actual.getRight() != null) { //Condicion de corte
            this.getNMD(actual.getRight());
        }
        return actual;
    }

    //Para no romper encapsulamiento hago este metodo al que se pasa solo el valor y despues llama a otro delete que inicia desde el root del arbol
    public boolean delete(Integer value) {
        return this.delete(this.root, value, null);
    }

    private boolean delete(Nodo actual, Integer value, Nodo actual_father) {
        if (actual != null) { //Condicion de corte
            if (actual.getValue() == value) { //Si se encuentra el nodo con la clave ingresada...
                if (actual.getLeft() == null && actual.getRight() == null) { //Si el nodo a borrar no tiene hijos
                    deleteExternalNode(actual, actual_father);
                } else if (actual.getLeft() != null && actual.getRight() != null) { //Si el nodo a borrar tiene dos hijos
                    deleteTwoSonsNode(actual, actual_father);
                } else if (actual.getLeft() != null || actual.getRight() != null) { //Si el nodo a borrar tiene un solo hijo
                    deleteOneSonNode(actual, actual_father);
                }

                return true; //Retorna true porque se borra un nodo
            } else { //Si la clave del nodo actual no es igual al valor ingresado...
                if (actual.getValue() < value) { //Si la clave del nodo actual es mas chico...
                    this.delete(actual.getRight(), value, actual);
                } else { //Si la clave del nodo actual es mas grande...
                    this.delete(actual.getLeft(), value, actual);
                }
            }
        }
        return false; //Si no se borra nada devuelve false
    }

    private void deleteTwoSonsNode(Nodo actual, Nodo actual_father) {
        Nodo nmd = this.getNMD(actual.getLeft()); //Busca el nodo mas derecho del subarbol izquierdo

        this.delete(nmd.getValue()); //Elimina el nmd
        if (actual_father == null) { //Si se trata del root
            this.root = nmd; //Setea el nmd como el root
        } else { //Si se trata de un nodo interno, reacomoda el puntero, eliminando el nodo actual
            if (actual_father.getValue() < nmd.getValue()) {
                actual_father.setRight(nmd);
            } else {
                actual_father.setLeft(nmd);
            }
        }
        //Setea el left y right del nmd que reemplaza el lugar de actual
        nmd.setLeft(actual.getLeft());
        nmd.setRight(actual.getRight());
    }

    private void deleteOneSonNode(Nodo actual, Nodo actual_father) {
        if (actual_father == null) { //Si se trata del root...
            if (actual.getLeft() != null) {
                this.root = actual.getLeft(); //Setea como root al hijo de la izquierda
            } else {
                this.root = actual.getRight(); //Setea como root al hijo de la derecha
            }
        } else { //Si se trata de un nodo interno...
            if (actual_father.getValue() < actual.getValue()) { //Si el hijo es mas grande...
                if (actual.getRight() != null) {
                    actual_father.setRight(actual.getRight()); //Setea como su derecha al nodo derecho del hijo
                } else {
                    actual_father.setRight(actual.getLeft()); //Setea como su derecha al nodo izquierdo del hijo
                }
            } else {
                if (actual.getRight() != null) {
                    actual_father.setLeft(actual.getRight()); //Setea como su izquierda al nodo derecho del hijo
                } else {
                    actual_father.setLeft(actual.getLeft()); //Setea como su izquierda al nodo izquierdo del hijo
                }
            }
        }
    }

    private void deleteExternalNode(Nodo actual, Nodo actual_father) {
        if (actual_father == null) {
            this.root = null;
        } else {
            if (actual_father.getValue() < actual.getValue()) {
                actual_father.setRight(null);
            } else {
                actual_father.setLeft(null);
            }
        }
    }

    /* public boolean delete(Nodo actual, Integer value) {
        Nodo node_to_delete = this.getNode(this.root, value);
        if (node_to_delete != null) {
            if (node_to_delete.isExternalNode()) {

            }
            return true;
        }
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
    } */

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