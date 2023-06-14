import java.util.ArrayList;
import java.util.List;

public class TreeWithNode {
    private TreeNode root;
        
    public TreeWithNode() {
        this.root = null;
    }

    public int getInternalNodesSum() {
        return this.getInternalNodesSum(this.root);
    }

    private int getInternalNodesSum(TreeNode nodo_actual) {
        int sum = 0;
        if (nodo_actual != null) {
            if (nodo_actual.getLeft() != null || nodo_actual.getRight() != null) {
                int sum_left = this.getInternalNodesSum(nodo_actual.getLeft());
                int sum_right = this.getInternalNodesSum(nodo_actual.getRight());
                sum += nodo_actual.getValue() + sum_left + sum_right;
            }
        }
        return sum;
    }

    //O(N)
    public List<Integer> getElemAtLevel(int level) {
        ArrayList<Integer> elements = new ArrayList<>();

        this.addToElemAtLevel(this.root, elements, level, 0);
        return elements;
    }

    private void addToElemAtLevel(TreeNode nodo_actual, List<Integer> elements, int level, int actual_level) {
        if (nodo_actual != null) {
            if (actual_level == level) {
                elements.add(nodo_actual.getValue());
            } else {
                this.addToElemAtLevel(nodo_actual.getLeft(), elements, level, actual_level+1);
                this.addToElemAtLevel(nodo_actual.getRight(), elements, level, actual_level+1);
            }
        }
    }

    //O(N) Si es un arbol enredadera
    public Integer getMaxElem() {
        return this.getMaxElem(this.root);
    }

    private Integer getMaxElem(TreeNode nodo_actual) {
        if (nodo_actual != null) {
            TreeNode nodo_derecha = nodo_actual.getRight();

            if (nodo_derecha != null) {
                return this.getMaxElem(nodo_derecha);
            } else {
                return nodo_actual.getValue();
            }
        }
        return null;
    }

    //O(N)
    public List<Integer> getFrontera() {
        ArrayList<Integer> frontera = new ArrayList<>();

        this.addToFrontera(this.root, frontera);
        return frontera;
    }

    private void addToFrontera(TreeNode nodo_actual, List<Integer> frontera) {
        if (nodo_actual != null) {
            TreeNode nodo_izquierda = nodo_actual.getLeft();
            TreeNode nodo_derecha = nodo_actual.getRight();

            if (nodo_izquierda == null && nodo_derecha == null) {
                frontera.add(nodo_actual.getValue());
            } else {
                addToFrontera(nodo_izquierda, frontera);
                addToFrontera(nodo_derecha, frontera);
            }
        }
    }

    //O(N)
    public List<Integer> getLongestBranch() {
        ArrayList<Integer> longest_branch = new ArrayList<>();

        this.addToLongestBranch(this.root, longest_branch);
        return longest_branch;
    }

    private void addToLongestBranch(TreeNode nodo_actual, List<Integer> longest_branch) {
        if (nodo_actual != null) {
            longest_branch.add(nodo_actual.getValue());

            int height_left = this.getHeight(this.root.getLeft());
            int height_right = this.getHeight(this.root.getRight());

            if (height_left > height_right) {
                this.addToLongestBranch(nodo_actual.getLeft(), longest_branch);
            } else {
                this.addToLongestBranch(nodo_actual.getRight(), longest_branch);
            }
        }
    }

    //O(N)
    public int getHeight2() {
        int height_left = this.getHeight2(this.root.getLeft(), 0);
        int height_right = this.getHeight2(this.root.getRight(), 0);
        return Math.max(height_left, height_right);
    }

    private int getHeight2(TreeNode nodo_actual, int level) {
        if (nodo_actual != null) {
            int height_left = this.getHeight2(nodo_actual.getLeft(), level+1);
            int height_right = this.getHeight2(nodo_actual.getRight(), level+1);
            return Math.max(height_left, height_right);
        }
        return level;
    }

    //O(N)
    public int getHeight() {
        int height_left = this.getHeight(this.root.getLeft());
        int height_right = this.getHeight(this.root.getRight());
        return Math.max(height_left, height_right);
    }

    private int getHeight(TreeNode nodo_actual) {
        if (nodo_actual != null) {
            int sum = 0;
            int height_left = this.getHeight(nodo_actual.getLeft());
            int height_right = this.getHeight(nodo_actual.getRight());

            sum = Math.max(height_left, height_right) + 1;
            return sum;
        }
        return 0;
    }

    //O(N)
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

    //O(N)
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

    //O(N)
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

    //O(Log2 N)
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
            this.delete(nmd.getValue());

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
                /* nodo_padre.setRight(null); */
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

    //O(1)
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