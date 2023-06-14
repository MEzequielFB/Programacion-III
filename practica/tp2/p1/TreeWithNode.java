public class TreeWithNode {
    private TreeNode root;
        
    public TreeWithNode() {
        this.root = null;
    }

    public void printOrder() {
        this.printOrder(this.root);
    }

    private void printOrder(TreeNode nodo_actual) {
        if (nodo_actual != null) {
            this.printOrder(nodo_actual.getLeft());
            System.out.println(nodo_actual);
            this.printOrder(nodo_actual.getRight());
        }
    }

    public void printPreOrder() {
        this.printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode nodo_actual) {
        if (nodo_actual != null) {
            System.out.println(nodo_actual);
            this.printPreOrder(nodo_actual.getLeft());
            this.printPreOrder(nodo_actual.getRight());
        }
    }

    public void printPosOrder() {
        this.printPosOrder(this.root);
    }

    private void printPosOrder(TreeNode nodo_actual) {
        if (nodo_actual != null) {
            this.printPosOrder(nodo_actual.getLeft());
            this.printPosOrder(nodo_actual.getRight());
            System.out.println(nodo_actual);
        }
    }

    public boolean delete(Integer valor) {
        return this.delete(root, null, valor);
    }

    private boolean delete(TreeNode nodo_actual, TreeNode nodo_padre, Integer valor) {
        if (nodo_actual != null) {
            if (nodo_actual.getValue() > valor) {
                TreeNode nodo_izquierda = nodo_actual.getLeft();
                if (nodo_izquierda != null) {
                    return this.delete(nodo_izquierda, nodo_actual, valor);
                }
            } else if (nodo_actual.getValue() < valor) {
                TreeNode nodo_derecha = nodo_actual.getRight();
                if (nodo_derecha != null) {
                    return this.delete(nodo_derecha, nodo_actual, valor);
                }
            } else {
                if (nodo_actual.getLeft() == null && nodo_actual.getRight() == null) {
                    this.deleteExternalNode(nodo_actual, nodo_padre);
                } else if (nodo_actual.getLeft() != null && nodo_actual.getRight() != null) {
                    this.deleteTwoSonsNode(nodo_actual, nodo_padre);
                } else {
                    this.deleteOneSonNode(nodo_actual, nodo_padre);
                }

                return true;
            }
        }
        return false;
    }

    private void deleteOneSonNode(TreeNode nodo_actual, TreeNode nodo_padre) {
        TreeNode nodo_izquierda = nodo_actual.getLeft();
        TreeNode nodo_derecha = nodo_actual.getRight();

        if (nodo_padre == null) {
            if (nodo_izquierda != null) {
                this.root = nodo_izquierda;
            } else {
                this.root = nodo_actual.getRight();
            }
        } else {
            if (nodo_padre.getValue() > nodo_actual.getValue()) {
                if (nodo_izquierda != null) {
                    nodo_padre.setLeft(nodo_izquierda);
                } else {
                    nodo_padre.setLeft(nodo_derecha);
                }
            } else if (nodo_padre.getValue() < nodo_actual.getValue()) {
                if (nodo_izquierda != null) {
                    nodo_padre.setRight(nodo_izquierda);
                } else {
                    nodo_padre.setRight(nodo_derecha);
                }
            }
        }
    }

    private void deleteTwoSonsNode(TreeNode nodo_actual, TreeNode nodo_padre) {
        TreeNode nmd = this.getNMD(nodo_actual.getLeft(), nodo_actual);

        if (nmd != null) {
            if (nodo_padre == null) {
                this.root = nmd;
            } else {
                if (nodo_padre.getValue() > nmd.getValue()) {
                    nodo_padre.setLeft(nmd);
                } else {
                    nodo_padre.setRight(nmd);
                }
            }
            nmd.setLeft(nodo_actual.getLeft());
            nmd.setRight(nodo_actual.getRight());
        }
    }

    private TreeNode getNMD(TreeNode nodo_actual, TreeNode nodo_padre) {
        if (nodo_actual != null) {
            TreeNode nodo_derecha = nodo_actual.getRight();
            if (nodo_derecha != null) {
                return this.getNMD(nodo_derecha, nodo_actual);
            } else {
                nodo_padre.setRight(null);
                return nodo_actual;
            }
        }
        return null;
    }

    private void deleteExternalNode(TreeNode nodo_actual, TreeNode nodo_padre) {
        if (nodo_padre == null) {
            this.root = null;
        } else {
            if (nodo_padre.getValue() > nodo_actual.getValue()) {
                nodo_padre.setLeft(null);
            } else {
                nodo_padre.setRight(null);
            }
        }
    }

    //O(1)
    public boolean isEmpty() {
        return this.root == null;
    }

    //O(Log2 N)
    public boolean hasElem(Integer valor) {
        if (this.root != null) {
            if (this.root.getValue().equals(valor)) {
                return true;
            }
            return this.hasElem(root, valor);
        }
        return false;
    }

    private boolean hasElem(TreeNode nodo_actual, Integer valor) {
        Integer valor_nodo = nodo_actual.getValue();
        if (valor_nodo > valor) {
            TreeNode nodo_izquierda = nodo_actual.getLeft();

            if (nodo_izquierda != null) {
                return this.hasElem(nodo_izquierda, valor);
            }
        } else if (valor_nodo < valor) {
            TreeNode nodo_derecha = nodo_actual.getRight();

            if (nodo_derecha != null) {
                return this.hasElem(nodo_derecha, valor);
            }
        }
        return false;
    }

    public Integer getRoot() {
        return this.root.getValue();
    }
    
    //O(Log2 N)
    public void add(Integer valor) {
        if (this.root == null) {
            this.root = new TreeNode(valor);
        } else {
            this.add(root, valor);
        }
    }

    private void add(TreeNode nodo_actual, Integer valor) {
        if (nodo_actual.getValue() > valor) {
            TreeNode nodo_izquierda = nodo_actual.getLeft();

            if (nodo_izquierda == null) {
                nodo_actual.setLeft(new TreeNode(valor));
            } else {
                this.add(nodo_izquierda, valor);
            }
        } else if (nodo_actual.getValue() < valor) {
            TreeNode nodo_derecha = nodo_actual.getRight();

            if (nodo_derecha == null) {
                nodo_actual.setRight(new TreeNode(valor));
            } else {
                this.add(nodo_derecha, valor);
            }
        }
    }
}