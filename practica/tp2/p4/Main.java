public class Main {
    public static void main(String[] args) {
        TreeWithNode tree = new TreeWithNode(3);
        tree.add(null);
        TreeNode root = tree.getRootNode();

        root.setLeft(new TreeNode(null));
        root.getLeft().setLeft(new TreeNode(14));
        root.getLeft().setRight(new TreeNode(null));
        root.getLeft().getRight().setLeft(new TreeNode(7));
        root.getLeft().getRight().setRight(new TreeNode(-5));

        root.setRight(new TreeNode(null));
        root.getRight().setLeft(new TreeNode(null));
        root.getRight().getLeft().setRight(new TreeNode(9));
        root.getRight().setRight(new TreeNode(20));

        System.out.println("Arbol:");
        tree.printPreOrder();

        tree.fillValues();
        System.out.println("\nArbol filleado:");
        tree.printPreOrder();
    }
}