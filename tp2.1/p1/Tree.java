import java.util.LinkedList;

public class Tree {
    private Nodo root;
	
	public Tree() {
		this.root = null;
	}

    public LinkedList<Nodo> getBorder() {
        return this.getBorder(this.root);
    }

    private LinkedList<Nodo> getBorder(Nodo actual) {
        LinkedList<Nodo> external_nodes = new LinkedList<>();
        if (actual != null) {
            if (actual.getLeft() == null && actual.getRight() == null) {
                external_nodes.add(actual);
            } else {
                external_nodes.addAll(this.getBorder(actual.getLeft()));
                external_nodes.addAll(this.getBorder(actual.getRight()));
            }
        }
        return external_nodes;
    }

    public LinkedList<Nodo> getLongestBranch() {
        return this.getLongestBranch(this.root); //Llama al metodo empezando desde el root
    }

    private LinkedList<Nodo> getLongestBranch(Nodo actual) {
        LinkedList<Nodo> longest_branch = new LinkedList<>(); //Crea una lista vinculada
        if (actual != null) { //Si el actual no es null...
            longest_branch.add(actual); //Se agrega el actual a la lista

            //Se obtiene el alto de los subarboles del nodo actual
            int height_left = this.getHeight(this.root.getLeft());
            int height_right = this.getHeight(this.root.getRight());

            //Se compara el valor del alto de los subarboles. Si ambos valores son cero no se hace nada
            //Si el izquierdo es mayor o son iguales, se obtiene la rama mas larga del subarbol izquierdo
            //De lo contrario se obtiene la rama mas larga del subarbol derecho
            //Despues de obtener la rama se agregan sus valores a la rama actual
            if (height_left != 0 && height_right != 0) {
                if (height_left > height_right || height_left == height_right) {
                    longest_branch.addAll(this.getLongestBranch(actual.getLeft()));
                } else {
                    longest_branch.addAll(this.getLongestBranch(actual.getRight()));
                }
            }
        }
        return longest_branch; //Retorna la rama actual
    }

    public int getHeight() {
        return this.getHeight(this.root);
    }

    private int getHeight(Nodo actual) {
        if (actual != null) {
            int sum = 0;
            int height_left = this.getHeight(actual.getLeft());
            int height_right = this.getHeight(actual.getRight());
            sum = Math.max(height_left, height_right);
            return sum + 1;
        }
        return 0;
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

    public boolean hasElem(Integer value) {
        return this.hasElem(this.root, value);
    }

    private boolean hasElem(Nodo actual, Integer value) {
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

    /* public Integer getMaxElem(Nodo actual, Nodo actual_father) {
        if (actual != null) {
            this.getMaxElem(actual.getRight(), actual);
        }
        if (actual_father == null) {
            return null;
        }
        return actual_father.getValue();
    } */

    public Integer getMaxElem() {
        return this.getMaxElem(this.root);
    }

    private Integer getMaxElem(Nodo actual) {
        if (actual != null && actual.getRight() != null) {
            return this.getMaxElem(actual.getRight());
        }
        if (actual != null) {
            return actual.getValue();
        }
        return null;
    }

    public void printOrder() {
        this.printOrder(this.root);
    }

    private void printOrder(Nodo actual) {
        if (actual != null) {
            this.printOrder(actual.getLeft());
            System.out.println(actual);
            this.printOrder(actual.getRight());
        }
    }

    public void printPostOrder() {
        this.printPostOrder(this.root);
    }

    private void printPostOrder(Nodo actual) {
        if (actual != null) {
            this.printPostOrder(actual.getLeft());
            this.printPostOrder(actual.getRight());
            System.out.println(actual);
        }
    }

    public void printPreOrder() {
        this.printPreOrder(this.root);
    }

    private void printPreOrder(Nodo actual) {
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