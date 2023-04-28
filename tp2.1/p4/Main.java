public class Main {
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        tree1.setRoot(null);
        Node root_tree = tree1.getRoot();

        //Tree root left root
        root_tree.setLeft(new Node(null));

        root_tree.getLeft().setLeft(new Node(14));
        root_tree.getLeft().setRight(new Node(null));

        root_tree.getLeft().getRight().setLeft(new Node(7));
        root_tree.getLeft().getRight().setRight(new Node(-5));

        //tree root right root
        root_tree.setRight(new Node(null));

        root_tree.getRight().setLeft(new Node(null));
        root_tree.getRight().setRight(new Node(20));

        root_tree.getRight().getLeft().setRight(new Node(9));

        //Complete the tree
        System.out.println("Incompleted tree:");
        tree1.printPreOrder();

        tree1.completeTree();

        System.out.println("\nCompleted tree:");
        tree1.printPreOrder();
    }
}